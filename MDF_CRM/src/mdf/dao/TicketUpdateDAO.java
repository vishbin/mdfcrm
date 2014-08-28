package mdf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mdf.forms.TicketDetailsFormBean;
import mdf.forms.TicketFormBean;
import mdf.utils.DateUtil;

public class TicketUpdateDAO extends BaseUpdateDAO {
	// add ticket details
	public void addTicketDetails(TicketDetailsFormBean ticketDetails) throws Exception {
		addTicketDetails((TicketFormBean)ticketDetails);
	}
	
	public void addTicketDetails(TicketFormBean ticketDetails) throws Exception {
		log.info("inside ticketupdatedao.addTicketDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			int deleted_intval = 0;
			if (ticketDetails.isDeleted()) deleted_intval = 1;
			stmtString = "INSERT INTO mdfdb.ticket (ticket_id, deleted, insert_key, contact_id, itinerary_id, pnr, crs, pcc, itinerary_link, ticket_link, invoice_link, transaction_number, branch_id, invoice_number, ticket_type, num_pax, ticket_issuer, agent_name, agent_id, issue_date, depart_date, return_date, depart_airport, arrive_airport, primary_airline, totalCurrency, totalCharge, totalBase, totalTax, totalSurcharge, total_expenses, total_margin, form_of_payment, receivedBy, card_type, card_number, check_number, bank_name, comments, notes, tracking_link, tracking_number, mail_to, mailingAddress_line1, mailingAddress_line2, mailingAddress_line3, mailingAddress_city, mailingAddress_state, mailingAddress_zip, mailingAddress_country, bill_to, billingAddress_line1, billingAddress_line2, billingAddress_line3, billingAddress_city, billingAddress_state, billingAddress_zip, billingAddress_country, pax1Last_name, pax1First_name, pax1Middle_name, pax1Title, pax1Age, pax1Description, pax1Currency, pax1Charge, pax1Base, pax1Tax, pax1Surcharge, pax2Last_name, pax2First_name, pax2Middle_name, pax2Title, pax2Age, pax2Description, pax2Currency, pax2Charge, pax2Base, pax2Tax, pax2Surcharge, pax3Last_name, pax3First_name, pax3Middle_name, pax3Title, pax3Age, pax3Description, pax3Currency, pax3Charge, pax3Base, pax3Tax, pax3Surcharge, pax4Last_name, pax4First_name, pax4Middle_name, pax4Title, pax4Age, pax4Description, pax4Currency, pax4Charge, pax4Base, pax4Tax, pax4Surcharge, pax5First_name, pax5Last_name, pax5Middle_name, pax5Title, pax5Age, pax5Description, pax5Currency, pax5Charge, pax5Base, pax5Tax, pax5Surcharge, added_by, updated_by, add_dttm, update_dttm, delete_dttm, raw_text) " + 
			" VALUES (" +
			ticketDetails.getTicket_id() + ", " +
			deleted_intval + ", " +
			"'" + ticketDetails.getInsert_key() + "', " +
			ticketDetails.getContact_id() + ", " +
			ticketDetails.getItinerary_id() + ", " +
			"'" + ticketDetails.getPnr() + "', " +
			"'" + ticketDetails.getCrs() + "', " +
			"'" + ticketDetails.getPcc() + "', " +
			"'" + ticketDetails.getItinerary_link() + "', " +
			"'" + ticketDetails.getTicket_link() + "', " +
			"'" + ticketDetails.getInvoice_link() + "', " +
			ticketDetails.getTransaction_number() + ", " +
			ticketDetails.getBranch_id() + ", " +
			ticketDetails.getInvoice_number() + ", " +
			"'" + ticketDetails.getTicket_type() + "', " +
			ticketDetails.getNum_pax() + ", " +
			"'" + ticketDetails.getTicket_issuer() + "', " +
			"'" + ticketDetails.getAgent_name() + "', " +
			ticketDetails.getAgent_id() + ", " +
			"'" + DateUtil.parseSQLDate(ticketDetails.getIssue_date(), "MM/dd/yyyy") + "', " +
			"'" + DateUtil.parseSQLDate(ticketDetails.getDepart_date(), "MM/dd/yyyy") + "', " +
			"'" + DateUtil.parseSQLDate(ticketDetails.getReturn_date(), "MM/dd/yyyy") + "', " +
			"'" + ticketDetails.getDepart_airport() + "', " +
			"'" + ticketDetails.getArrive_airport() + "', " +
			"'" + ticketDetails.getPrimary_airline() + "', " +
			"'" + ticketDetails.getTotalCurrency() + "', " +
			ticketDetails.getTotalCharge() + ", " +
			ticketDetails.getTotalBase() + ", " +
			ticketDetails.getTotalTax() + ", " +
			ticketDetails.getTotalSurcharge() + ", " +
			ticketDetails.getTotal_expenses() + ", " +
			ticketDetails.getTotal_margin() + ", " +
			"'" + ticketDetails.getForm_of_payment() + "', " +
			"'" + ticketDetails.getReceivedBy() + "', " +
			"'" + ticketDetails.getCard_type() + "', " +
			"'" + ticketDetails.getCard_number() + "', " +
			"'" + ticketDetails.getCheck_number() + "', " +
			"'" + ticketDetails.getBank_name() + "', " +
			"'" + ticketDetails.getComments() + "', " +
			"'" + ticketDetails.getNotes() + "', " +
			"'" + ticketDetails.getTracking_link() + "', " +
			"'" + ticketDetails.getTracking_number() + "', " +
			"'" + ticketDetails.getMail_to() + "', " +
			"'" + ticketDetails.getMailingAddress_line1() + "', " +
			"'" + ticketDetails.getMailingAddress_line2() + "', " +
			"'" + ticketDetails.getMailingAddress_line3() + "', " +
			"'" + ticketDetails.getMailingAddress_city() + "', " +
			"'" + ticketDetails.getMailingAddress_state() + "', " +
			"'" + ticketDetails.getMailingAddress_zip() + "', " +
			"'" + ticketDetails.getMailingAddress_country() + "', " +
			"'" + ticketDetails.getBill_to() + "', " +
			"'" + ticketDetails.getBillingAddress_line1() + "', " +
			"'" + ticketDetails.getBillingAddress_line2() + "', " +
			"'" + ticketDetails.getBillingAddress_line3() + "', " +
			"'" + ticketDetails.getBillingAddress_city() + "', " +
			"'" + ticketDetails.getBillingAddress_state() + "', " +
			"'" + ticketDetails.getBillingAddress_zip() + "', " +
			"'" + ticketDetails.getBillingAddress_country() + "', " +
			"'" + ticketDetails.getPax1Last_name() + "', " +
			"'" + ticketDetails.getPax1First_name() + "', " +
			"'" + ticketDetails.getPax1Middle_name() + "', " +
			"'" + ticketDetails.getPax1Title() + "', " +
			ticketDetails.getPax1Age() + ", " +
			"'" + ticketDetails.getPax1Description() + "', " +
			"'" + ticketDetails.getPax1Currency() + "', " +
			ticketDetails.getPax1Charge() + ", " +
			ticketDetails.getPax1Base() + ", " +
			ticketDetails.getPax1Tax() + ", " +
			ticketDetails.getPax1Surcharge() + ", " +
			"'" + ticketDetails.getPax2Last_name() + "', " +
			"'" + ticketDetails.getPax2First_name() + "', " +
			"'" + ticketDetails.getPax2Middle_name() + "', " +
			"'" + ticketDetails.getPax2Title() + "', " +
			ticketDetails.getPax2Age() + ", " +
			"'" + ticketDetails.getPax2Description() + "', " +
			"'" + ticketDetails.getPax2Currency() + "', " +
			ticketDetails.getPax2Charge() + ", " +
			ticketDetails.getPax2Base() + ", " +
			ticketDetails.getPax2Tax() + ", " +
			ticketDetails.getPax2Surcharge() + ", " +
			"'" + ticketDetails.getPax3Last_name() + "', " +
			"'" + ticketDetails.getPax3First_name() + "', " +
			"'" + ticketDetails.getPax3Middle_name() + "', " +
			"'" + ticketDetails.getPax3Title() + "', " +
			ticketDetails.getPax3Age() + ", " +
			"'" + ticketDetails.getPax3Description() + "', " +
			"'" + ticketDetails.getPax3Currency() + "', " +
			ticketDetails.getPax3Charge() + ", " +
			ticketDetails.getPax3Base() + ", " +
			ticketDetails.getPax3Tax() + ", " +
			ticketDetails.getPax3Surcharge() + ", " +
			"'" + ticketDetails.getPax4Last_name() + "', " +
			"'" + ticketDetails.getPax4First_name() + "', " +
			"'" + ticketDetails.getPax4Middle_name() + "', " +
			"'" + ticketDetails.getPax4Title() + "', " +
			ticketDetails.getPax4Age() + ", " +
			"'" + ticketDetails.getPax4Description() + "', " +
			"'" + ticketDetails.getPax4Currency() + "', " +
			ticketDetails.getPax4Charge() + ", " +
			ticketDetails.getPax4Base() + ", " +
			ticketDetails.getPax4Tax() + ", " +
			ticketDetails.getPax4Surcharge() + ", " +
			"'" + ticketDetails.getPax5First_name() + "', " +
			"'" + ticketDetails.getPax5Last_name() + "', " +
			"'" + ticketDetails.getPax5Middle_name() + "', " +
			"'" + ticketDetails.getPax5Title() + "', " +
			ticketDetails.getPax5Age() + ", " +
			"'" + ticketDetails.getPax5Description() + "', " +
			"'" + ticketDetails.getPax5Currency() + "', " +
			ticketDetails.getPax5Charge() + ", " +
			ticketDetails.getPax5Base() + ", " +
			ticketDetails.getPax5Tax() + ", " +
			ticketDetails.getPax5Surcharge() + ", " +
			"'" + ticketDetails.getAdded_by() + "', " +
			"'" + ticketDetails.getUpdated_by() + "', " +
			"'" + ticketDetails.getAdd_dttm() + "', " +
			"'" + ticketDetails.getUpdate_dttm() + "', " +
			"'" + ticketDetails.getDelete_dttm() + "', " +
			"'" + ticketDetails.getRaw_text() + "'); "
				;

			stmt.executeUpdate(stmtString);
		} catch (SQLException ex) {
			log.error("Caught SQL Exception: " + ex);
			throw ex;
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				log.error("Could not close: " + ex);
				throw ex;
			}
		}
		closeDB();
	}

		
	
	// search

	public List lookupTicket(TicketDetailsFormBean ticketBean) throws Exception {
		log.info("inside ticketupdatedao.lookupTicketDetails");
		TicketFormBean ticket = (TicketFormBean)ticketBean;
		return(lookupTicket(ticket));
	}
	public List lookupTicket(TicketFormBean ticketBean) throws Exception {
		log.info("inside ticketupdatedao.lookupTicket");
		List ticketsList = new ArrayList();
		String paramString = "";
		String orderString = "";
		boolean queryParam = false;
		try {
			// and execute a simple query 
			if (ticketBean.getContact_id() != 0) {
				if (queryParam == true) {
					paramString += " OR ";
					orderString += ",";
				}
				paramString += " contact_id =" + ticketBean.getContact_id();
				orderString += " contact_id";
				queryParam = true;
			}
			if (!ticketBean.getBill_to().equals("")) {
				if (queryParam == true) {
					paramString += " OR ";
					orderString += ",";
				}
				paramString += " bill_to LIKE '" + ticketBean.getBill_to() + "%'";
				orderString += " bill_to";
				queryParam = true;
			}
			if (!ticketBean.getMail_to().equals("")) {
				if (queryParam == true) {
					paramString += " OR ";
					orderString += ",";
				}
				paramString += " mail_to LIKE '" + ticketBean.getMail_to() + "%'";
				orderString += " mail_to";
				queryParam = true;
			}
			if (!ticketBean.getPax1First_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax1First_name LIKE '" + ticketBean.getPax1First_name() + "%'";
				orderString += " pax1First_name";
				queryParam = true;
			}
			if (!ticketBean.getPax1Middle_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax1Middle_name LIKE '" + ticketBean.getPax1Middle_name() + "%'";
				orderString += " pax1Middle_name";
				queryParam = true;
			}
			if (!ticketBean.getPax1Last_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax1Last_name LIKE '" + ticketBean.getPax1Last_name() + "%'";
				orderString += " pax1Last_name";
			}
			if (!ticketBean.getPax2First_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax2First_name LIKE '" + ticketBean.getPax2First_name() + "%'";
				orderString += " pax2First_name";
				queryParam = true;
			}
			if (!ticketBean.getPax2Middle_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax2Middle_name LIKE '" + ticketBean.getPax2Middle_name() + "%'";
				orderString += " pax2Middle_name";
				queryParam = true;
			}
			if (!ticketBean.getPax2Last_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax2Last_name LIKE '" + ticketBean.getPax2Last_name() + "%'";
				orderString += " pax2Last_name";
			}
			if (!ticketBean.getPax3First_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax3First_name LIKE '" + ticketBean.getPax3First_name() + "%'";
				orderString += " pax3First_name";
				queryParam = true;
			}
			if (!ticketBean.getPax3Middle_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax3Middle_name LIKE '" + ticketBean.getPax3Middle_name() + "%'";
				orderString += " pax3Middle_name";
				queryParam = true;
			}
			if (!ticketBean.getPax3Last_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax3Last_name LIKE '" + ticketBean.getPax3Last_name() + "%'";
				orderString += " pax3Last_name";
			}
			if (!ticketBean.getPax1First_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax4First_name LIKE '" + ticketBean.getPax4First_name() + "%'";
				orderString += " pax4First_name";
				queryParam = true;
			}
			if (!ticketBean.getPax4Middle_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax4Middle_name LIKE '" + ticketBean.getPax4Middle_name() + "%'";
				orderString += " pax4Middle_name";
				queryParam = true;
			}
			if (!ticketBean.getPax4Last_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax4Last_name LIKE '" + ticketBean.getPax4Last_name() + "%'";
				orderString += " pax4Last_name";
			}
			if (!ticketBean.getPax5First_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax5First_name LIKE '" + ticketBean.getPax5First_name() + "%'";
				orderString += " pax5First_name";
				queryParam = true;
			}
			if (!ticketBean.getPax5Middle_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax5Middle_name LIKE '" + ticketBean.getPax5Middle_name() + "%'";
				orderString += " pax5Middle_name";
				queryParam = true;
			}
			if (!ticketBean.getPax5Last_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " pax5Last_name LIKE '" + ticketBean.getPax5Last_name() + "%'";
				orderString += " pax5Last_name";
			}

			
			if (queryParam == true) {
				paramString = " WHERE " + paramString + " AND deleted = 0 ";
				orderString = " ORDER BY " + orderString + " ,update_dttm DESC, ticket_id DESC";
			}
			ticketsList = getTicketInfo(paramString, orderString); 

			for (int i=0; i<ticketsList.size(); i++) {
				TicketDetailsFormBean ticket = (TicketDetailsFormBean)ticketsList.get(i);
				ticket.setUi_name(ticketBean.getUi_name());
				ticket.setUi_number(ticketBean.getUi_number());
				ticket.setUi_email(ticketBean.getUi_email());
			}
		} catch (Exception ex) {
			log.error("Caught Exception: " + ex);
			throw ex;
		}
		return ticketsList;
	}
	
	// get ticket info by ID
	public TicketFormBean getTicketInfoByID(int ticket_id) throws Exception {
		log.info("inside ticketupdatedao.getTicketInfoByID");
		String paramString = "WHERE ticket_id =" + ticket_id;
		List ticketsList = getTicketInfo(paramString, ""); 
		if (ticketsList != null && ticketsList.size()>0) 
			return (TicketFormBean)ticketsList.get(0);
		else return null;
	}
	
	// get ticket info by InsertKey
	public TicketFormBean getTicketInfoByInsertKey(String insert_key) throws Exception {
		log.info("inside ticketupdatedao.getTicketInfoByInsertKey");
		String paramString = "WHERE insert_key ='" + insert_key + "'";
		List ticketsList = getTicketInfo(paramString, ""); 
		if (ticketsList != null && ticketsList.size()>0) 
			return (TicketFormBean)ticketsList.get(0);
		else return null;
	}
	
	// get ticket info
	public List getTicketInfo(String paramString, String orderString) throws Exception {
		log.info("inside ticketupdatedao.getTicketInfo");
		Statement stmt = null;
		String stmtString = "";
		List ticketsList = new ArrayList();
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "SELECT * FROM ticket " + paramString + orderString;
			log.info(stmtString);

			ResultSet rs = stmt.executeQuery(stmtString);
		
			while (rs.next()) {
				// iterate through the result set and get first record
				TicketDetailsFormBean ticketDetails = new TicketDetailsFormBean();
				ticketDetails.setTicket_id(rs.getInt("ticket_id"));
				ticketDetails.setDeleted(rs.getBoolean("deleted"));
				if (rs.getString("insert_key")==null) ticketDetails.setInsert_key(""); else
					ticketDetails.setInsert_key(rs.getString("insert_key"));
				ticketDetails.setContact_id(rs.getInt("contact_id"));
				ticketDetails.setItinerary_id(rs.getInt("itinerary_id"));
				if (rs.getString("pnr")==null) ticketDetails.setPnr(""); else
					ticketDetails.setPnr(rs.getString("pnr"));
				if (rs.getString("crs")==null) ticketDetails.setCrs(""); else
					ticketDetails.setCrs(rs.getString("crs"));
				if (rs.getString("pcc")==null) ticketDetails.setPcc(""); else
					ticketDetails.setPcc(rs.getString("pcc"));
				if (rs.getString("itinerary_link")==null) ticketDetails.setItinerary_link(""); else
					ticketDetails.setItinerary_link(rs.getString("itinerary_link"));
				if (rs.getString("ticket_link")==null) ticketDetails.setTicket_link(""); else
					ticketDetails.setTicket_link(rs.getString("ticket_link"));
				if (rs.getString("invoice_link")==null)	ticketDetails.setInvoice_link(""); else
					ticketDetails.setInvoice_link(rs.getString("invoice_link"));
				ticketDetails.setTransaction_number(rs.getInt("transaction_number"));
				ticketDetails.setBranch_id(rs.getInt("branch_id"));
				ticketDetails.setInvoice_number(rs.getInt("invoice_number"));
				if (rs.getString("ticket_type")==null) ticketDetails.setTicket_type(""); else
					ticketDetails.setTicket_type(rs.getString("ticket_type"));
				ticketDetails.setNum_pax(rs.getInt("num_pax"));
				if (rs.getString("ticket_issuer")==null) ticketDetails.setTicket_issuer(""); else
					ticketDetails.setTicket_issuer(rs.getString("ticket_issuer"));
				if (rs.getString("agent_name")==null) ticketDetails.setAgent_name(""); else
					ticketDetails.setAgent_name(rs.getString("agent_name"));
				ticketDetails.setAgent_id(rs.getInt("agent_id"));
				ticketDetails.setIssue_date(DateUtil.formatDate(rs.getDate("issue_date"), "MM/dd/yyyy"));
				ticketDetails.setDepart_date(DateUtil.formatDate(rs.getDate("depart_date"), "MM/dd/yyyy"));
				ticketDetails.setReturn_date(DateUtil.formatDate(rs.getDate("return_date"), "MM/dd/yyyy"));
				if (rs.getString("depart_airport")==null) ticketDetails.setDepart_airport(""); else
					ticketDetails.setDepart_airport(rs.getString("depart_airport"));
				if (rs.getString("arrive_airport")==null) ticketDetails.setArrive_airport(""); else
					ticketDetails.setArrive_airport(rs.getString("arrive_airport"));
				if (rs.getString("primary_airline")==null) ticketDetails.setPrimary_airline(""); else
					ticketDetails.setPrimary_airline(rs.getString("primary_airline"));
				if (rs.getString("totalCurrency")==null) ticketDetails.setTotalCurrency(""); else
					ticketDetails.setTotalCurrency(rs.getString("totalCurrency"));
				ticketDetails.setTotalCharge(rs.getDouble("totalCharge"));
				ticketDetails.setTotalBase(rs.getDouble("totalBase"));
				ticketDetails.setTotalTax(rs.getDouble("totalTax"));
				ticketDetails.setTotalSurcharge(rs.getDouble("totalSurcharge"));
				ticketDetails.setTotal_expenses(rs.getDouble("total_expenses"));
				ticketDetails.setTotal_margin(rs.getDouble("total_margin"));
				if (rs.getString("form_of_payment")==null) ticketDetails.setForm_of_payment(""); else
					ticketDetails.setForm_of_payment(rs.getString("form_of_payment"));
				if (rs.getString("receivedBy")==null) ticketDetails.setReceivedBy(""); else
					ticketDetails.setReceivedBy(rs.getString("receivedBy"));
				if (rs.getString("card_type")==null) ticketDetails.setCard_type(""); else
					ticketDetails.setCard_type(rs.getString("card_type"));
				if (rs.getString("card_number")==null) ticketDetails.setCard_number(""); else
					ticketDetails.setCard_number(rs.getString("card_number"));
				if (rs.getString("check_number")==null)	ticketDetails.setCheck_number(""); else
					ticketDetails.setCheck_number(rs.getString("check_number"));
				if (rs.getString("bank_name")==null) ticketDetails.setBank_name(""); else
					ticketDetails.setBank_name(rs.getString("bank_name"));
				if (rs.getString("comments")==null)	ticketDetails.setComments(""); else
					ticketDetails.setComments(rs.getString("comments"));
				if (rs.getString("notes")==null) ticketDetails.setNotes(""); else
					ticketDetails.setNotes(rs.getString("notes"));
				if (rs.getString("tracking_link")==null) ticketDetails.setTracking_link(""); else
					ticketDetails.setTracking_link(rs.getString("tracking_link"));
				if (rs.getString("tracking_number")==null) ticketDetails.setTracking_number(""); else
					ticketDetails.setTracking_number(rs.getString("tracking_number"));
				if (rs.getString("mail_to")==null) ticketDetails.setMail_to(""); else
					ticketDetails.setMail_to(rs.getString("mail_to"));
				if (rs.getString("mailingAddress_line1")==null)	ticketDetails.setMailingAddress_line1(""); else
					ticketDetails.setMailingAddress_line1(rs.getString("mailingAddress_line1"));
				if (rs.getString("mailingAddress_line2")==null)	ticketDetails.setMailingAddress_line2(""); else
					ticketDetails.setMailingAddress_line2(rs.getString("mailingAddress_line2"));
				if (rs.getString("mailingAddress_line3")==null)	ticketDetails.setMailingAddress_line3(""); else
					ticketDetails.setMailingAddress_line3(rs.getString("mailingAddress_line3"));
				if (rs.getString("mailingAddress_city")==null) ticketDetails.setMailingAddress_city(""); else
					ticketDetails.setMailingAddress_city(rs.getString("mailingAddress_city"));
				if (rs.getString("mailingAddress_state")==null)	ticketDetails.setMailingAddress_state(""); else
					ticketDetails.setMailingAddress_state(rs.getString("mailingAddress_state"));
				if (rs.getString("mailingAddress_zip")==null) ticketDetails.setMailingAddress_zip(""); else
					ticketDetails.setMailingAddress_zip(rs.getString("mailingAddress_zip"));
				if (rs.getString("mailingAddress_country")==null) ticketDetails.setMailingAddress_country(""); else
					ticketDetails.setMailingAddress_country(rs.getString("mailingAddress_country"));
				if (rs.getString("bill_to")==null) ticketDetails.setBill_to(""); else
					ticketDetails.setBill_to(rs.getString("bill_to"));
				if (rs.getString("billingAddress_line1")==null)	ticketDetails.setBillingAddress_line1(""); else
					ticketDetails.setBillingAddress_line1(rs.getString("billingAddress_line1"));
				if (rs.getString("billingAddress_line2")==null)	ticketDetails.setBillingAddress_line2(""); else
					ticketDetails.setBillingAddress_line2(rs.getString("billingAddress_line2"));
				if (rs.getString("billingAddress_line3")==null)	ticketDetails.setBillingAddress_line3(""); else
					ticketDetails.setBillingAddress_line3(rs.getString("billingAddress_line3"));
				if (rs.getString("billingAddress_city")==null) ticketDetails.setBillingAddress_city(""); else
					ticketDetails.setBillingAddress_city(rs.getString("billingAddress_city"));
				if (rs.getString("billingAddress_state")==null)	ticketDetails.setBillingAddress_state(""); else
					ticketDetails.setBillingAddress_state(rs.getString("billingAddress_state"));
				if (rs.getString("billingAddress_zip")==null) ticketDetails.setBillingAddress_zip(""); else
					ticketDetails.setBillingAddress_zip(rs.getString("billingAddress_zip"));
				if (rs.getString("billingAddress_country")==null) ticketDetails.setBillingAddress_country(""); else
					ticketDetails.setBillingAddress_country(rs.getString("billingAddress_country"));
				if (rs.getString("pax1Last_name")==null) ticketDetails.setPax1Last_name(""); else
					ticketDetails.setPax1Last_name(rs.getString("pax1Last_name"));
				if (rs.getString("pax1First_name")==null) ticketDetails.setPax1First_name(""); else
					ticketDetails.setPax1First_name(rs.getString("pax1First_name"));
				if (rs.getString("pax1Middle_name")==null) ticketDetails.setPax1Middle_name(""); else
					ticketDetails.setPax1Middle_name(rs.getString("pax1Middle_name"));
				if (rs.getString("pax1Title")==null) ticketDetails.setPax1Title(""); else
					ticketDetails.setPax1Title(rs.getString("pax1Title"));
				ticketDetails.setPax1Age(rs.getInt("pax1Age"));
				if (rs.getString("pax1Description")==null) ticketDetails.setPax1Description(""); else
					ticketDetails.setPax1Description(rs.getString("pax1Description"));
				if (rs.getString("pax1Currency")==null) ticketDetails.setPax1Currency(""); else
					ticketDetails.setPax1Currency(rs.getString("pax1Currency"));
				ticketDetails.setPax1Charge(rs.getDouble("pax1Charge"));
				ticketDetails.setPax1Base(rs.getDouble("pax1Base"));
				ticketDetails.setPax1Tax(rs.getDouble("pax1Tax"));
				ticketDetails.setPax1Surcharge(rs.getDouble("pax1Surcharge"));
				if (rs.getString("pax2Last_name")==null) ticketDetails.setPax2Last_name(""); else
					ticketDetails.setPax2Last_name(rs.getString("pax2Last_name"));
				if (rs.getString("pax2First_name")==null) ticketDetails.setPax2First_name(""); else
					ticketDetails.setPax2First_name(rs.getString("pax2First_name"));
				if (rs.getString("pax2Middle_name")==null) ticketDetails.setPax2Middle_name(""); else
					ticketDetails.setPax2Middle_name(rs.getString("pax2Middle_name"));
				if (rs.getString("pax2Title")==null) ticketDetails.setPax2Title(""); else
					ticketDetails.setPax2Title(rs.getString("pax2Title"));
				ticketDetails.setPax2Age(rs.getInt("pax2Age"));
				if (rs.getString("pax2Description")==null) ticketDetails.setPax2Description(""); else
					ticketDetails.setPax2Description(rs.getString("pax2Description"));
				if (rs.getString("pax2Currency")==null) ticketDetails.setPax2Currency(""); else
					ticketDetails.setPax2Currency(rs.getString("pax2Currency"));
				ticketDetails.setPax2Charge(rs.getDouble("pax2Charge"));
				ticketDetails.setPax2Base(rs.getDouble("pax2Base"));
				ticketDetails.setPax2Tax(rs.getDouble("pax2Tax"));
				ticketDetails.setPax2Surcharge(rs.getDouble("pax2Surcharge"));
				if (rs.getString("pax3Last_name")==null) ticketDetails.setPax3Last_name(""); else
					ticketDetails.setPax3Last_name(rs.getString("pax3Last_name"));
				if (rs.getString("pax3First_name")==null) ticketDetails.setPax3First_name(""); else
					ticketDetails.setPax3First_name(rs.getString("pax3First_name"));
				if (rs.getString("pax3Middle_name")==null) ticketDetails.setPax3Middle_name(""); else
					ticketDetails.setPax3Middle_name(rs.getString("pax3Middle_name"));
				if (rs.getString("pax3Title")==null) ticketDetails.setPax3Title(""); else
					ticketDetails.setPax3Title(rs.getString("pax3Title"));
				ticketDetails.setPax3Age(rs.getInt("pax3Age"));
				if (rs.getString("pax3Description")==null) ticketDetails.setPax3Description(""); else
					ticketDetails.setPax3Description(rs.getString("pax3Description"));
				if (rs.getString("pax3Currency")==null) ticketDetails.setPax3Currency(""); else
					ticketDetails.setPax3Currency(rs.getString("pax3Currency"));
				ticketDetails.setPax3Charge(rs.getDouble("pax3Charge"));
				ticketDetails.setPax3Base(rs.getDouble("pax3Base"));
				ticketDetails.setPax3Tax(rs.getDouble("pax3Tax"));
				ticketDetails.setPax3Surcharge(rs.getDouble("pax3Surcharge"));
				if (rs.getString("pax4Last_name")==null) ticketDetails.setPax4Last_name(""); else
					ticketDetails.setPax4Last_name(rs.getString("pax4Last_name"));
				if (rs.getString("pax4First_name")==null) ticketDetails.setPax4First_name(""); else
					ticketDetails.setPax4First_name(rs.getString("pax4First_name"));
				if (rs.getString("pax4Middle_name")==null) ticketDetails.setPax4Middle_name(""); else
					ticketDetails.setPax4Middle_name(rs.getString("pax4Middle_name"));
				if (rs.getString("pax4Title")==null) ticketDetails.setPax4Title(""); else
					ticketDetails.setPax4Title(rs.getString("pax4Title"));
				ticketDetails.setPax4Age(rs.getInt("pax4Age"));
				if (rs.getString("pax4Description")==null) ticketDetails.setPax4Description(""); else
					ticketDetails.setPax4Description(rs.getString("pax4Description"));
				if (rs.getString("pax4Currency")==null) ticketDetails.setPax4Currency(""); else
					ticketDetails.setPax4Currency(rs.getString("pax4Currency"));
				ticketDetails.setPax4Charge(rs.getDouble("pax4Charge"));
				ticketDetails.setPax4Base(rs.getDouble("pax4Base"));
				ticketDetails.setPax4Tax(rs.getDouble("pax4Tax"));
				ticketDetails.setPax4Surcharge(rs.getDouble("pax4Surcharge"));
				if (rs.getString("pax5First_name")==null) ticketDetails.setPax5First_name(""); else
					ticketDetails.setPax5First_name(rs.getString("pax5First_name"));
				if (rs.getString("pax5Last_name")==null) ticketDetails.setPax5Last_name(""); else
					ticketDetails.setPax5Last_name(rs.getString("pax5Last_name"));
				if (rs.getString("pax5Middle_name")==null) ticketDetails.setPax5Middle_name(""); else
					ticketDetails.setPax5Middle_name(rs.getString("pax5Middle_name"));
				if (rs.getString("pax5Title")==null) ticketDetails.setPax5Title(""); else
					ticketDetails.setPax5Title(rs.getString("pax5Title"));
				ticketDetails.setPax5Age(rs.getInt("pax5Age"));
				if (rs.getString("pax5Description")==null) ticketDetails.setPax5Description(""); else
					ticketDetails.setPax5Description(rs.getString("pax5Description"));
				if (rs.getString("pax5Currency")==null) ticketDetails.setPax5Currency(""); else
					ticketDetails.setPax5Currency(rs.getString("pax5Currency"));
				ticketDetails.setPax5Charge(rs.getDouble("pax5Charge"));
				ticketDetails.setPax5Base(rs.getDouble("pax5Base"));
				ticketDetails.setPax5Tax(rs.getDouble("pax5Tax"));
				ticketDetails.setPax5Surcharge(rs.getDouble("pax5Surcharge"));
				if (rs.getString("added_by")==null)	ticketDetails.setAdded_by(""); else
					ticketDetails.setAdded_by(rs.getString("added_by"));
				if (rs.getString("updated_by")==null) ticketDetails.setUpdated_by(""); else
					ticketDetails.setUpdated_by(rs.getString("updated_by"));
				ticketDetails.setAdd_dttm(DateUtil.formatDate(rs.getTimestamp("add_dttm"), "yyyy-MM-dd HH:mm"));
				ticketDetails.setUpdate_dttm(DateUtil.formatDate(rs.getTimestamp("update_dttm"), "yyyy-MM-dd HH:mm"));
				ticketDetails.setDelete_dttm(DateUtil.formatDate(rs.getTimestamp("delete_dttm"), "yyyy-MM-dd HH:mm"));
				if (rs.getString("raw_text")==null)	ticketDetails.setRaw_text(""); else
					ticketDetails.setRaw_text(rs.getString("raw_text"));

				ticketsList.add(ticketDetails);
			}
		} catch (SQLException ex) {
			log.error("Caught SQL Exception: " + ex);
			throw ex;
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				log.error("Could not close: " + ex);
				throw ex;
			}
		}
		closeDB();
		return ticketsList;
	}
	
	//	 get ticket details
	public TicketDetailsFormBean getTicketDetails(int ticket_id) throws Exception {
		log.info("inside ticketupdatedao.getTicketDetails");
		TicketDetailsFormBean ticketDetails = new TicketDetailsFormBean();
		ticketDetails = (TicketDetailsFormBean)getTicketInfoByID(ticket_id);
		
		return ticketDetails;
	}
	
	// save ticket details
	public void saveTicketDetails(TicketDetailsFormBean ticketDetails) throws Exception {
		log.info("inside ticketupdatedao.saveTicketDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			int deleted_intval = 0;
			if (ticketDetails.isDeleted()) deleted_intval = 1;
			stmtString = "UPDATE ticket SET " +
			 " deleted = " + deleted_intval + ", " +
			 " insert_key = '" + ticketDetails.getInsert_key() + "', " +
			 " contact_id = " + ticketDetails.getContact_id() + ", " +
			 " itinerary_id = " + ticketDetails.getItinerary_id() + ", " +
			 " pnr = '" + ticketDetails.getPnr() + "', " +
			 " crs = '" + ticketDetails.getCrs() + "', " +
			 " pcc = '" + ticketDetails.getPcc() + "', " +
			 " itinerary_link = '" + ticketDetails.getItinerary_link() + "', " +
			 " ticket_link = '" + ticketDetails.getTicket_link() + "', " +
			 " invoice_link = '" + ticketDetails.getInvoice_link() + "', " +
			 " transaction_number = " + ticketDetails.getTransaction_number() + ", " +
			 " branch_id = " + ticketDetails.getBranch_id() + ", " +
			 " invoice_number = " + ticketDetails.getInvoice_number() + ", " +
			 " ticket_type = '" + ticketDetails.getTicket_type() + "', " +
			 " num_pax = " + ticketDetails.getNum_pax() + ", " +
			 " ticket_issuer = '" + ticketDetails.getTicket_issuer() + "', " +
			 " agent_name = '" + ticketDetails.getAgent_name() + "', " +
			 " agent_id = " + ticketDetails.getAgent_id() + ", " +
			 " issue_date = '" + DateUtil.parseSQLDate(ticketDetails.getIssue_date(), "MM/dd/yyyy") + "', " +
			 " depart_date = '" + DateUtil.parseSQLDate(ticketDetails.getDepart_date(), "MM/dd/yyyy") + "', " +
			 " return_date = '" + DateUtil.parseSQLDate(ticketDetails.getReturn_date(), "MM/dd/yyyy") + "', " +
			 " depart_airport = '" + ticketDetails.getDepart_airport() + "', " +
			 " arrive_airport = '" + ticketDetails.getArrive_airport() + "', " +
			 " primary_airline = '" + ticketDetails.getPrimary_airline() + "', " +
			 " totalCurrency = '" + ticketDetails.getTotalCurrency() + "', " +
			 " totalCharge = " + ticketDetails.getTotalCharge() + ", " +
			 " totalBase = " + ticketDetails.getTotalBase() + ", " +
			 " totalTax = " + ticketDetails.getTotalTax() + ", " +
			 " totalSurcharge = " + ticketDetails.getTotalSurcharge() + ", " +
			 " total_expenses = " + ticketDetails.getTotal_expenses() + ", " +
			 " total_margin = " + ticketDetails.getTotal_margin() + ", " +
			 " form_of_payment = '" + ticketDetails.getForm_of_payment() + "', " +
			 " receivedBy = '" + ticketDetails.getReceivedBy() + "', " +
			 " card_type = '" + ticketDetails.getCard_type() + "', " +
			 " card_number = '" + ticketDetails.getCard_number() + "', " +
			 " check_number = '" + ticketDetails.getCheck_number() + "', " +
			 " bank_name = '" + ticketDetails.getBank_name() + "', " +
			 " comments = '" + ticketDetails.getComments() + "', " +
			 " notes = '" + ticketDetails.getNotes() + "', " +
			 " tracking_link = '" + ticketDetails.getTracking_link() + "', " +
			 " tracking_number = '" + ticketDetails.getTracking_number() + "', " +
			 " mail_to = '" + ticketDetails.getMail_to() + "', " +
			 " mailingAddress_line1 = '" + ticketDetails.getMailingAddress_line1() + "', " +
			 " mailingAddress_line2 = '" + ticketDetails.getMailingAddress_line2() + "', " +
			 " mailingAddress_line3 = '" + ticketDetails.getMailingAddress_line3() + "', " +
			 " mailingAddress_city = '" + ticketDetails.getMailingAddress_city() + "', " +
			 " mailingAddress_state = '" + ticketDetails.getMailingAddress_state() + "', " +
			 " mailingAddress_zip = '" + ticketDetails.getMailingAddress_zip() + "', " +
			 " mailingAddress_country = '" + ticketDetails.getMailingAddress_country() + "', " +
			 " bill_to = '" + ticketDetails.getBill_to() + "', " +
			 " billingAddress_line1 = '" + ticketDetails.getBillingAddress_line1() + "', " +
			 " billingAddress_line2 = '" + ticketDetails.getBillingAddress_line2() + "', " +
			 " billingAddress_line3 = '" + ticketDetails.getBillingAddress_line3() + "', " +
			 " billingAddress_city = '" + ticketDetails.getBillingAddress_city() + "', " +
			 " billingAddress_state = '" + ticketDetails.getBillingAddress_state() + "', " +
			 " billingAddress_zip = '" + ticketDetails.getBillingAddress_zip() + "', " +
			 " billingAddress_country = '" + ticketDetails.getBillingAddress_country() + "', " +
			 " pax1Last_name = '" + ticketDetails.getPax1Last_name() + "', " +
			 " pax1First_name = '" + ticketDetails.getPax1First_name() + "', " +
			 " pax1Middle_name = '" + ticketDetails.getPax1Middle_name() + "', " +
			 " pax1Title = '" + ticketDetails.getPax1Title() + "', " +
			 " pax1Age = '" + ticketDetails.getPax1Age() + "', " +
			 " pax1Description = '" + ticketDetails.getPax1Description() + "', " +
			 " pax1Currency = '" + ticketDetails.getPax1Currency() + "', " +
			 " pax1Charge = " + ticketDetails.getPax1Charge() + ", " +
			 " pax1Base = " + ticketDetails.getPax1Base() + ", " +
			 " pax1Tax = " + ticketDetails.getPax1Tax() + ", " +
			 " pax1SurCharge = " + ticketDetails.getPax1Surcharge() + ", " +
			 " pax2Last_name = '" + ticketDetails.getPax2Last_name() + "', " +
			 " pax2First_name = '" + ticketDetails.getPax2First_name() + "', " +
			 " pax2Middle_name = '" + ticketDetails.getPax2Middle_name() + "', " +
			 " pax2Title = '" + ticketDetails.getPax2Title() + "', " +
			 " pax2Age = '" + ticketDetails.getPax2Age() + "', " +
			 " pax2Description = '" + ticketDetails.getPax2Description() + "', " +
			 " pax2Currency = '" + ticketDetails.getPax2Currency() + "', " +
			 " pax2Charge = " + ticketDetails.getPax2Charge() + ", " +
			 " pax2Base = " + ticketDetails.getPax2Base() + ", " +
			 " pax2Tax = " + ticketDetails.getPax2Tax() + ", " +
			 " pax2SurCharge = " + ticketDetails.getPax2Surcharge() + ", " +
			 " pax3Last_name = '" + ticketDetails.getPax3Last_name() + "', " +
			 " pax3First_name = '" + ticketDetails.getPax3First_name() + "', " +
			 " pax3Middle_name = '" + ticketDetails.getPax3Middle_name() + "', " +
			 " pax3Title = '" + ticketDetails.getPax3Title() + "', " +
			 " pax3Age = '" + ticketDetails.getPax3Age() + "', " +
			 " pax3Description = '" + ticketDetails.getPax3Description() + "', " +
			 " pax3Currency = '" + ticketDetails.getPax3Currency() + "', " +
			 " pax3Charge = " + ticketDetails.getPax3Charge() + ", " +
			 " pax3Base = " + ticketDetails.getPax3Base() + ", " +
			 " pax3Tax = " + ticketDetails.getPax3Tax() + ", " +
			 " pax3SurCharge = " + ticketDetails.getPax3Surcharge() + ", " +
			 " pax4Last_name = '" + ticketDetails.getPax4Last_name() + "', " +
			 " pax4First_name = '" + ticketDetails.getPax4First_name() + "', " +
			 " pax4Middle_name = '" + ticketDetails.getPax4Middle_name() + "', " +
			 " pax4Title = '" + ticketDetails.getPax4Title() + "', " +
			 " pax4Age = '" + ticketDetails.getPax4Age() + "', " +
			 " pax4Description = '" + ticketDetails.getPax4Description() + "', " +
			 " pax4Currency = '" + ticketDetails.getPax4Currency() + "', " +
			 " pax4Charge = " + ticketDetails.getPax4Charge() + ", " +
			 " pax4Base = " + ticketDetails.getPax4Base() + ", " +
			 " pax4Tax = " + ticketDetails.getPax4Tax() + ", " +
			 " pax4SurCharge = " + ticketDetails.getPax4Surcharge() + ", " +
			 " pax5First_name = '" + ticketDetails.getPax5First_name() + "', " +
			 " pax5Last_name = '" + ticketDetails.getPax5Last_name() + "', " +
			 " pax5Middle_name = '" + ticketDetails.getPax5Middle_name() + "', " +
			 " pax5Title = '" + ticketDetails.getPax5Title() + "', " +
			 " pax5Age = '" + ticketDetails.getPax5Age() + "', " +
			 " pax5Description = '" + ticketDetails.getPax5Description() + "', " +
			 " pax5Currency = '" + ticketDetails.getPax5Currency() + "', " +
			 " pax5Charge = " + ticketDetails.getPax5Charge() + ", " +
			 " pax5Base = " + ticketDetails.getPax5Base() + ", " +
			 " pax5Tax = " + ticketDetails.getPax5Tax() + ", " +
			 " pax5SurCharge = " + ticketDetails.getPax5Surcharge() + ", " +
			 " added_by = '" + ticketDetails.getAdded_by() + "', " +
			 " updated_by = '" + ticketDetails.getUpdated_by() + "', " +
			 " add_dttm = '" + DateUtil.parseSQLTimestamp(ticketDetails.getAdd_dttm(), "yyyy-MM-dd HH:mm") + "', " +
			 " update_dttm = '" + DateUtil.parseSQLTimestamp(ticketDetails.getUpdate_dttm(), "yyyy-MM-dd HH:mm") + "', " +
			 " delete_dttm = '" + DateUtil.parseSQLTimestamp(ticketDetails.getDelete_dttm(), "yyyy-MM-dd HH:mm") + "', " +
			 " raw_text = '" + ticketDetails.getRaw_text() + "' " +


			" WHERE ticket_id =" + ticketDetails.getTicket_id() ;

System.out.println(stmtString);
			stmt.executeUpdate(stmtString);
		} catch (SQLException ex) {
			log.error("Caught SQL Exception: " + ex);
			throw ex;
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				log.error("Could not close: " + ex);
				throw ex;
			}
		}
		closeDB();
	}

	// delete ticket details
	public TicketDetailsFormBean deleteTicketDetails(int ticket_id) throws Exception {
		log.info("inside ticketupdatedao.deleteTicketDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "DELETE FROM ticket WHERE ticket_id = " + ticket_id;
	
			stmt.executeUpdate(stmtString);
		} catch (SQLException ex) {
			log.error("Caught SQL Exception: " + ex);
			throw ex;
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				log.error("Could not close: " + ex);
				throw ex;
			}
		}
		closeDB();
		return null;
	}

	public int getNextInvoiceNumber() throws Exception {
		log.info("inside ticketupdatedao.getNextInvoiceNumber");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "SELECT MAX(invoice_number) FROM ticket";
	
			ResultSet rs = stmt.executeQuery(stmtString);
			while (rs.next()) {
				return (rs.getInt(1)+7);
			}
		} catch (SQLException ex) {
			log.error("Caught SQL Exception: " + ex);
			throw ex;
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				log.error("Could not close: " + ex);
				throw ex;
			}
		}
		closeDB();
		return 0;
	}
	

}
