package mdf.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mdf.dao.AgentHistoryUpdateDAO;
import mdf.dao.AgentUpdateDAO;
import mdf.dao.ContactUpdateDAO;
import mdf.forms.AgentDetailsFormBean;
import mdf.forms.AgentFormBean;
import mdf.forms.AgentHistoryDetailsFormBean;
import mdf.forms.CallDetailsFormBean;
import mdf.forms.ContactDetailsFormBean;
import mdf.forms.ContactFormBean;
import mdf.utils.DateUtil;
import mdf.utils.StatusConstants;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class ContactUpdateAction extends BaseAction {
    public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response)
        throws Exception {

        log.info("inside execute method for ContactUpdateAction");
        HttpSession session = request.getSession(false);
        AgentFormBean userBean = checkLogin(session);
        String userName = "";
        if (userBean== null) {
        	return mapping.findForward("login");
        }
        else userName = userBean.getAgent_name();

        ContactUpdateDAO contactDAO = new ContactUpdateDAO();

        ContactDetailsFormBean contactBean = (ContactDetailsFormBean)form;

        // lookup
        if (contactBean.getActionn().equalsIgnoreCase("lookup")) {
            if (!contactBean.getUi_name().equals("") ) {
                if (contactBean.getFirst_name().equals("") )
                    contactBean.setFirst_name(contactBean.getUi_name());
                if (contactBean.getLast_name().equals("") )
                    contactBean.setLast_name(contactBean.getUi_name());
                if (contactBean.getContact_name().equals("") )
                    contactBean.setContact_name(contactBean.getUi_name());
            }
            contactBean.setUi_number(cleanString(contactBean.getUi_number()));
            if (!contactBean.getUi_number().equals("") ) {
                if (contactBean.getPhone_work().equals("") )
                    contactBean.setPhone_work(contactBean.getUi_number());
                if (contactBean.getPhone_cell().equals("") )
                    contactBean.setPhone_cell(contactBean.getUi_number());
                if (contactBean.getPhone_home().equals("") )
                    contactBean.setPhone_home(contactBean.getUi_number());
            }
            if (!contactBean.getUi_email().equals("") ) {
                if (contactBean.getEmail_home().equals("") )
                    contactBean.setEmail_home(contactBean.getUi_email());
                if (contactBean.getEmail_work().equals("") )
                    contactBean.setEmail_work(contactBean.getUi_email());
            }

            List contactList = contactDAO.lookupContact(contactBean);
            //for (Iterator i = contactList.iterator(); i.hasNext();) {
            for (int i = 0; i< contactList.size(); i++) {
                ContactDetailsFormBean contact = (ContactDetailsFormBean) contactList.get(i);
                contact.setUi_name(contactBean.getUi_name());
                contact.setUi_number(contactBean.getUi_number());
                contact.setUi_email(contactBean.getUi_email());

                updateContactName(contact);
                updateContactNumber(contact);
                log.info(contact);
            }
            request.setAttribute("contactList", contactList);

            return(mapping.findForward("list_contacts"));
        } else if (contactBean.getActionn().equalsIgnoreCase("add")) {
            ContactDetailsFormBean contact = new ContactDetailsFormBean();
            form = contact;
            request.setAttribute("contactFormBean", contact);
            log.info("calling add_contact");
            return(mapping.findForward("edit_contact"));
        } else if (contactBean.getActionn().equalsIgnoreCase("edit")) {
            ContactDetailsFormBean contact = contactDAO.getContactDetails(contactBean.getContact_id());

            contact.setPrevious_agent_assigned(contact.getAgent_assigned());
            contact.setPrevious_status(contact.getStatus());
            form = contact;
            request.setAttribute("contactFormBean", contact);
            log.info("calling edit_contact" + contact);
            return(mapping.findForward("edit_contact"));
        } else if (contactBean.getActionn().equalsIgnoreCase("save")
        		|| contactBean.getActionn().equalsIgnoreCase("softDelete")) {
            Date currentDate = new Date();
            String currentDateString = DateUtil.formatDate(currentDate, "yyyy-MM-dd HH:mm");
            if (contactBean.getActionn().equalsIgnoreCase("softDelete")) {
            	contactBean.setDeleted(true);
            	contactBean.setDelete_dttm(currentDateString);
            } else {
            	contactBean.setDelete_dttm("1900-01-01 00:00");
            }

            // prepend status to status history
            contactBean.setStatus_history("To " + contactBean.getAgent_assigned() + "- By " + userName + " :" +
                    contactBean.getStatus() + " : " + DateUtil.formatDate(currentDate, "MM/dd HH:mm") + "\n" +
                    contactBean.getStatus_history());
            //updateContactName
            updateContactName(contactBean);
            //cleanContactNumber
            updateContactNumber(contactBean);
            // update agent statuses
            updateAgentStatuses(contactBean);
            contactBean.setUpdated_by(userName);
            contactBean.setUpdate_dttm(currentDateString);
            updateAgentHistory(contactBean, userBean);
            if (contactBean.getContact_id() != 0) {
                //contactDAO.saveContactDetails(contactBean, "first_name,last_name");
                contactDAO.saveContactDetails(contactBean);
            } else {
                String insert_key = userName + DateUtil.formatDate(currentDate, "MMddyyHHmmss");

                contactBean.setInsert_key(insert_key);
                contactBean.setAdd_dttm(currentDateString);
                contactBean.setCreated_by(userName);

                contactDAO.addContactDetails(contactBean);
                contactBean = (ContactDetailsFormBean)contactDAO.getContactInfoByInsertKey(contactBean.getInsert_key());
            }
            contactBean.setPrevious_agent_assigned(contactBean.getAgent_assigned());
            contactBean.setPrevious_status(contactBean.getStatus());

            request.setAttribute("contactFormBean", contactBean);
            log.info("calling save_contact");
            return(mapping.findForward("edit_contact"));
        } else if (contactBean.getActionn().equalsIgnoreCase("saveContactForCall")) {
            CallDetailsFormBean callFormBean = (CallDetailsFormBean) session.getAttribute("callFormBean");
            Date currentDate = new Date();
            String currentDateString = DateUtil.formatDate(currentDate, "yyyy-MM-dd HH:mm");
            
            contactBean.setUpdate_dttm(currentDateString);
            contactBean.setUpdated_by(userName);
            if (contactBean.getContact_id() != 0) {
                //contactDAO.saveContactDetails(contactBean, "first_name,last_name");
                contactDAO.saveContactDetails(contactBean);
            } else {
                String insert_key = "KKV" + DateUtil.formatDate(currentDate, "MMddyyHHmmss");
                contactBean.setInsert_key(insert_key);
                contactBean.setAdd_dttm(currentDateString);
                contactBean.setDelete_dttm("1900-01-01 00:00");
                contactBean.setCreated_by(userName);

                contactDAO.addContactDetails(contactBean);
                contactBean = (ContactDetailsFormBean)contactDAO.getContactInfoByInsertKey(contactBean.getInsert_key());
            }
            callFormBean.setContact_id(contactBean.getContact_id());;
            callFormBean.setContactForm(contactBean);
            request.setAttribute("contactFormBean", contactBean);
            session.setAttribute("callFormBean", callFormBean);
            log.info("calling save_contact");
            return(mapping.findForward("edit_call"));
        } else if (contactBean.getActionn().equalsIgnoreCase("delete")) {
            contactDAO.deleteContactDetails(contactBean.getContact_id());
            log.info("calling delete_contact");
            return(mapping.findForward("delete_contact"));
        } else {
            return(mapping.findForward("success"));
        }
    }

    private void updateContactName(ContactDetailsFormBean contact) {
        if (!contact.getContact_name().equals("") ) {
        	if (contact.getContact_name().indexOf('/') > 0) {
        		// lastname/firstName format
	            if (contact.getFirst_name().equals("")) {
	            	int i = contact.getContact_name().indexOf('/');
	                contact.setFirst_name(contact.getContact_name().substring(i));
	            }
	            // update last name from contact name if blank
	            if (contact.getLast_name().equals("")) {
	            	int i = contact.getContact_name().lastIndexOf('/');
	                contact.setLast_name(contact.getContact_name().substring(0, i));
	            }
        	} else { // not LastName/FirstName format 
	        	// update first name from contact name if blank
	            if (contact.getFirst_name().equals("")) {
	            	int i = contact.getContact_name().lastIndexOf(' ');
	            	if (i <0) i = contact.getContact_name().length();
	                contact.setFirst_name(contact.getContact_name().substring(0, i));
	            }
	            // update last name from contact name if blank
	            if (contact.getLast_name().equals("")) {
	            	int i = contact.getContact_name().lastIndexOf(' ');
	            	if (i>=0)
	            		contact.setLast_name(contact.getContact_name().substring(i));
	            }
        	}
        } else {
        	// update contact name fron first and last names
            contact.setContact_name(contact.getFirst_name() + " " + contact.getMiddle_name() + " " + contact.getLast_name());
        }
        //cell phone, work phone, home phone
        if (!contact.getPhone_cell().equals(""))
            contact.setContact_phone(contact.getPhone_cell());
        else if (!contact.getPhone_work().equals(""))
            contact.setContact_phone(contact.getPhone_work());
        else if (!contact.getPhone_home().equals(""))
            contact.setContact_phone(contact.getPhone_home());
        //home email, work email
        if (!contact.getEmail_home().equals(""))
            contact.setContact_email(contact.getEmail_home());
        else if (!contact.getEmail_work().equals(""))
            contact.setContact_email(contact.getEmail_work());

    }

    private void updateContactNumber(ContactDetailsFormBean contact) {
        System.out.println("inside update contact number");
        contact.setUi_number(cleanString(contact.getUi_number()));
        contact.setContact_phone(cleanString(contact.getContact_phone()));
        contact.setPhone_cell(cleanString(contact.getPhone_cell()));
        contact.setPhone_home(cleanString(contact.getPhone_home()));
        contact.setPhone_work(cleanString(contact.getPhone_work()));

    }

    private String cleanString(String original) {
        System.out.println("inside update contact number");

        String replacement = "";

        for (int i = 0; i < original.length(); i ++) {
            if (original.charAt(i) != '+' && original.charAt(i) != '-' && original.charAt(i) != ' ' && original.charAt(i) != '(' && original.charAt(i) != ')' && original.charAt(i) != '.') {
                replacement += original.charAt(i);
            }
            if (replacement.startsWith("001")) replacement = replacement.substring(3);
            if (replacement.startsWith("1")) replacement = replacement.substring(1);
        }
        System.out.println("old:" + original + "::new:" +replacement);

        return replacement;
    }

    private void updateAgentStatuses(ContactFormBean contactBean) {
        try {
            String previousState = (String)StatusConstants.stateMap.get(contactBean.getPrevious_status());
            String currentState = (String)StatusConstants.stateMap.get(contactBean.getStatus());

            log.info(new Integer(contactBean.getContact_id()));
            log.info("Previous Agent" + contactBean.getPrevious_agent_assigned());
            log.info("New Agent" + contactBean.getAgent_assigned());
            log.info("Previous status" + contactBean.getPrevious_status());
            log.info("New Status" + contactBean.getStatus());
            log.info("Previous state" + previousState);
            log.info("New State" + currentState);
            
            AgentUpdateDAO agentDAO = new AgentUpdateDAO();
            // check if request was previously assigned to another agent
            if (!contactBean.getPrevious_agent_assigned().equals("") &&
                    !contactBean.getAgent_assigned().equals(contactBean.getPrevious_agent_assigned())) {
                // remove assignment from previous agent and allocate to new agent
                AgentFormBean previousAgentBean = agentDAO.getAgentInfoByName(contactBean.getPrevious_agent_assigned());
                AgentFormBean currentAgentBean = agentDAO.getAgentInfoByName(contactBean.getAgent_assigned());
                previousAgentBean.setTransferred_customers(previousAgentBean.getTransferred_customers()+1);
                previousAgentBean.setTotal_updates(previousAgentBean.getTotal_updates()+1);

                if (StatusConstants.STATE_FAILED.equals(previousState)) {
                	previousAgentBean.setFailed_customers(previousAgentBean.getFailed_customers()-1);
                	
                } else if (StatusConstants.STATE_ITIN.equals(previousState)) {
                    previousAgentBean.setPending_itinerary(previousAgentBean.getPending_itinerary()-1);

                } else if (StatusConstants.STATE_FOLLOWUP.equals(previousState)) {
                    previousAgentBean.setPending_followup(previousAgentBean.getPending_followup()-1);

                } else if (StatusConstants.STATE_DOCS.equals(previousState)) {
                    previousAgentBean.setPending_docs(previousAgentBean.getPending_docs()-1);

                } else if (StatusConstants.STATE_CLOSED.equals(previousState)) {
                }

                if (StatusConstants.STATE_FAILED.equals(currentState)) {
                	currentAgentBean.setFailed_customers(currentAgentBean.getFailed_customers()+1);
                	
                } else if (StatusConstants.STATE_ITIN.equals(currentState)) {
                	currentAgentBean.setPending_itinerary(currentAgentBean.getPending_itinerary()+1);

                } else if (StatusConstants.STATE_FOLLOWUP.equals(currentState)) {
                	currentAgentBean.setPending_followup(currentAgentBean.getPending_followup()+1);

                } else if (StatusConstants.STATE_DOCS.equals(currentState)) {
                	currentAgentBean.setPending_docs(currentAgentBean.getPending_docs()+1);

                } else if (StatusConstants.STATE_CLOSED.equals(currentState)) {
                }

                previousAgentBean.setOpen_customers(previousAgentBean.getPending_itinerary() + previousAgentBean.getPending_followup() + previousAgentBean.getPending_docs());
                currentAgentBean.setOpen_customers(currentAgentBean.getPending_itinerary() + currentAgentBean.getPending_followup() + currentAgentBean.getPending_docs());

                agentDAO.saveAgentDetails((AgentDetailsFormBean)previousAgentBean);
                agentDAO.saveAgentDetails((AgentDetailsFormBean)currentAgentBean);

            } else {
                // agent is same or new request for our agent, update status for agent
                if (!currentState.equals(previousState)) {
                    AgentFormBean agentBean = agentDAO.getAgentInfoByName(contactBean.getAgent_assigned());
                    if (!"".equals(previousState)) {
                        agentBean.setTotal_updates(agentBean.getTotal_updates()+1);
                    }

                    if (StatusConstants.STATE_FAILED.equals(currentState)) {
                    	agentBean.setFailed_customers(agentBean.getFailed_customers()+1);
                    
                    } else if (StatusConstants.STATE_ITIN.equals(currentState)) {
                    	agentBean.setPending_itinerary(agentBean.getPending_itinerary()+1);
                    
                    } else if (StatusConstants.STATE_FOLLOWUP.equals(currentState)) {
                    	agentBean.setPending_followup(agentBean.getPending_followup()+1);
                    
                    } else if (StatusConstants.STATE_DOCS.equals(currentState)) {
                    	agentBean.setPending_docs(agentBean.getPending_docs()+1);
                    
                    } else if (StatusConstants.STATE_CLOSED.equals(currentState)) {
                    }
                    
                    if (StatusConstants.STATE_FAILED.equals(previousState)) {
                    	agentBean.setFailed_customers(agentBean.getFailed_customers()-1);
                    
                    } else if (StatusConstants.STATE_ITIN.equals(previousState)) {
                    	agentBean.setPending_itinerary(agentBean.getPending_itinerary()-1);
                    
                    } else if (StatusConstants.STATE_FOLLOWUP.equals(previousState)) {
                    	agentBean.setPending_followup(agentBean.getPending_followup()-1);
                    
                    } else if (StatusConstants.STATE_DOCS.equals(previousState)) {
                    	agentBean.setPending_docs(agentBean.getPending_docs()-1);
                    
                    } else if (StatusConstants.STATE_CLOSED.equals(previousState)) {
                    }

                    agentBean.setOpen_customers(agentBean.getPending_itinerary() + agentBean.getPending_followup() + agentBean.getPending_docs());
                    
                    agentDAO.saveAgentDetails((AgentDetailsFormBean)agentBean);
                }
            }
        } catch (Exception ex) {
            log.error("Exception:::" + ex);
        }
    }

	private void updateAgentHistory(ContactFormBean contactBean, AgentFormBean userBean) {
	    try {
	    	log.info("Inside updateAgentHistory");
	    	AgentHistoryDetailsFormBean agentHistoryBean = new AgentHistoryDetailsFormBean();
	    	AgentHistoryUpdateDAO agentHistoryDAO = new AgentHistoryUpdateDAO();
	        
	    	agentHistoryBean.setAgent_id(userBean.getAgent_id());
	    	agentHistoryBean.setAgent_name(userBean.getAgent_name());
	    	agentHistoryBean.setContact_id(contactBean.getContact_id());
	    	agentHistoryBean.setOld_agent(contactBean.getPrevious_agent_assigned());
	    	agentHistoryBean.setNew_agent(contactBean.getAgent_assigned());
	    	agentHistoryBean.setOld_status(contactBean.getPrevious_status());
	    	agentHistoryBean.setNew_status(contactBean.getStatus());
	    	agentHistoryBean.setAdd_dttm(contactBean.getUpdate_dttm());
	    	
	    	agentHistoryDAO.addAgentHistoryDetails((AgentHistoryDetailsFormBean)agentHistoryBean);
	    } catch (Exception ex) {
	        log.error("Exception:::" + ex);
	    }
	}

}
