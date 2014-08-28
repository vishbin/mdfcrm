package mdf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import mdf.forms.ContactDetailsFormBean;
import mdf.forms.ContactFormBean;

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
			java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
			if (contactDetails.getDeleted()) deleted_intval = 1;
			stmtString = "INSERT INTO contact (contact_name, first_name, middle_name, last_name, num_referrals, num_tickets, num_open_tickets, num_queries, dues, insert_key, phone_work, phone_cell, phone_home, email_home, email_work, address_line1_home, address_line2_home, address_line3_home, city_home, state_home, zip_home, country_home, address_line1_work, address_line2_work, address_line3_work, city_work, state_work, zip_work, country_work, contact_type, deleted, add_dttm, update_dttm, delete_dttm, status, agent_assigned, status_history, referer_id, notes, num_itineraries, created_by, updated_by) " +  
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
				"'" + contactDetails.getAddress_line1_home() + "', " + 
				"'" + contactDetails.getAddress_line2_home() + "', " + 
				"'" + contactDetails.getAddress_line3_home() + "', " + 
				"'" + contactDetails.getCity_home() + "', " + 
				"'" + contactDetails.getState_home() + "', " + 
				"'" + contactDetails.getZip_home() + "', " + 
				"'" + contactDetails.getCountry_home() + "', " + 
				"'" + contactDetails.getAddress_line1_work() + "', " + 
				"'" + contactDetails.getAddress_line2_work() + "', " + 
				"'" + contactDetails.getAddress_line3_work() + "', " + 
				"'" + contactDetails.getCity_work() + "', " + 
				"'" + contactDetails.getState_work() + "', " + 
				"'" + contactDetails.getZip_work() + "', " + 
				"'" + contactDetails.getCountry_work() + "', " + 
				"'" + contactDetails.getContact_type() + "', " + 
				deleted_intval + ", " +
				"'" + (java.sql.Date)currentDate +  "', " + //contactDetails.getAdd_dttm()
				"'" + (java.sql.Date)(currentDate) +  "', " + //contactDetails.getUpdate_dttm() 
				null +  ", " + //contactDetails.getDelete_dttm()
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
				log.error("Could not close: " + ex + "<br>");
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
		boolean queryParam = false;
		try {
			// and execute a simple query 
			if (!contactBean.getContact_name().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " contact_name LIKE '" + contactBean.getContact_name() + "%'";
				queryParam = true;
			}
			if (!contactBean.getFirst_name().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " first_name LIKE '" + contactBean.getFirst_name() + "%'";
				queryParam = true;
			}
			if (!contactBean.getMiddle_name().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " middle_name LIKE '" + contactBean.getMiddle_name() + "%'";
				queryParam = true;
			}
			if (!contactBean.getLast_name().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " last_name LIKE '" + contactBean.getLast_name() + "%'";
				queryParam = true;
			}
			if (!contactBean.getPhone_work().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " phone_work LIKE '" + contactBean.getPhone_work() + "%'";
				queryParam = true;
			}
			if (!contactBean.getPhone_cell().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " phone_cell LIKE '" + contactBean.getPhone_cell() + "%'";
				queryParam = true;
			}
			if (!contactBean.getPhone_home().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " phone_home LIKE '" + contactBean.getPhone_home() + "%'";
				queryParam = true;
			}
			if (!contactBean.getEmail_work().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " email_work LIKE '" + contactBean.getEmail_work() + "%'";
				queryParam = true;
			}
			if (!contactBean.getEmail_home().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " email_home LIKE '" + contactBean.getEmail_home() + "%'";
				queryParam = true;
			}if (!contactBean.getAgent_assigned().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " agent_assigned LIKE '" + contactBean.getAgent_assigned() + "%'";
				queryParam = true;
			}

			if (queryParam == true) paramString = " WHERE " + paramString;
			contactsList = getContactInfo(paramString); 

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
		List contactsList = getContactInfo(paramString); 
		if (contactsList != null && contactsList.size()>0) 
			return (ContactFormBean)contactsList.get(0);
		else return null;
	}
	
	// get contact info by InsertKey
	public ContactFormBean getContactInfoByInsertKey(String insert_key) throws Exception {
		log.info("inside contactupdatedao.getContactInfoByInsertKey");
		String paramString = "WHERE insert_key ='" + insert_key + "'";
		List contactsList = getContactInfo(paramString); 
		if (contactsList != null && contactsList.size()>0) 
			return (ContactFormBean)contactsList.get(0);
		else return null;
	}
	
	// get contact info
	public List getContactInfo(String paramString) throws Exception {
		log.info("inside contactupdatedao.getContactInfo");
		Statement stmt = null;
		String stmtString = "";
		List contactsList = new ArrayList();
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "SELECT * FROM contact " + paramString;


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
				if (rs.getString("address_line1_home")==null) contact.setAddress_line1_home(""); else 
					contact.setAddress_line1_home(rs.getString("address_line1_home"));
				if (rs.getString("address_line2_home")==null) contact.setAddress_line2_home(""); else 
					contact.setAddress_line2_home(rs.getString("address_line2_home"));
				if (rs.getString("address_line3_home")==null) contact.setAddress_line3_home(""); else 
					contact.setAddress_line3_home(rs.getString("address_line3_home"));
				if (rs.getString("city_home")==null) contact.setCity_home(""); else 
					contact.setCity_home(rs.getString("city_home"));
				if (rs.getString("state_home")==null) contact.setState_home(""); else 
					contact.setState_home(rs.getString("state_home"));
				if (rs.getString("zip_home")==null) contact.setZip_home(""); else 
					contact.setZip_home(rs.getString("zip_home"));
				if (rs.getString("country_home")==null) contact.setCountry_home(""); else 
					contact.setCountry_home(rs.getString("country_home"));
				if (rs.getString("address_line1_work")==null) contact.setAddress_line1_work(""); else 
					contact.setAddress_line1_work(rs.getString("address_line1_work"));
				if (rs.getString("address_line2_work")==null) contact.setAddress_line2_work(""); else 
					contact.setAddress_line2_work(rs.getString("address_line2_work"));
				if (rs.getString("address_line3_work")==null) contact.setAddress_line3_work(""); else 
					contact.setAddress_line3_work(rs.getString("address_line3_work"));
				if (rs.getString("city_work")==null) contact.setCity_work(""); else 
					contact.setCity_work(rs.getString("city_work"));
				if (rs.getString("state_work")==null) contact.setState_work(""); else 
					contact.setState_work(rs.getString("state_work"));
				if (rs.getString("zip_work")==null) contact.setZip_work(""); else 
					contact.setZip_work(rs.getString("zip_work"));
				if (rs.getString("country_work")==null) contact.setCountry_work(""); else 
					contact.setCountry_work(rs.getString("country_work"));
				if (rs.getString("contact_type")==null) contact.setContact_type(""); else 
					contact.setContact_type(rs.getString("contact_type"));
				contact.setDeleted(rs.getBoolean("deleted"));
				contact.setAdd_dttm(rs.getDate("add_dttm"));
				contact.setUpdate_dttm(rs.getDate("update_dttm"));
				contact.setDelete_dttm(rs.getDate("delete_dttm"));
				if (rs.getString("status")==null) contact.setStatus(""); else 
					contact.setStatus(rs.getString("status"));
				if (rs.getString("agent_assigned")==null) contact.setAgent_assigned(""); else 
					contact.setAgent_assigned(rs.getString("agent_assigned"));
				if (rs.getString("status_history")==null) contact.setStatus_history(""); else 
					contact.setStatus_history(rs.getString("status_history"));
				if (rs.getString("created_by")==null) contact.setCreated_by(""); else 
					contact.setCreated_by(rs.getString("created_by"));
				if (rs.getString("updated_by")==null) contact.setUpdated_by(""); else 
					contact.setUpdated_by(rs.getString("updated_by"));
				contact.setReferer_id(rs.getInt("referer_id"));
				if (rs.getString("notes")==null) contact.setNotes(""); else 
					contact.setNotes(rs.getString("notes"));
				contact.setNum_itineraries(rs.getInt("num_itineraries"));
				
				//set contact name if blank
	    		if (contact.getContact_name()!=null) {
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
			" address_line1_home = '" + contactDetails.getAddress_line1_home() + "', " + 
			" address_line2_home = '" + contactDetails.getAddress_line2_home() + "', " + 
			" address_line3_home = '" + contactDetails.getAddress_line3_home() + "', " + 
			" city_home = '" + contactDetails.getCity_home() + "', " + 
			" state_home = '" + contactDetails.getState_home() + "', " + 
			" zip_home = '" + contactDetails.getZip_home() + "', " + 
			" country_home = '" + contactDetails.getCountry_home() + "', " + 
			" address_line1_work = '" + contactDetails.getAddress_line1_work() + "', " + 
			" address_line2_work = '" + contactDetails.getAddress_line2_work() + "', " + 
			" address_line3_work = '" + contactDetails.getAddress_line3_work() + "', " + 
			" city_work = '" + contactDetails.getCity_work() + "', " + 
			" state_work = '" + contactDetails.getState_work() + "', " + 
			" zip_work = '" + contactDetails.getZip_work() + "', " + 
			" country_work = '" + contactDetails.getCountry_work() + "', " + 
			" contact_type = '" + contactDetails.getContact_type() + "', " + 
			" deleted = " + deleted_intval + ", " + 
			" add_dttm = " + contactDetails.getAdd_dttm() + ", " + 
			" update_dttm = " + contactDetails.getUpdate_dttm() + ", " + 
			" delete_dttm = " + contactDetails.getDelete_dttm() + ", " + 
			" status = '" + contactDetails.getStatus() + "', " + 
			" agent_assigned = '" + contactDetails.getAgent_assigned() + "', " + 
			" status_history = '" + contactDetails.getStatus_history() + "', " + 
			" referer_id = " + contactDetails.getReferer_id() + ", " + 
			" notes = '" + contactDetails.getNotes() + "', " + 
			" num_itineraries = " + contactDetails.getNum_itineraries() + " " +  
			" WHERE contact_id =" + contactDetails.getContact_id() ;


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
				log.info("kaushik1212");
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
				} else if (token.equalsIgnoreCase("address_line1_home")) {
					updateString +=  " address_line1_home = '" + contactDetails.getAddress_line1_home() + "' "; 
				} else if (token.equalsIgnoreCase("address_line2_home")) {
					updateString +=  " address_line2_home = '" + contactDetails.getAddress_line2_home() + "' ";
				} else if (token.equalsIgnoreCase("address_line3_home")) {
					updateString +=  " address_line3_home = '" + contactDetails.getAddress_line3_home() + "' ";
				} else if (token.equalsIgnoreCase("city_home")) {
					updateString +=  " city_home = '" + contactDetails.getCity_home() + "' ";
				} else if (token.equalsIgnoreCase("state_home")) {
					updateString +=  " state_home = '" + contactDetails.getState_home() + "' ";
				} else if (token.equalsIgnoreCase("zip_home")) {
					updateString +=  " zip_home = '" + contactDetails.getZip_home() + "' ";
				} else if (token.equalsIgnoreCase("country_home")) {
					updateString +=  " country_home = '" + contactDetails.getCountry_home() + "' ";
				} else if (token.equalsIgnoreCase("address_line1_work")) {
					updateString +=  " address_line1_work = '" + contactDetails.getAddress_line1_work() + "' ";
				} else if (token.equalsIgnoreCase("address_line2_work")) {
					updateString +=  " address_line2_work = '" + contactDetails.getAddress_line2_work() + "' ";
				} else if (token.equalsIgnoreCase("address_line3_work")) {
					updateString +=  " address_line3_work = '" + contactDetails.getAddress_line3_work() + "' ";
				} else if (token.equalsIgnoreCase("city_work")) {
					updateString +=  " city_work = '" + contactDetails.getCity_work() + "' ";
				} else if (token.equalsIgnoreCase("state_work")) {
					updateString +=  " state_work = '" + contactDetails.getState_work() + "' ";
				} else if (token.equalsIgnoreCase("zip_work")) {
					updateString +=  " zip_work = '" + contactDetails.getZip_work() + "' ";
				} else if (token.equalsIgnoreCase("country_work")) {
					updateString +=  " country_work = '" + contactDetails.getCountry_work() + "' ";
				} else if (token.equalsIgnoreCase("contact_type")) {
					updateString +=  " contact_type = '" + contactDetails.getContact_type() + "' ";
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
					updateString +=  " notes = '" + contactDetails.getNotes() + "' ";
				} else if (token.equalsIgnoreCase("num_itineraries")) {
					updateString +=  " num_itineraries = " + contactDetails.getNum_itineraries() + ", "; 
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
