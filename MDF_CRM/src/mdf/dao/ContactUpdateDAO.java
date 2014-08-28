package mdf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import mdf.forms.ContactDetailsFormBean;
import mdf.forms.ContactFormBean;
import mdf.utils.DateUtil;

public class ContactUpdateDAO extends BaseUpdateDAO {
	// add contact details
	public void addContactDetails(ContactDetailsFormBean contactDetails) throws Exception {
		addContactDetails((ContactFormBean)contactDetails);
	}
	
	public void addContactDetails(ContactFormBean contactDetails) throws Exception {
		log.info("inside contactupdatedao.addContactDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			int deleted_intval = 0;
			if (contactDetails.getDeleted()) deleted_intval = 1;
			stmtString = "INSERT INTO contact (contact_name, first_name, middle_name, last_name, num_referrals, num_tickets, num_open_tickets, num_queries, dues, insert_key, phone_work, phone_cell, phone_home, email_home, email_work, mailingAddress_line1, mailingAddress_line2, mailingAddress_line3, mailingAddress_city, mailingAddress_state, mailingAddress_zip, mailingAddress_country, billingAddress_line1, billingAddress_line2, billingAddress_line3, billingAddress_city, billingAddress_state, billingAddress_zip, billingAddress_country, contact_type, contact_source, tracking_number, itinerary_by, ticketed_by, deleted, add_dttm, update_dttm, delete_dttm, status, agent_assigned, status_history, referer_id, notes, num_itineraries, created_by, updated_by) " +  
				"VALUES (" +
				"'" + contactDetails.getContact_name() + "', " + 
				"'" + contactDetails.getFirst_name() + "', " +  
				"'" + contactDetails.getMiddle_name() + "', " + 
				"'" + contactDetails.getLast_name() + "', " +
				contactDetails.getNum_referrals() + ", " + 
				contactDetails.getNum_tickets() + ", " +
				contactDetails.getNum_open_tickets() + ", " +  
				contactDetails.getNum_queries() + ", " + 
				contactDetails.getDues() + ", " + 
				"'" + contactDetails.getInsert_key() + "', " + 
				"'" + contactDetails.getPhone_work() + "', " +
				"'" + contactDetails.getPhone_cell() + "', " +
				"'" + contactDetails.getPhone_home() + "', " +
				"'" + contactDetails.getEmail_home() + "', " + 
				"'" + contactDetails.getEmail_work() + "', " + 
				"'" + contactDetails.getMailingAddress_line1() + "', " + 
				"'" + contactDetails.getMailingAddress_line2() + "', " + 
				"'" + contactDetails.getMailingAddress_line3() + "', " + 
				"'" + contactDetails.getMailingAddress_city() + "', " + 
				"'" + contactDetails.getMailingAddress_state() + "', " + 
				"'" + contactDetails.getMailingAddress_zip() + "', " + 
				"'" + contactDetails.getMailingAddress_country() + "', " + 
				"'" + contactDetails.getBillingAddress_line1() + "', " + 
				"'" + contactDetails.getBillingAddress_line2() + "', " + 
				"'" + contactDetails.getBillingAddress_line3() + "', " + 
				"'" + contactDetails.getBillingAddress_city() + "', " + 
				"'" + contactDetails.getBillingAddress_state() + "', " + 
				"'" + contactDetails.getBillingAddress_zip() + "', " + 
				"'" + contactDetails.getBillingAddress_country() + "', " + 
				"'" + contactDetails.getContact_type() + "', " + 
				"'" + contactDetails.getContact_source() + "', " + 
				"'" + contactDetails.getTracking_number() + "', " + 
				"'" + contactDetails.getItinerary_by() + "', " + 
				"'" + contactDetails.getTicketed_by() + "', " + 
				deleted_intval + ", " +
				"'" + DateUtil.parseSQLTimestamp(contactDetails.getAdd_dttm(), "yyyy-MM-dd HH:mm") + "', " + 
				"'" + DateUtil.parseSQLTimestamp(contactDetails.getUpdate_dttm(), "yyyy-MM-dd HH:mm") + "', " + 
				"'" + DateUtil.parseSQLTimestamp(contactDetails.getDelete_dttm(), "yyyy-MM-dd HH:mm") + "', " + 
				"'" + contactDetails.getStatus() + "', " +  
				"'" + contactDetails.getAgent_assigned() + "', " +  
				"'" + contactDetails.getStatus_history() + "', " +  
				contactDetails.getReferer_id() +  ", " +
				"'" + contactDetails.getNotes() +  "', " +
				contactDetails.getNum_itineraries() + ", " +
				"'" + contactDetails.getCreated_by() + "', " +
				"'" + contactDetails.getUpdated_by() + "') " 
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

	public List lookupContact(ContactDetailsFormBean contactBean) throws Exception {
		log.info("inside contactupdatedao.lookupContactDetails");
		ContactFormBean contact = (ContactFormBean)contactBean;
		return(lookupContact(contact));
	}
	public List lookupContact(ContactFormBean contactBean) throws Exception {
		log.info("inside contactupdatedao.lookupContact");
		List contactsList = new ArrayList();
		String paramString = "";
		String orderString = "";
		boolean queryParam = false;
		try {
			// and execute a simple query 
			if (!contactBean.getContact_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR ";
					orderString += ",";
				}
				paramString += " contact_name LIKE '" + contactBean.getContact_name() + "%'";
				orderString += " contact_name";
				queryParam = true;
			}
			if (!contactBean.getFirst_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " first_name LIKE '" + contactBean.getFirst_name() + "%'";
				orderString += " first_name";
				queryParam = true;
			}
			if (!contactBean.getMiddle_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " middle_name LIKE '" + contactBean.getMiddle_name() + "%'";
				orderString += " middle_name";
				queryParam = true;
			}
			if (!contactBean.getLast_name().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " last_name LIKE '" + contactBean.getLast_name() + "%'";
				orderString += " last_name";
			}
			if (!contactBean.getPhone_work().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " phone_work LIKE '" + contactBean.getPhone_work() + "%'";
				orderString += " phone_work";
				queryParam = true;
			}
			if (!contactBean.getPhone_cell().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " phone_cell LIKE '" + contactBean.getPhone_cell() + "%'";
				orderString += " phone_cell";
				queryParam = true;
			}
			if (!contactBean.getPhone_home().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " phone_home LIKE '" + contactBean.getPhone_home() + "%'";
				orderString += " phone_home";
				queryParam = true;
			}
			if (!contactBean.getEmail_work().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " email_work LIKE '" + contactBean.getEmail_work() + "%'";
				orderString += " email_work";
				queryParam = true;
			}
			if (!contactBean.getEmail_home().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " email_home LIKE '" + contactBean.getEmail_home() + "%'";
				orderString += " email_home";
				queryParam = true;
			}if (!contactBean.getAgent_assigned().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " agent_assigned LIKE '" + contactBean.getAgent_assigned() + "%'";
				orderString += " agent_assigned, status";
				queryParam = true;
			}

			if (queryParam == true) {
				paramString = " WHERE " + paramString + " AND deleted = 0 ";
				orderString = " ORDER BY " + orderString + " ,update_dttm DESC, contact_id DESC";
			}
			contactsList = getContactInfo(paramString, orderString); 

			for (int i=0; i<contactsList.size(); i++) {
				ContactDetailsFormBean contact = (ContactDetailsFormBean)contactsList.get(i);
				contact.setUi_name(contactBean.getUi_name());
				contact.setUi_number(contactBean.getUi_number());
				contact.setUi_email(contactBean.getUi_email());
			}
		} catch (Exception ex) {
			log.error("Caught Exception: " + ex);
			throw ex;
		}
		return contactsList;
	}
	
	// get contact info by ID
	public ContactFormBean getContactInfoByID(int contact_id) throws Exception {
		log.info("inside contactupdatedao.getContactInfoByID");
		String paramString = "WHERE contact_id =" + contact_id;
		List contactsList = getContactInfo(paramString, ""); 
		if (contactsList != null && contactsList.size()>0) 
			return (ContactFormBean)contactsList.get(0);
		else return null;
	}
	
	// get contact info by InsertKey
	public ContactFormBean getContactInfoByInsertKey(String insert_key) throws Exception {
		log.info("inside contactupdatedao.getContactInfoByInsertKey");
		String paramString = "WHERE insert_key ='" + insert_key + "'";
		List contactsList = getContactInfo(paramString, ""); 
		if (contactsList != null && contactsList.size()>0) 
			return (ContactFormBean)contactsList.get(0);
		else return null;
	}
	
	// get contact info
	public List getContactInfo(String paramString, String orderString) throws Exception {
		log.info("inside contactupdatedao.getContactInfo");
		Statement stmt = null;
		String stmtString = "";
		List contactsList = new ArrayList();
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "SELECT * FROM contact " + paramString + orderString;
			log.info(stmtString);

			ResultSet rs = stmt.executeQuery(stmtString);
		
			while (rs.next()) {
				// iterate through the result set and get first record
				ContactDetailsFormBean contact = new ContactDetailsFormBean();
				contact.setContact_id(rs.getInt("contact_id"));
				if (rs.getString("contact_name")==null) contact.setContact_name(""); else 
					contact.setContact_name(rs.getString("contact_name"));
				if (rs.getString("first_name")==null) contact.setFirst_name(""); else 
					contact.setFirst_name(rs.getString("first_name"));
				if (rs.getString("middle_name")==null) contact.setMiddle_name(""); else 
					contact.setMiddle_name(rs.getString("middle_name"));
				if (rs.getString("last_name")==null) contact.setLast_name(""); else 
					contact.setLast_name(rs.getString("last_name"));
				contact.setNum_referrals(rs.getInt("num_referrals"));
				contact.setNum_tickets(rs.getInt("num_tickets"));
				contact.setNum_open_tickets(rs.getInt("num_open_tickets"));
				contact.setNum_queries(rs.getInt("num_queries"));
				contact.setDues(rs.getDouble("dues"));
				if (rs.getString("insert_key")==null) contact.setInsert_key(""); else 
					contact.setInsert_key(rs.getString("insert_key"));
				if (rs.getString("phone_work")==null) contact.setPhone_work(""); else 
					contact.setPhone_work(rs.getString("phone_work"));
				if (rs.getString("phone_cell")==null) contact.setPhone_cell(""); else 
					contact.setPhone_cell(rs.getString("phone_cell"));
				if (rs.getString("phone_home")==null) contact.setPhone_home(""); else 
					contact.setPhone_home(rs.getString("phone_home"));
				if (rs.getString("email_home")==null) contact.setEmail_home(""); else 
					contact.setEmail_home(rs.getString("email_home"));
				if (rs.getString("email_work")==null) contact.setEmail_work(""); else 
					contact.setEmail_work(rs.getString("email_work"));
				if (rs.getString("mailingAddress_line1")==null) contact.setMailingAddress_line1(""); else 
					contact.setMailingAddress_line1(rs.getString("mailingAddress_line1"));
				if (rs.getString("mailingAddress_line2")==null) contact.setMailingAddress_line2(""); else 
					contact.setMailingAddress_line2(rs.getString("mailingAddress_line2"));
				if (rs.getString("mailingAddress_line3")==null) contact.setMailingAddress_line3(""); else 
					contact.setMailingAddress_line3(rs.getString("mailingAddress_line3"));
				if (rs.getString("mailingAddress_city")==null) contact.setMailingAddress_city(""); else 
					contact.setMailingAddress_city(rs.getString("mailingAddress_city"));
				if (rs.getString("mailingAddress_state")==null) contact.setMailingAddress_state(""); else 
					contact.setMailingAddress_state(rs.getString("mailingAddress_state"));
				if (rs.getString("mailingAddress_zip")==null) contact.setMailingAddress_zip(""); else 
					contact.setMailingAddress_zip(rs.getString("mailingAddress_zip"));
				if (rs.getString("mailingAddress_country")==null) contact.setMailingAddress_country(""); else 
					contact.setMailingAddress_country(rs.getString("mailingAddress_country"));
				if (rs.getString("billingAddress_line1")==null) contact.setBillingAddress_line1(""); else 
					contact.setBillingAddress_line1(rs.getString("billingAddress_line1"));
				if (rs.getString("billingAddress_line2")==null) contact.setBillingAddress_line2(""); else 
					contact.setBillingAddress_line2(rs.getString("billingAddress_line2"));
				if (rs.getString("billingAddress_line3")==null) contact.setBillingAddress_line3(""); else 
					contact.setBillingAddress_line3(rs.getString("billingAddress_line3"));
				if (rs.getString("billingAddress_city")==null) contact.setBillingAddress_city(""); else 
					contact.setBillingAddress_city(rs.getString("billingAddress_city"));
				if (rs.getString("billingAddress_state")==null) contact.setBillingAddress_state(""); else 
					contact.setBillingAddress_state(rs.getString("billingAddress_state"));
				if (rs.getString("billingAddress_zip")==null) contact.setBillingAddress_zip(""); else 
					contact.setBillingAddress_zip(rs.getString("billingAddress_zip"));
				if (rs.getString("billingAddress_country")==null) contact.setBillingAddress_country(""); else 
					contact.setBillingAddress_country(rs.getString("billingAddress_country"));
				if (rs.getString("contact_type")==null) contact.setContact_type(""); else 
					contact.setContact_type(rs.getString("contact_type"));
				if (rs.getString("contact_source")==null) contact.setContact_source(""); else 
					contact.setContact_source(rs.getString("contact_source"));
				if (rs.getString("tracking_number")==null) contact.setTracking_number(""); else 
					contact.setTracking_number(rs.getString("tracking_number"));
				if (rs.getString("itinerary_by")==null) contact.setItinerary_by(""); else 
					contact.setItinerary_by(rs.getString("itinerary_by"));
				if (rs.getString("ticketed_by")==null) contact.setTicketed_by(""); else 
					contact.setTicketed_by(rs.getString("ticketed_by"));
				contact.setDeleted(rs.getBoolean("deleted"));
				contact.setAdd_dttm(DateUtil.formatDate(rs.getTimestamp("add_dttm"), "yyyy-MM-dd HH:mm"));
				contact.setUpdate_dttm(DateUtil.formatDate(rs.getTimestamp("update_dttm"), "yyyy-MM-dd HH:mm"));
				contact.setDelete_dttm(DateUtil.formatDate(rs.getTimestamp("delete_dttm"), "yyyy-MM-dd HH:mm"));
				if (rs.getString("status")==null) contact.setStatus(""); else 
					contact.setStatus(rs.getString("status"));
				if (rs.getString("agent_assigned")==null) contact.setAgent_assigned(""); else 
					contact.setAgent_assigned(rs.getString("agent_assigned"));
				if (rs.getString("status_history")==null) contact.setStatus_history(""); else 
					contact.setStatus_history(rs.getString("status_history"));
				contact.setReferer_id(rs.getInt("referer_id"));
				if (rs.getString("notes")==null) contact.setNotes(""); else 
					contact.setNotes(rs.getString("notes"));
				contact.setNum_itineraries(rs.getInt("num_itineraries"));
				if (rs.getString("created_by")==null) contact.setCreated_by(""); else 
					contact.setCreated_by(rs.getString("created_by"));
				if (rs.getString("updated_by")==null) contact.setUpdated_by(""); else 
					contact.setUpdated_by(rs.getString("updated_by"));
				
				//set contact name if blank
	    		if (contact.getContact_name()==null || contact.getContact_name().equals("")) {
	    			contact.setContact_name((contact.getFirst_name() + " " + contact.getMiddle_name() + " " + contact.getLast_name()).trim());
	    		}
				contactsList.add(contact);
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
		return contactsList;
	}
	
	//	 get contact details
	public ContactDetailsFormBean getContactDetails(int contact_id) throws Exception {
		log.info("inside contactupdatedao.getContactDetails");
		ContactDetailsFormBean contactDetails = new ContactDetailsFormBean();
		contactDetails = (ContactDetailsFormBean)getContactInfoByID(contact_id);
		
		if (contactDetails.getNum_itineraries() >0) {
			ItineraryUpdateDAO itinDAO = new ItineraryUpdateDAO();
			contactDetails.setItinerariesList(itinDAO.getItineraryInfoListByContact(contact_id));
		}
		return contactDetails;
	}
	
	// save contact details
	public void saveContactDetails(ContactDetailsFormBean contactDetails) throws Exception {
		log.info("inside contactupdatedao.saveContactDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			int deleted_intval = 0;
			if (contactDetails.getDeleted()) deleted_intval = 1;
			stmtString = "UPDATE contact SET " +
			" contact_name = '" + contactDetails.getContact_name() + "', " + 
			" first_name = '" + contactDetails.getFirst_name() + "', " +  
			" middle_name = '" + contactDetails.getMiddle_name() + "', " + 
			" last_name = '" + contactDetails.getLast_name() + "', " +
			" num_referrals = " + contactDetails.getNum_referrals() + ", " + 
			" num_tickets = " + contactDetails.getNum_tickets() + ", " +
			" num_open_tickets = " + contactDetails.getNum_open_tickets() + ", " + 
			" num_queries = " + contactDetails.getNum_queries() + ", " +
			" dues = " + contactDetails.getDues() + ", " +
			" insert_key = '" + contactDetails.getInsert_key() + "', " + 
			" phone_work = '" + contactDetails.getPhone_work() + "', " +
			" phone_cell = '" + contactDetails.getPhone_cell() + "', " +
			" phone_home = '" + contactDetails.getPhone_home() + "', " +
			" email_home = '" + contactDetails.getEmail_home() + "', " + 
			" email_work = '" + contactDetails.getEmail_work() + "', " + 
			" mailingAddress_line1 = '" + contactDetails.getMailingAddress_line1() + "', " + 
			" mailingAddress_line2 = '" + contactDetails.getMailingAddress_line2() + "', " + 
			" mailingAddress_line3 = '" + contactDetails.getMailingAddress_line3() + "', " + 
			" mailingAddress_city = '" + contactDetails.getMailingAddress_city() + "', " + 
			" mailingAddress_state = '" + contactDetails.getMailingAddress_state() + "', " + 
			" mailingAddress_zip = '" + contactDetails.getMailingAddress_zip() + "', " + 
			" mailingAddress_country = '" + contactDetails.getMailingAddress_country() + "', " + 
			" billingAddress_line1 = '" + contactDetails.getBillingAddress_line1() + "', " + 
			" billingAddress_line2 = '" + contactDetails.getBillingAddress_line2() + "', " + 
			" billingAddress_line3 = '" + contactDetails.getBillingAddress_line3() + "', " + 
			" billingAddress_city = '" + contactDetails.getBillingAddress_city() + "', " + 
			" billingAddress_state = '" + contactDetails.getBillingAddress_state() + "', " + 
			" billingAddress_zip = '" + contactDetails.getBillingAddress_zip() + "', " + 
			" billingAddress_country = '" + contactDetails.getBillingAddress_country() + "', " + 
			" contact_type = '" + contactDetails.getContact_type() + "', " + 
			" contact_source = '" + contactDetails.getContact_source() + "', " + 
			" tracking_number = '" + contactDetails.getTracking_number() + "', " + 
			" itinerary_by = '" + contactDetails.getItinerary_by() + "', " + 
			" ticketed_by = '" + contactDetails.getTicketed_by() + "', " + 
			" deleted = " + deleted_intval + ", " + 
			" add_dttm = '" + DateUtil.parseSQLTimestamp(contactDetails.getAdd_dttm(), "yyyy-MM-dd HH:mm") + "', " + 
			" update_dttm = '" + DateUtil.parseSQLTimestamp(contactDetails.getUpdate_dttm(), "yyyy-MM-dd HH:mm") + "', " + 
			" delete_dttm = '" + DateUtil.parseSQLTimestamp(contactDetails.getDelete_dttm(), "yyyy-MM-dd HH:mm") + "', " + 
			" status = '" + contactDetails.getStatus() + "', " + 
			" agent_assigned = '" + contactDetails.getAgent_assigned() + "', " + 
			" status_history = '" + contactDetails.getStatus_history() + "', " + 
			" referer_id = " + contactDetails.getReferer_id() + ", " + 
			" notes = '" + contactDetails.getNotes() + "', " + 
			" num_itineraries = " + contactDetails.getNum_itineraries() + ", " +  
			" created_by = '" + contactDetails.getCreated_by() + "', " + 
			" updated_by = '" + contactDetails.getUpdated_by() + "' " + 
			" WHERE contact_id =" + contactDetails.getContact_id() ;

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

	
	// get contact details
	public void saveContactDetails(ContactDetailsFormBean contactDetails, String changedTokens) throws Exception {
		log.info("inside contactupdatedao.saveContactDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			StringTokenizer st = new StringTokenizer(changedTokens, ",");
			String updateString = "";
			stmtString = "UPDATE contact SET " ;
			log.info(changedTokens);
			int deleted_intval = 0;
			if (contactDetails.getDeleted()) deleted_intval = 1;
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				log.info(token);
				if (!updateString.equals(""))
					updateString += ", ";
				if (token.equalsIgnoreCase("contact_name")) {
					updateString +=  " contact_name = '" + contactDetails.getContact_name() + "' ";
				} else if (token.equalsIgnoreCase("first_name")) {
					updateString +=  " first_name = '" + contactDetails.getFirst_name() + "' "; 
				} else if (token.equalsIgnoreCase("middle_name")) {
					updateString +=  " middle_name = '" + contactDetails.getMiddle_name() + "' ";
				} else if (token.equalsIgnoreCase("last_name")) {
					updateString +=  " last_name = '" + contactDetails.getLast_name() + "' ";
				} else if (token.equalsIgnoreCase("num_referrals")) {
					updateString +=  " num_referrals = " + contactDetails.getNum_referrals() + ", "; 
				} else if (token.equalsIgnoreCase("num_tickets")) {
					updateString +=  " num_tickets = " + contactDetails.getNum_tickets() + ", ";
				} else if (token.equalsIgnoreCase("num_open_tickets")) {
					updateString +=  " num_open_tickets = " + contactDetails.getNum_open_tickets() + ", "; 
				} else if (token.equalsIgnoreCase("num_queries")) {
					updateString +=  " num_queries = " + contactDetails.getNum_queries() + ", ";
				} else if (token.equalsIgnoreCase("dues")) {
					updateString +=  " dues = " + contactDetails.getDues() + ", ";
				} else if (token.equalsIgnoreCase("insert_key")) {
					updateString +=  " insert_key = '" + contactDetails.getInsert_key() + "' "; 
				} else if (token.equalsIgnoreCase("phone_work")) {
					updateString +=  " phone_work = '" + contactDetails.getPhone_work() + "' "; 
				} else if (token.equalsIgnoreCase("phone_cell")) {
					updateString +=  " phone_cell = '" + contactDetails.getPhone_cell() + "' "; 
				} else if (token.equalsIgnoreCase("phone_home")) {
					updateString +=  " phone_home = '" + contactDetails.getPhone_home() + "' "; 
				} else if (token.equalsIgnoreCase("email_home")) {
					updateString +=  " email_home = '" + contactDetails.getEmail_home() + "' "; 
				} else if (token.equalsIgnoreCase("email_work")) {
					updateString +=  " email_work = '" + contactDetails.getEmail_work() + "' "; 
				} else if (token.equalsIgnoreCase("mailingAddress_line1")) {
					updateString +=  " mailingAddress_line1 = '" + contactDetails.getMailingAddress_line1() + "' "; 
				} else if (token.equalsIgnoreCase("mailingAddress_line2")) {
					updateString +=  " mailingAddress_line2 = '" + contactDetails.getMailingAddress_line2() + "' ";
				} else if (token.equalsIgnoreCase("mailingAddress_line3")) {
					updateString +=  " mailingAddress_line3 = '" + contactDetails.getMailingAddress_line3() + "' ";
				} else if (token.equalsIgnoreCase("mailingAddress_city")) {
					updateString +=  " mailingAddress_city = '" + contactDetails.getMailingAddress_city() + "' ";
				} else if (token.equalsIgnoreCase("mailingAddress_state")) {
					updateString +=  " mailingAddress_state = '" + contactDetails.getMailingAddress_state() + "' ";
				} else if (token.equalsIgnoreCase("mailingAddress_zip")) {
					updateString +=  " mailingAddress_zip = '" + contactDetails.getMailingAddress_zip() + "' ";
				} else if (token.equalsIgnoreCase("mailingAddress_country")) {
					updateString +=  " mailingAddress_country = '" + contactDetails.getMailingAddress_country() + "' ";
				} else if (token.equalsIgnoreCase("billingAddress_line1")) {
					updateString +=  " billingAddress_line1 = '" + contactDetails.getBillingAddress_line1() + "' ";
				} else if (token.equalsIgnoreCase("billingAddress_line2")) {
					updateString +=  " billingAddress_line2 = '" + contactDetails.getBillingAddress_line2() + "' ";
				} else if (token.equalsIgnoreCase("billingAddress_line3")) {
					updateString +=  " billingAddress_line3 = '" + contactDetails.getBillingAddress_line3() + "' ";
				} else if (token.equalsIgnoreCase("billingAddress_city")) {
					updateString +=  " billingAddress_city = '" + contactDetails.getBillingAddress_city() + "' ";
				} else if (token.equalsIgnoreCase("billingAddress_state")) {
					updateString +=  " billingAddress_state = '" + contactDetails.getBillingAddress_state() + "' ";
				} else if (token.equalsIgnoreCase("billingAddress_zip")) {
					updateString +=  " billingAddress_zip = '" + contactDetails.getBillingAddress_zip() + "' ";
				} else if (token.equalsIgnoreCase("billingAddress_country")) {
					updateString +=  " billingAddress_country = '" + contactDetails.getBillingAddress_country() + "' ";
				} else if (token.equalsIgnoreCase("contact_type")) {
					updateString +=  " contact_type = '" + contactDetails.getContact_type() + "' ";
				} else if (token.equalsIgnoreCase("contact_source")) {
					updateString +=  " contact_source = '" + contactDetails.getContact_source() + "' ";
				} else if (token.equalsIgnoreCase("tracking_number")) {
					updateString +=  " tracking_number = '" + contactDetails.getTracking_number() + "' ";
				} else if (token.equalsIgnoreCase("itinerary_by")) {
					updateString +=  " itinerary_by = '" + contactDetails.getItinerary_by() + "' ";
				} else if (token.equalsIgnoreCase("ticketed_by")) {
					updateString +=  " ticketed_by = '" + contactDetails.getTicketed_by() + "' ";
				} else if (token.equalsIgnoreCase("deleted")) {
					updateString +=  " deleted = " + deleted_intval + " ";
				} else if (token.equalsIgnoreCase("add_dttm")) {
					updateString +=  " add_dttm = " + contactDetails.getAdd_dttm() + ", "; 
				} else if (token.equalsIgnoreCase("update_dttm")) {
					updateString +=  " update_dttm = " + contactDetails.getUpdate_dttm() + ", "; 
				} else if (token.equalsIgnoreCase("delete_dttm")) {
					updateString +=  " delete_dttm = " + contactDetails.getDelete_dttm() + ", "; 
				} else if (token.equalsIgnoreCase("status")) {
					updateString +=  " status = '" + contactDetails.getStatus() + "' ";
				} else if (token.equalsIgnoreCase("agent_assigned")) {
					updateString +=  " agent_assigned = '" + contactDetails.getAgent_assigned() + "' ";
				} else if (token.equalsIgnoreCase("status_history")) {
					updateString +=  " status_history = '" + contactDetails.getStatus_history() + "' ";
				} else if (token.equalsIgnoreCase("referer_id")) {
					updateString +=  " referer_id = " + contactDetails.getReferer_id() + ", "; 
				} else if (token.equalsIgnoreCase("notes")) {
					updateString +=  " notes = '" + contactDetails.getNotes() + "', ";
				} else if (token.equalsIgnoreCase("num_itineraries")) {
					updateString +=  " num_itineraries = " + contactDetails.getNum_itineraries() + ", "; 
				} else if (token.equalsIgnoreCase("created_by")) {
					updateString +=  " created_by = '" + contactDetails.getCreated_by() + "', ";
				} else if (token.equalsIgnoreCase("updated_by")) {
					updateString +=  " updated_by = '" + contactDetails.getUpdated_by() + "' ";
				}
			}
			if (!updateString.equals("")) {
				//updateString +=  " contact_id = " + contactDetails.getContact_id() + " ";
				stmtString += updateString + 
					" WHERE contact_id =" + contactDetails.getContact_id();
	
				stmt.executeUpdate(stmtString);
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
	}

	// delete contact details
	public ContactDetailsFormBean deleteContactDetails(int contact_id) throws Exception {
		log.info("inside contactupdatedao.deleteContactDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "DELETE FROM contact WHERE contact_id = " + contact_id;
	
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
	

}
