package mdf.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mdf.dao.AgentUpdateDAO;
import mdf.dao.ContactUpdateDAO;
import mdf.forms.AgentDetailsFormBean;
import mdf.forms.AgentFormBean;
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
		
		ContactUpdateDAO contactDAO = new ContactUpdateDAO();
	    
        HttpSession session = request.getSession(false);
        
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
	    			contactBean.setEmail_home(contactBean.getUi_name());
	    		if (contactBean.getEmail_work().equals("") )
	    			contactBean.setEmail_work(contactBean.getUi_name());
	    	}
	    	
	    	List contactList = contactDAO.lookupContact(contactBean);
	    	//for (Iterator i = contactList.iterator(); i.hasNext();) {
	    	for (int i = 0; i< contactList.size(); i++) {
	    		ContactDetailsFormBean contact = (ContactDetailsFormBean) contactList.get(i);
	    		contact.setUi_name(contactBean.getUi_name());
	    		contact.setUi_number(contactBean.getUi_number());
	    		contact.setUi_email(contactBean.getUi_email());
	    		
		    	updateContactName(contact);
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
	    } else if (contactBean.getActionn().equalsIgnoreCase("save")) {
    		// prepend status to status history
    		contactBean.setStatus_history(contactBean.getAgent_assigned() + "-" + 
    				contactBean.getStatus() + "\n" +
    				contactBean.getStatus_history());
    		
    		//updateContactName
    		updateContactName(contactBean);
    		// update agent statuses
    		updateAgentStatuses(contactBean);
	    	if (contactBean.getContact_id() != 0) {
	    		//contactDAO.saveContactDetails(contactBean, "first_name,last_name");
	    		
	    		contactDAO.saveContactDetails(contactBean);
	    	} else {
	    		Date currentDate = new Date();
	    		String insert_key = "KKV" + DateUtil.formatDate(currentDate, "MMddyyHHmmss");
	    		
	    		contactBean.setInsert_key(insert_key);
	    		contactBean.setAdd_dttm(currentDate);
	    		contactBean.setUpdate_dttm(currentDate);
	    		contactBean.setDelete_dttm(null);
	    		
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
	    	if (contactBean.getContact_id() != 0) {
	    		//contactDAO.saveContactDetails(contactBean, "first_name,last_name");
	    		contactDAO.saveContactDetails(contactBean);
	    	} else {
	    		Date currentDate = new Date();
	    		String insert_key = "KKV" + DateUtil.formatDate(currentDate, "MMddyyHHmmss");
	    		contactBean.setInsert_key(insert_key);
	    		contactBean.setAdd_dttm(currentDate);
	    		contactBean.setUpdate_dttm(currentDate);
	    		contactBean.setDelete_dttm(null);
	    		
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
			if (contact.getFirst_name().equals(""))
				contact.setFirst_name(contact.getContact_name());
		} else {
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

	private void updateAgentStatuses(ContactFormBean contactBean) {
		try {
			log.info(new Integer(contactBean.getContact_id()));
			log.info("Previous Agent" + contactBean.getPrevious_agent_assigned());
			log.info("New Agent" + contactBean.getAgent_assigned());
			log.info("Previous status" + contactBean.getPrevious_status());
			log.info("New Status" + contactBean.getStatus());
			AgentUpdateDAO agentDAO = new AgentUpdateDAO();
			// check if request was previously assigned to another agent 
			if (!contactBean.getPrevious_agent_assigned().equals("") &&
					!contactBean.getAgent_assigned().equals(contactBean.getPrevious_agent_assigned())) {
				// remove assignment from previous agent and allocate to new agent
				AgentFormBean previousAgentBean = agentDAO.getAgentInfoByName(contactBean.getPrevious_agent_assigned());
				AgentFormBean currentAgentBean = agentDAO.getAgentInfoByName(contactBean.getAgent_assigned());
				previousAgentBean.setTransferred_customers(previousAgentBean.getTransferred_customers()+1);
				currentAgentBean.setTotal_customers(currentAgentBean.getTotal_customers()+1);
				
				if (StatusConstants.CUSTOMER_LOST.equals(contactBean.getPrevious_status())) {
					previousAgentBean.setLost_customers(previousAgentBean.getLost_customers()-1);
				} else if (StatusConstants.DATE_CHANGE_REQUESTED_TO_PREPARE_ITIN.equals(contactBean.getPrevious_status())) {
					previousAgentBean.setOpen_customers(previousAgentBean.getOpen_customers()-1);
				} else if (StatusConstants.DOCUMENT_EMAILED_TO_FEDEX_DOCS.equals(contactBean.getPrevious_status())) {
					;
				} else if (StatusConstants.FARE_QUOTE_GIVEN_FOLLOWUP_TO_BE_DONE.equals(contactBean.getPrevious_status())) {
					previousAgentBean.setOpen_customers(previousAgentBean.getOpen_customers()-1);
				} else if (StatusConstants.FEDEX_SENT_TO_CLOSE.equals(contactBean.getPrevious_status())) {
					previousAgentBean.setClosed_customers(previousAgentBean.getClosed_customers()-1);
				} else if (StatusConstants.FOLLOWUP_TO_BE_DONE.equals(contactBean.getPrevious_status())) {
					previousAgentBean.setOpen_customers(previousAgentBean.getOpen_customers()-1);
				} else if (StatusConstants.ITINERARY_GIVEN_FOLLOWUP_TO_BE_DONE.equals(contactBean.getPrevious_status())) {
					previousAgentBean.setOpen_customers(previousAgentBean.getOpen_customers()-1);
				} else if (StatusConstants.REQUEST_RECEIVED_TO_GIVE_FARE_QUOTE.equals(contactBean.getPrevious_status())) {
					previousAgentBean.setOpen_customers(previousAgentBean.getOpen_customers()-1);
				} else if (StatusConstants.REQUEST_RECEIVED_TO_PREPARE_ITIN.equals(contactBean.getPrevious_status())) {
					previousAgentBean.setOpen_customers(previousAgentBean.getOpen_customers()-1);
				} else if (StatusConstants.TICKET_ISSUED_TO_SEND_DOCS.equals(contactBean.getPrevious_status())) {
					previousAgentBean.setTicketed_customers(previousAgentBean.getTicketed_customers()-1);
				}
				
				if (StatusConstants.CUSTOMER_LOST.equals(contactBean.getStatus())) {
					currentAgentBean.setLost_customers(currentAgentBean.getLost_customers()+1);
				} else if (StatusConstants.DATE_CHANGE_REQUESTED_TO_PREPARE_ITIN.equals(contactBean.getStatus())) {
					currentAgentBean.setOpen_customers(currentAgentBean.getOpen_customers()+1);
				} else if (StatusConstants.DOCUMENT_EMAILED_TO_FEDEX_DOCS.equals(contactBean.getStatus())) {
					;
				} else if (StatusConstants.FARE_QUOTE_GIVEN_FOLLOWUP_TO_BE_DONE.equals(contactBean.getStatus())) {
					currentAgentBean.setOpen_customers(currentAgentBean.getOpen_customers()+1);
				} else if (StatusConstants.FEDEX_SENT_TO_CLOSE.equals(contactBean.getStatus())) {
					currentAgentBean.setClosed_customers(currentAgentBean.getClosed_customers()+1);
				} else if (StatusConstants.FOLLOWUP_TO_BE_DONE.equals(contactBean.getStatus())) {
					currentAgentBean.setOpen_customers(currentAgentBean.getOpen_customers()+1);
				} else if (StatusConstants.ITINERARY_GIVEN_FOLLOWUP_TO_BE_DONE.equals(contactBean.getStatus())) {
					currentAgentBean.setOpen_customers(currentAgentBean.getOpen_customers()+1);
				} else if (StatusConstants.REQUEST_RECEIVED_TO_GIVE_FARE_QUOTE.equals(contactBean.getStatus())) {
					currentAgentBean.setOpen_customers(currentAgentBean.getOpen_customers()+1);
				} else if (StatusConstants.REQUEST_RECEIVED_TO_PREPARE_ITIN.equals(contactBean.getStatus())) {
					currentAgentBean.setOpen_customers(currentAgentBean.getOpen_customers()+1);
				} else if (StatusConstants.TICKET_ISSUED_TO_SEND_DOCS.equals(contactBean.getStatus())) {
					currentAgentBean.setTicketed_customers(currentAgentBean.getTicketed_customers()+1);
				}
				agentDAO.saveAgentDetails((AgentDetailsFormBean)previousAgentBean);
				agentDAO.saveAgentDetails((AgentDetailsFormBean)currentAgentBean);
				
			} else {
				// agent is same or new request for our agent, update status for agent
				if (!contactBean.getStatus().equals(contactBean.getPrevious_status())) {
					AgentFormBean agentBean = agentDAO.getAgentInfoByName(contactBean.getAgent_assigned());
					if (StatusConstants.CUSTOMER_LOST.equals(contactBean.getStatus())) {
						// if previously open status, reduce count of open customers
						if (StatusConstants.DATE_CHANGE_REQUESTED_TO_PREPARE_ITIN.equals(contactBean.getStatus())
								|| StatusConstants.FARE_QUOTE_GIVEN_FOLLOWUP_TO_BE_DONE.equals(contactBean.getStatus())
								|| StatusConstants.FOLLOWUP_TO_BE_DONE.equals(contactBean.getStatus())
								|| StatusConstants.ITINERARY_GIVEN_FOLLOWUP_TO_BE_DONE.equals(contactBean.getStatus())
								|| StatusConstants.REQUEST_RECEIVED_TO_GIVE_FARE_QUOTE.equals(contactBean.getStatus())
								|| StatusConstants.REQUEST_RECEIVED_TO_PREPARE_ITIN.equals(contactBean.getStatus())
								) {
							agentBean.setOpen_customers(agentBean.getOpen_customers()-1);
							agentBean.setLost_customers(agentBean.getLost_customers()+1);
						}
					} else if (StatusConstants.DATE_CHANGE_REQUESTED_TO_PREPARE_ITIN.equals(contactBean.getStatus())) {
						;
					} else if (StatusConstants.DOCUMENT_EMAILED_TO_FEDEX_DOCS.equals(contactBean.getStatus())) {
						;
					} else if (StatusConstants.FARE_QUOTE_GIVEN_FOLLOWUP_TO_BE_DONE.equals(contactBean.getStatus())) {
						;
					} else if (StatusConstants.FEDEX_SENT_TO_CLOSE.equals(contactBean.getStatus())) {
						agentBean.setClosed_customers(agentBean.getClosed_customers()+1);
					} else if (StatusConstants.FOLLOWUP_TO_BE_DONE.equals(contactBean.getStatus())) {
						;
					} else if (StatusConstants.ITINERARY_GIVEN_FOLLOWUP_TO_BE_DONE.equals(contactBean.getStatus())) {
						;
					} else if (StatusConstants.REQUEST_RECEIVED_TO_GIVE_FARE_QUOTE.equals(contactBean.getStatus())) {
						if (!StatusConstants.REQUEST_RECEIVED_TO_PREPARE_ITIN.equals(contactBean.getPrevious_status())) {
							agentBean.setOpen_customers(agentBean.getOpen_customers()+1);
							agentBean.setTotal_customers(agentBean.getTotal_customers()+1);
						}
					} else if (StatusConstants.REQUEST_RECEIVED_TO_PREPARE_ITIN.equals(contactBean.getStatus())) {
						if (!StatusConstants.REQUEST_RECEIVED_TO_GIVE_FARE_QUOTE.equals(contactBean.getPrevious_status())) {
							agentBean.setOpen_customers(agentBean.getOpen_customers()+1);
							agentBean.setTotal_customers(agentBean.getTotal_customers()+1);
						}
					} else if (StatusConstants.TICKET_ISSUED_TO_SEND_DOCS.equals(contactBean.getStatus())) {
						agentBean.setTicketed_customers(agentBean.getTicketed_customers()+1);
						agentBean.setOpen_customers(agentBean.getOpen_customers()-1);
					}
					agentDAO.saveAgentDetails((AgentDetailsFormBean)agentBean);
				}
			}
		} catch (Exception ex) {
			log.error("Exception:::" + ex);
		}
	}
	
}
