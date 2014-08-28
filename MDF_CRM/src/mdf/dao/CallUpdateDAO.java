package mdf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mdf.dao.BaseUpdateDAO;
import mdf.forms.CallDetailsFormBean;
import mdf.forms.ContactDetailsFormBean;
import mdf.forms.ContactFormBean;
import mdf.utils.DateUtil;

public class CallUpdateDAO extends BaseUpdateDAO {
	// add call details
	public void addCallDetails(CallDetailsFormBean callDetails) throws Exception {
		System.out.println("inside callupdateDAO.addCallDetails");
		;
	}
	
	// add contact details
	public void addContactDetails(ContactDetailsFormBean contactDetails) throws Exception {
		System.out.println("inside callupdateDAO.addContactDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			int deleted_intval = 0;
			java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
			if (contactDetails.getDeleted()) deleted_intval = 1;
			stmtString = "INSERT INTO contact (contact_name, first_name, middle_name, last_name, num_referrals, num_tickets, num_open_tickets, num_queries, dues, insert_key, phone_work, phone_cell, phone_home, email_home, email_work, address_line1_home, address_line2_home, address_line3_home, city_home, state_home, zip_home, country_home, address_line1_work, address_line2_work, address_line3_work, city_work, state_work, zip_work, country_work, contact_type, deleted, add_dttm, update_dttm, delete_dttm, status, referer_id, notes, num_itineraries, created_by, updated_by) " +  
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
				contactDetails.getReferer_id() +  ", " +
				"'" + contactDetails.getNotes() +  "', " +
				contactDetails.getNum_itineraries() + ", " +
				"'" + contactDetails.getCreated_by() + "', " +
				"'" + contactDetails.getUpdated_by() + "') " 
				;
			System.out.println(stmtString);
			stmt.executeUpdate(stmtString);
		} catch (SQLException sqlEx) {
			System.out.println("Caught SQL Exception: " + sqlEx.toString());
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
				System.out.println("Could not close: " + sqlEx.toString());
			}
		}
		closeDB();
	}

		
	// get contact info by ID
	public ContactFormBean getContactInfoByID(Integer contact_id) throws Exception {
		String paramString = "WHERE contact_id =" + contact_id;
		List contactsList = getContactInfo(paramString); 
		if (contactsList != null && contactsList.size()>0) 
			return (ContactFormBean)contactsList.get(0);
		else return null;
	}
	
	// get call details by InsertKey
	public CallDetailsFormBean getCallDetailsByInsertKey(String insert_key) throws Exception {
		System.out.println("inside callupdateDAO.getCallDetailsByInsertKey");
		return null;
	}
	
	// get contact info
	public List getContactInfo(String paramString) throws Exception {
		Statement stmt = null;
		String stmtString = "";
		List contactsList = new ArrayList();
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "SELECT * FROM CONTACT " + paramString;

			System.out.println(stmtString);
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
				contact.setAdd_dttm(DateUtil.formatDate(rs.getTimestamp("add_dttm"), "yyyy-MM-dd HH:mm"));
				contact.setUpdate_dttm(DateUtil.formatDate(rs.getTimestamp("update_dttm"), "yyyy-MM-dd HH:mm"));
				contact.setDelete_dttm(DateUtil.formatDate(rs.getTimestamp("delete_dttm"), "yyyy-MM-dd HH:mm"));
				if (rs.getString("status")==null) contact.setStatus(""); else 
					contact.setStatus(rs.getString("status"));
				if (rs.getString("created_by")==null) contact.setCreated_by(""); else 
					contact.setCreated_by(rs.getString("created_by"));
				if (rs.getString("updated_by")==null) contact.setUpdated_by(""); else 
					contact.setUpdated_by(rs.getString("updated_by"));
				contact.setReferer_id(rs.getInt("referer_id"));
				if (rs.getString("notes")==null) contact.setNotes(""); else 
					contact.setNotes(rs.getString("notes"));
				contact.setNum_itineraries(rs.getInt("num_itineraries"));
				contactsList.add(contact);
			}
		} catch (SQLException sqlEx) {
			System.out.println("Caught SQL Exception: " + sqlEx.toString());
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
				System.out.println("Could not close: " + sqlEx.toString());
			}
		}
		closeDB();
		return contactsList;
	}
	
	//	 get contact details
	public CallDetailsFormBean getCallDetails(int call_id) throws Exception {
		System.out.println("inside callupdateDAO.getCallDetails");
		return null;
	}
	
	// save call details
	public void saveCallDetails(CallDetailsFormBean callDetails) throws Exception {
		System.out.println("inside callupdateDAO.saveCallDetails");
		;
	}
	
	// delete call details
	public ContactDetailsFormBean deleteCallDetails(int call_id) throws Exception {
		System.out.println("inside callupdateDAO.deleteCallDetails");
		return null;
	}
	

}
