package mdf.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mdf.dao.ContactUpdateDAO;
import mdf.dao.TicketUpdateDAO;
import mdf.forms.AgentFormBean;
import mdf.forms.AirlineInfoFormBean;
import mdf.forms.ContactDetailsFormBean;
import mdf.forms.TicketDetailsFormBean;
import mdf.forms.TicketFormBean;
import mdf.object.TicketingLine;
import mdf.utils.Constants;
import mdf.utils.DateUtil;
import mdf.utils.TicketDataParser;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class TicketUpdateAction extends BaseAction {
    public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response)
        throws Exception {
	
	        log.info("inside execute method for TicketUpdateAction");
	        HttpSession session = request.getSession(false);
	        AgentFormBean userBean = checkLogin(session);
	        String userName = "";
	        if (userBean== null) {
	        	return mapping.findForward("login");
	        }
	        else userName = userBean.getAgent_name();
	
	        TicketUpdateDAO ticketDAO = new TicketUpdateDAO();
	
	        TicketDetailsFormBean ticketBean = (TicketDetailsFormBean)form;
	
	        // lookup
	        if (ticketBean.getActionn().equalsIgnoreCase("lookup")) {
	            if (!ticketBean.getUi_name().equals("") ) {
	                if (ticketBean.getBill_to().equals("") )
	                    ticketBean.setBill_to(ticketBean.getUi_name());
	                if (ticketBean.getMail_to().equals("") )
	                    ticketBean.setMail_to(ticketBean.getUi_name());
	                if (ticketBean.getPax1First_name().equals("") )
	                    ticketBean.setPax1First_name(ticketBean.getUi_name());
	                if (ticketBean.getPax1Last_name().equals("") )
	                    ticketBean.setPax1Last_name(ticketBean.getUi_name());
	                if (ticketBean.getPax1Middle_name().equals("") )
	                    ticketBean.setPax1Middle_name(ticketBean.getUi_name());
	                
	                if (ticketBean.getPax2First_name().equals("") )
	                    ticketBean.setPax2First_name(ticketBean.getUi_name());
	                if (ticketBean.getPax2Last_name().equals("") )
	                    ticketBean.setPax2Last_name(ticketBean.getUi_name());
                if (ticketBean.getPax2Middle_name().equals("") )
                    ticketBean.setPax2Middle_name(ticketBean.getUi_name());
                
                if (ticketBean.getPax3First_name().equals("") )
                    ticketBean.setPax3First_name(ticketBean.getUi_name());
                if (ticketBean.getPax3Last_name().equals("") )
                    ticketBean.setPax3Last_name(ticketBean.getUi_name());
                if (ticketBean.getPax3Middle_name().equals("") )
                    ticketBean.setPax3Middle_name(ticketBean.getUi_name());
                
                if (ticketBean.getPax4First_name().equals("") )
                    ticketBean.setPax4First_name(ticketBean.getUi_name());
                if (ticketBean.getPax4Last_name().equals("") )
                    ticketBean.setPax4Last_name(ticketBean.getUi_name());
                if (ticketBean.getPax4Middle_name().equals("") )
                    ticketBean.setPax4Middle_name(ticketBean.getUi_name());
                
                if (ticketBean.getPax5First_name().equals("") )
                    ticketBean.setPax5First_name(ticketBean.getUi_name());
                if (ticketBean.getPax5Last_name().equals("") )
                    ticketBean.setPax5Last_name(ticketBean.getUi_name());
                if (ticketBean.getPax5Middle_name().equals("") )
                    ticketBean.setPax5Middle_name(ticketBean.getUi_name());
                
            }

            List ticketList = ticketDAO.lookupTicket(ticketBean);
            //for (Iterator i = ticketList.iterator(); i.hasNext();) {
            for (int i = 0; i< ticketList.size(); i++) {
                TicketDetailsFormBean ticket = (TicketDetailsFormBean) ticketList.get(i);
                ticket.setUi_name(ticketBean.getUi_name());
                ticket.setUi_number(ticketBean.getUi_number());
                ticket.setUi_email(ticketBean.getUi_email());

                log.info(ticket);
            }
            request.setAttribute("ticketList", ticketList);

            return(mapping.findForward("list_tickets"));
        } else if (ticketBean.getActionn().equalsIgnoreCase("lookupByContact")) {
        	List ticketList = ticketDAO.lookupTicket(ticketBean);
        	for (int i = 0; i< ticketList.size(); i++) {
        		TicketDetailsFormBean ticket = (TicketDetailsFormBean) ticketList.get(i);
        		ticket.setUi_name(ticketBean.getUi_name());
        		ticket.setUi_number(ticketBean.getUi_number());
        		ticket.setUi_email(ticketBean.getUi_email());
        		
        		log.info(ticket);
        	}
        	request.setAttribute("ticketList", ticketList);

            return(mapping.findForward("list_contact_tickets"));
        } else if (ticketBean.getActionn().equalsIgnoreCase("add")) {
            TicketDetailsFormBean ticket = new TicketDetailsFormBean();
        	Date currentDate = new Date();
            String currentDateString = DateUtil.formatDate(currentDate, "MM/dd/yyyy");
            ticket.setIssue_date(currentDateString);
    		// constant values
    		ticket.setBranch_id(1);
    		ticket.setReceivedBy("Kaushik");

            if (ticketBean.getContact_id() != 0) {
            	ticket.setContact_id(ticketBean.getContact_id());
            	updateTicketContactInfo(ticket, session);
            }
            form = ticket;
            request.setAttribute("ticketFormBean", ticket);
            log.info("calling add_ticket" + ticket);
            return(mapping.findForward("edit_ticket"));
        } else if (ticketBean.getActionn().equalsIgnoreCase("edit")) {
            TicketDetailsFormBean ticket = ticketDAO.getTicketDetails(ticketBean.getTicket_id());
        	updateTicketingData(ticket, userName);
            form = ticket;
            request.setAttribute("ticketFormBean", ticket);
            log.info("calling edit_ticket" + ticket);
            return(mapping.findForward("edit_ticket"));
        } else if (ticketBean.getActionn().equalsIgnoreCase("updateTicketingData")) {
        	//log.info(ticketBean);
        	updateTicketingData(ticketBean, userName);
        	save(ticketBean, userName);
            form = ticketBean;
            request.setAttribute("ticketFormBean", ticketBean);
            log.info("calling updateTicketingData");
            return(mapping.findForward("edit_ticket"));
        } else if (ticketBean.getActionn().equalsIgnoreCase("save")
        		|| ticketBean.getActionn().equalsIgnoreCase("softDelete")) {
        	save(ticketBean, userName);
            request.setAttribute("ticketFormBean", ticketBean);
            log.info("calling save_ticket");
            return(mapping.findForward("edit_ticket"));
        } else if (ticketBean.getActionn().equalsIgnoreCase("delete")) {
            ticketDAO.deleteTicketDetails(ticketBean.getTicket_id());
            log.info("calling delete_ticket");
            return(mapping.findForward("delete_ticket"));
        } else if (ticketBean.getActionn().equalsIgnoreCase("printEticket")) {
        	updateTicketingData(ticketBean, userName);
        	save(ticketBean, userName);
            
            request.setAttribute("ticketFormBean", ticketBean);
            log.info("calling print_eticket" + ticketBean);
            return(mapping.findForward("print_eticket"));
        } else if (ticketBean.getActionn().equalsIgnoreCase("printInvoice")) {
        	save(ticketBean, userName);
            
            request.setAttribute("ticketFormBean", ticketBean);
            log.info("calling print_invoice" + ticketBean);
            return(mapping.findForward("print_invoice"));
        } else {
            return(mapping.findForward("success"));
        }
    }

	private void updateTicketingData(TicketDetailsFormBean ticketBean, String userName) {
		// this method is used to update the ticketing info based on raw input from sabre/ crs/ web
		TicketDataParser ticketDataParser = new TicketDataParser();
		if (ticketBean.getRaw_text() != null && ticketBean.getRaw_text().length() >1) {
			TicketFormBean ticketData = ticketDataParser.prepareTicketInfo(ticketBean.getRaw_text());
			//System.out.println(ticketData);
			if (ticketData.getPaxNames().size() >0) {
				ticketBean.setPaxNames(ticketData.getPaxNames());
			}
			if (ticketData.getTicketingLines() != null && ticketData.getTicketingLines().size() >0) {
				ticketBean.setAirlineInfoLines(new ArrayList());
				ticketBean.setTicketingLines(ticketData.getTicketingLines());
				Calendar cal = Calendar.getInstance();
				cal.set(Calendar.MONTH, Integer.parseInt((String)Constants.monthMap.get(((TicketingLine)ticketBean.getTicketingLines().get(0)).getDepartMonth())));
				cal.set(Calendar.DATE, Integer.parseInt(((TicketingLine)ticketBean.getTicketingLines().get(0)).getDepartDateOfMonth()));
				Date departDate = new Date(cal.getTimeInMillis());
				
				ticketBean.setNum_pax(((TicketingLine)ticketBean.getTicketingLines().get(0)).getNumPax());
				ticketBean.setDepart_date(DateUtil.formatDate(departDate, "MM/DD/yyyy"));
				ticketBean.setDepart_airport(((TicketingLine)ticketBean.getTicketingLines().get(0)).getDepartAirport());
				
				// update airlineInfos based on ticketingLines
				Set set = new HashSet();
				for (int i=0; i< ticketBean.getTicketingLines().size(); i++) {
					AirlineInfoFormBean airlineInfo = new AirlineInfoFormBean();
					airlineInfo.setAirlineCode(((TicketingLine)ticketBean.getTicketingLines().get(i)).getAirlineCode());
					airlineInfo.setAirlineConfirmCode(((TicketingLine)ticketBean.getTicketingLines().get(i)).getAirlineConfirmCode());
					airlineInfo.setAirlineName(((TicketingLine)ticketBean.getTicketingLines().get(i)).getAirlineCode());
					// TODO
					airlineInfo.setAirlinePhone(airlineInfo.getAirlineCode());
					set.add(airlineInfo);
				}
				ticketBean.getAirlineInfoLines().addAll(set);
				for (int i=0;i<ticketBean.getAirlineInfoLines().size(); i++) {
					//System.out.println(ticketBean.getAirlineInfoLines().get(i));
				}
			}
			ticketBean.setLinePresent("true");
		}
	}

	private void save(TicketDetailsFormBean ticketBean, String userName) throws Exception {
        TicketUpdateDAO ticketDAO = new TicketUpdateDAO();
        Date currentDate = new Date();
        String currentDateString = DateUtil.formatDate(currentDate, "yyyy-MM-dd HH:mm");
        if (ticketBean.getActionn().equalsIgnoreCase("softDelete")) {
        	ticketBean.setDeleted(true);
        	ticketBean.setDelete_dttm(currentDateString);
        } else {
        	ticketBean.setDelete_dttm("1900-01-01 00:00");
        }
        if (ticketBean.getIssue_date() == null || ticketBean.getIssue_date().equals("")) {
        	ticketBean.setIssue_date("01/01/1900");
        }
        if (ticketBean.getDepart_date() == null || ticketBean.getDepart_date().equals("")) {
        	ticketBean.setDepart_date("01/01/1900");
        }
        if (ticketBean.getReturn_date() == null || ticketBean.getReturn_date().equals("")) {
        	ticketBean.setReturn_date("01/01/1900");
        }
        ticketBean.setUpdated_by(userName);
        ticketBean.setUpdate_dttm(currentDateString);
        if (ticketBean.getInvoice_number() == 0) {
        	ticketBean.setInvoice_number(ticketDAO.getNextInvoiceNumber());
        }
        if (ticketBean.getTicket_id() != 0) {
            ticketDAO.saveTicketDetails(ticketBean);
        } else {
            String insert_key = userName + DateUtil.formatDate(currentDate, "MMddyyHHmmss");

            ticketBean.setInsert_key(insert_key);
            ticketBean.setAdd_dttm(currentDateString);
            ticketBean.setAdded_by(userName);

            ticketDAO.addTicketDetails(ticketBean);
            ticketBean = (TicketDetailsFormBean)ticketDAO.getTicketInfoByInsertKey(ticketBean.getInsert_key());
        }
		
	}

	private void updateTicketContactInfo(TicketDetailsFormBean ticket, HttpSession session) {
		ContactDetailsFormBean contact = null;
		contact = (ContactDetailsFormBean)session.getAttribute("contactFormBean");
		if (contact == null || contact.getContact_id() != ticket.getContact_id()) {
			ContactUpdateDAO contactDao = new ContactUpdateDAO();
			try {
				contact = contactDao.getContactDetails(ticket.getContact_id());
			} catch (Exception ex) {
				log.error("Failed to get contact details in updateTicketContactInfo");
			}
		}
		// maping of contact details to ticket details
		ticket.setAgent_name(contact.getTicketed_by());
		ticket.setTransaction_number(contact.getContact_id());
		ticket.setBill_to(contact.getContact_name());
		ticket.setBillingAddress_line1(contact.getBillingAddress_line1());
		ticket.setBillingAddress_line2(contact.getBillingAddress_line2());
		ticket.setBillingAddress_line3(contact.getBillingAddress_line3());
		ticket.setBillingAddress_city(contact.getBillingAddress_city());
		ticket.setBillingAddress_state(contact.getBillingAddress_state());
		ticket.setBillingAddress_zip(contact.getBillingAddress_zip());
		ticket.setBillingAddress_country(contact.getBillingAddress_country());
		ticket.setMail_to(contact.getContact_name());
		ticket.setMailingAddress_line1(contact.getMailingAddress_line1());
		ticket.setMailingAddress_line2(contact.getMailingAddress_line2());
		ticket.setMailingAddress_line3(contact.getMailingAddress_line3());
		ticket.setMailingAddress_city(contact.getMailingAddress_city());
		ticket.setMailingAddress_state(contact.getMailingAddress_state());
		ticket.setMailingAddress_zip(contact.getMailingAddress_zip());
		ticket.setMailingAddress_country(contact.getMailingAddress_country());
		ticket.setPax1First_name(contact.getFirst_name());
		ticket.setPax1Middle_name(contact.getMiddle_name());
		ticket.setPax1Last_name(contact.getLast_name());
		
	}


}
