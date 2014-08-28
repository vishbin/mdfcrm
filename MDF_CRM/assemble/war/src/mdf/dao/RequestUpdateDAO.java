package mdf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mdf.forms.RequestDetailsFormBean;
import mdf.forms.RequestFormBean;

public class RequestUpdateDAO extends BaseUpdateDAO {
	
	// add contact details
	public void addRequestDetails(RequestDetailsFormBean requestDetails) throws Exception {
		addRequestDetails((RequestFormBean)requestDetails);
	}
	
	public void addRequestDetails(RequestFormBean requestDetails) throws Exception {
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			int deleted_intval = 0;
			java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
			if (requestDetails.isDeleted()) deleted_intval = 1;
			stmtString = "INSERT INTO mydreamflight.itinerary_request" +
			"(customer_id, pax1_first_name, pax1_middle_name, pax1_last_name, pax1_title, pax1_age, pax2_first_name, pax2_middle_name, pax2_last_name, pax2_title, pax2_age, pax3_first_name, pax3_middle_name, pax3_last_name, pax3_title, pax3_age, pax4_first_name, pax4_middle_name, pax4_last_name, pax4_title, pax4_age, pax5_first_name, pax5_middle_name, pax5_last_name, pax5_title, pax5_age, num_calls, insert_key, deleted, add_dttm, update_dttm, delete_dttm, created_by, updated_by, num_itinerary, depart_date, return_date, primary_airline, num_tickets, depart_airport, arrive_airport, notes) " +
			"VALUES (" +
			requestDetails.getCustomer_id() + ", " +
			"'" + requestDetails.getPax1_first_name() + "', " +
			"'" + requestDetails.getPax1_middle_name() + "', " +
			"'" + requestDetails.getPax1_last_name() + "', " +
			"'" + requestDetails.getPax1_title() + "', " +
			requestDetails.getPax1_age() + ", " +
			"'" + requestDetails.getPax2_first_name() + "', " +
			"'" + requestDetails.getPax2_middle_name() + "', " +
			"'" + requestDetails.getPax2_last_name() + "', " +
			"'" + requestDetails.getPax2_title() + "', " +
			requestDetails.getPax2_age() + ", " +
			"'" + requestDetails.getPax3_first_name() + "', " +
			"'" + requestDetails.getPax3_middle_name() + "', " +
			"'" + requestDetails.getPax3_last_name() + "', " +
			"'" + requestDetails.getPax3_title() + "', " +
			requestDetails.getPax3_age() + ", " +
			"'" + requestDetails.getPax4_first_name() + "', " +
			"'" + requestDetails.getPax4_middle_name() + "', " +
			"'" + requestDetails.getPax4_last_name() + "', " +
			"'" + requestDetails.getPax4_title() + "', " +
			requestDetails.getPax4_age() + ", " +
			"'" + requestDetails.getPax5_first_name() + "', " +
			"'" + requestDetails.getPax5_middle_name() + "', " +
			"'" + requestDetails.getPax5_last_name() + "', " +
			"'" + requestDetails.getPax5_title() + "', " +
			requestDetails.getPax5_age() + ", " +
			requestDetails.getNum_calls() + ", " +
			"'" + requestDetails.getInsert_key() + "', " +
			deleted_intval + ", " +
			"'" + (java.sql.Date)currentDate + "', " + // requestDetails.getAdd_dttm()
			"'" + (java.sql.Date)currentDate + "', " + // requestDetails.getUpdated_dttm()
			null + ", " + // requestDetails.getDelete_dttm()
			"'" + requestDetails.getCreated_by() + "', " +
			"'" + requestDetails.getUpdated_by() + "', " +
			requestDetails.getNum_itinerary() + ", " + 
			"'" + requestDetails.getDepart_date() + "', " +
			"'" + requestDetails.getReturn_date() + "', " +
			"'" + requestDetails.getPrimary_airline() + "', " +
			requestDetails.getNum_tickets() + ", " +
			"'" + requestDetails.getDepart_airport() + "', " +
			"'" + requestDetails.getArrive_airport() + "', " +
			"'" + requestDetails.getNotes() + "')";
 
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

		
	
	// search

	public List lookupRequest(RequestDetailsFormBean requestBean) throws Exception {
		RequestFormBean contact = (RequestFormBean)requestBean;
		return(lookupRequest(contact));
	}
	public List lookupRequest(RequestFormBean requestBean) throws Exception {
		List contactsList = new ArrayList();
		String paramString = "";
		boolean queryParam = false;
		try {
/* this is a TODO activity 			
			// and execute a simple query 
			if (!requestBean.getRequest_name().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " contact_name LIKE '" + requestBean.getRequest_name() + "%'";
				queryParam = true;
			}
			if (!requestBean.getFirst_name().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " first_name LIKE '" + requestBean.getFirst_name() + "%'";
				queryParam = true;
			}
			if (!requestBean.getMiddle_name().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " middle_name LIKE '" + requestBean.getMiddle_name() + "%'";
				queryParam = true;
			}
			if (!requestBean.getLast_name().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " last_name LIKE '" + requestBean.getLast_name() + "%'";
				queryParam = true;
			}
			if (!requestBean.getPhone_work().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " phone_work LIKE '" + requestBean.getPhone_work() + "%'";
				queryParam = true;
			}
			if (!requestBean.getPhone_cell().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " phone_cell LIKE '" + requestBean.getPhone_cell() + "%'";
				queryParam = true;
			}
			if (!requestBean.getPhone_home().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " phone_home LIKE '" + requestBean.getPhone_home() + "%'";
				queryParam = true;
			}
			if (!requestBean.getEmail_work().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " email_work LIKE '" + requestBean.getEmail_work() + "%'";
				queryParam = true;
			}
			if (!requestBean.getEmail_home().equals("")) {
				if (queryParam == true) paramString += " OR "; 
				paramString += " email_home LIKE '" + requestBean.getEmail_home() + "%'";
				queryParam = true;
			}

			if (queryParam == true) paramString = " WHERE " + paramString;
			contactsList = getRequestInfo(paramString); 

			for (int i=0; i<contactsList.size(); i++) {
				RequestDetailsFormBean contact = (RequestDetailsFormBean)contactsList.get(i);
				contact.setUi_name(requestBean.getUi_name());
				contact.setUi_number(requestBean.getUi_number());
				contact.setUi_email(requestBean.getUi_email());
			}
			*/
		} catch (Exception ex) {
				System.out.println("Caught Exception: " + ex.toString());
		}
		return contactsList;
	}
	
	// get request info by ID
	public RequestFormBean getRequestInfoByID(int request_id) throws Exception {
		String paramString = "WHERE request_id =" + request_id;
		List requestsList = getRequestInfo(paramString); 
		if (requestsList != null && requestsList.size()>0) 
			return (RequestFormBean)requestsList.get(0);
		else return null;
	}
	
	// get request info by InsertKey
	public RequestFormBean getRequestInfoByInsertKey(String insert_key) throws Exception {
		String paramString = "WHERE insert_key ='" + insert_key + "'";
		List requestsList = getRequestInfo(paramString); 
		if (requestsList != null && requestsList.size()>0) 
			return (RequestFormBean)requestsList.get(0);
		else return null;
	}
	
	// get request info by Contact ID
	public List getRequestInfoListByContactID(int contact_id) throws Exception {
		String paramString = "WHERE contact_id ='" + contact_id + "'";
		List requestsList = getRequestInfo(paramString); 
		return requestsList;
	}
	
	// get request info
	public List getRequestInfo(String paramString) throws Exception {
		Statement stmt = null;
		String stmtString = "";
		List requestsList = new ArrayList();
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "SELECT * FROM ITINERARY_REQUEST " + paramString;

			System.out.println(stmtString);
			ResultSet rs = stmt.executeQuery(stmtString);
		
			while (rs.next()) {
				// iterate through the result set and get first record
				RequestDetailsFormBean request = new RequestDetailsFormBean();
				request.setRequest_id(rs.getInt("request_id"));
				request.setCustomer_id(rs.getInt("customer_id"));
				if (rs.getString("pax1_first_name")==null) request.setPax1_first_name(""); else
					request.setPax1_first_name(rs.getString("pax1_first_name"));
				if (rs.getString("pax1_middle_name")==null) request.setPax1_middle_name(""); else
					request.setPax1_middle_name(rs.getString("pax1_middle_name"));
				if (rs.getString("pax1_last_name")==null) request.setPax1_last_name(""); else
					request.setPax1_last_name(rs.getString("pax1_last_name"));
				if (rs.getString("pax1_title")==null) request.setPax1_title(""); else
					request.setPax1_title(rs.getString("pax1_title"));
				request.setPax1_age(rs.getInt("pax1_age"));
				if (rs.getString("pax2_first_name")==null) request.setPax2_first_name(""); else
					request.setPax2_first_name(rs.getString("pax2_first_name"));
				if (rs.getString("pax2_middle_name")==null) request.setPax2_middle_name(""); else
					request.setPax2_middle_name(rs.getString("pax2_middle_name"));
				if (rs.getString("pax2_last_name")==null) request.setPax2_last_name(""); else
					request.setPax2_last_name(rs.getString("pax2_last_name"));
				if (rs.getString("pax2_title")==null) request.setPax2_title(""); else
					request.setPax2_title(rs.getString("pax2_title"));
				request.setPax2_age(rs.getInt("pax2_age"));
				if (rs.getString("pax3_first_name")==null) request.setPax3_first_name(""); else
					request.setPax3_first_name(rs.getString("pax3_first_name"));
				if (rs.getString("pax3_middle_name")==null) request.setPax3_middle_name(""); else
					request.setPax3_middle_name(rs.getString("pax3_middle_name"));
				if (rs.getString("pax3_last_name")==null) request.setPax3_last_name(""); else
					request.setPax3_last_name(rs.getString("pax3_last_name"));
				if (rs.getString("pax3_title")==null) request.setPax3_title(""); else
					request.setPax3_title(rs.getString("pax3_title"));
				request.setPax3_age(rs.getInt("pax3_age"));
				if (rs.getString("pax4_first_name")==null) request.setPax4_first_name(""); else
					request.setPax4_first_name(rs.getString("pax4_first_name"));
				if (rs.getString("pax4_middle_name")==null) request.setPax4_middle_name(""); else
					request.setPax4_middle_name(rs.getString("pax4_middle_name"));
				if (rs.getString("pax4_last_name")==null) request.setPax4_last_name(""); else
					request.setPax4_last_name(rs.getString("pax4_last_name"));
				if (rs.getString("pax4_title")==null) request.setPax4_title(""); else
					request.setPax4_title(rs.getString("pax4_title"));
				request.setPax4_age(rs.getInt("pax4_age"));
				if (rs.getString("pax5_first_name")==null) request.setPax5_first_name(""); else
					request.setPax5_first_name(rs.getString("pax5_first_name"));
				if (rs.getString("pax5_middle_name")==null) request.setPax5_middle_name(""); else
					request.setPax5_middle_name(rs.getString("pax5_middle_name"));
				if (rs.getString("pax5_last_name")==null) request.setPax5_last_name(""); else
					request.setPax5_last_name(rs.getString("pax5_last_name"));
				if (rs.getString("pax5_title")==null) request.setPax5_title(""); else
					request.setPax5_title(rs.getString("pax5_title"));
				request.setPax5_age(rs.getInt("pax5_age"));
				request.setNum_calls(rs.getInt("num_calls"));
				if (rs.getString("insert_key")==null) request.setInsert_key(""); else
					request.setInsert_key(rs.getString("insert_key"));
				request.setDeleted(rs.getBoolean("deleted"));
				if (rs.getString("add_dttm")==null) request.setAdd_dttm(""); else
					request.setAdd_dttm(rs.getString("add_dttm"));
				if (rs.getString("update_dttm")==null) request.setUpdate_dttm(""); else
					request.setUpdate_dttm(rs.getString("update_dttm"));
				if (rs.getString("delete_dttm")==null) request.setDelete_dttm(""); else
					request.setDelete_dttm(rs.getString("delete_dttm"));
				if (rs.getString("created_by")==null) request.setCreated_by(""); else
					request.setCreated_by(rs.getString("created_by"));
				if (rs.getString("updated_by")==null) request.setUpdated_by(""); else
					request.setUpdated_by(rs.getString("updated_by"));
				request.setNum_itinerary(rs.getInt("num_itinerary"));
				if (rs.getString("depart_date")==null) request.setDepart_date(""); else
					request.setDepart_date(rs.getString("depart_date"));
				if (rs.getString("return_date")==null) request.setReturn_date(""); else
					request.setReturn_date(rs.getString("return_date"));
				if (rs.getString("primary_airline")==null) request.setPrimary_airline(""); else
					request.setPrimary_airline(rs.getString("primary_airline"));
				request.setNum_tickets(rs.getInt("num_tickets"));
				if (rs.getString("depart_airport")==null) request.setDepart_airport(""); else
					request.setDepart_airport(rs.getString("depart_airport"));
				if (rs.getString("arrive_airport")==null) request.setArrive_airport(""); else
					request.setArrive_airport(rs.getString("arrive_airport"));
				if (rs.getString("notes")==null) request.setNotes(""); else
					request.setNotes(rs.getString("notes"));

				requestsList.add(request);
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
		return requestsList;
	}
	
	//	 get request details
	public RequestDetailsFormBean getRequestDetails(int request_id) throws Exception {
		RequestDetailsFormBean requestDetails = new RequestDetailsFormBean();
		requestDetails = (RequestDetailsFormBean)getRequestInfoByID(request_id);
		
		if (requestDetails.getNum_itinerary() >0) {
			ItineraryUpdateDAO itinDAO = new ItineraryUpdateDAO();
			requestDetails.setItinerariesList(itinDAO.getItineraryInfoListByRequest(request_id));
		}
		return requestDetails;
	}
	
	// save contact details
	public void saveRequestDetails(RequestDetailsFormBean requestDetails) throws Exception {
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			int deleted_intval = 0;
			if (requestDetails.isDeleted()) deleted_intval = 1;
			stmtString = "UPDATE ITINERARY_REQUEST SET " +
			" customer_id = " + requestDetails.getCustomer_id() + ", " +
			" pax1_first_name = '" + requestDetails.getPax1_first_name() + "', " +
			" pax1_middle_name = '" + requestDetails.getPax1_middle_name() + "', " +
			" pax1_last_name = '" + requestDetails.getPax1_last_name() + "', " +
			" pax1_title = '" + requestDetails.getPax1_title() + "', " +
			" pax1_age = " + requestDetails.getPax1_age() + ", " +
			" pax2_first_name = '" + requestDetails.getPax2_first_name() + "', " +
			" pax2_middle_name = '" + requestDetails.getPax2_middle_name() + "', " +
			" pax2_last_name = '" + requestDetails.getPax2_last_name() + "', " +
			" pax2_title = '" + requestDetails.getPax2_title() + "', " +
			" pax2_age = " + requestDetails.getPax2_age() + ", " +
			" pax3_first_name = '" + requestDetails.getPax3_first_name() + "', " +
			" pax3_middle_name = '" + requestDetails.getPax3_middle_name() + "', " +
			" pax3_last_name = '" + requestDetails.getPax3_last_name() + "', " +
			" pax3_title = '" + requestDetails.getPax3_title() + "', " +
			" pax3_age = " + requestDetails.getPax3_age() + ", " +
			" pax4_first_name = '" + requestDetails.getPax4_first_name() + "', " +
			" pax4_middle_name = '" + requestDetails.getPax4_middle_name() + "', " +
			" pax4_last_name = '" + requestDetails.getPax4_last_name() + "', " +
			" pax4_title = '" + requestDetails.getPax4_title() + "', " +
			" pax4_age = " + requestDetails.getPax4_age() + ", " +
			" pax5_first_name = '" + requestDetails.getPax5_first_name() + "', " +
			" pax5_middle_name = '" + requestDetails.getPax5_middle_name() + "', " +
			" pax5_last_name = '" + requestDetails.getPax5_last_name() + "', " +
			" pax5_title = '" + requestDetails.getPax5_title() + "', " +
			" pax5_age = " + requestDetails.getPax5_age() + ", " +
			" num_calls = " + requestDetails.getNum_calls() + ", " +
			" insert_key = '" + requestDetails.getInsert_key() + "', " +
			" deleted = " + deleted_intval + ", " +
			" add_dttm = '" + requestDetails.getAdd_dttm() + "', " +
			" update_dttm = '" + requestDetails.getUpdate_dttm() + "', " +
			" delete_dttm = '" + requestDetails.getDelete_dttm() + "', " +
			" created_by = '" + requestDetails.getCreated_by() + "', " +
			" updated_by = '" + requestDetails.getUpdated_by() + "', " +
			" num_itinerary = " + requestDetails.getNum_itinerary() + ", " +
			" depart_date = '" + requestDetails.getDepart_date() + "', " +
			" return_date = '" + requestDetails.getReturn_date() + "', " +
			" primary_airline = '" + requestDetails.getPrimary_airline() + "', " +
			" num_tickets = " + requestDetails.getNum_tickets() + ", " +
			" depart_airport = '" + requestDetails.getDepart_airport() + "', " +
			" arrive_airport = '" + requestDetails.getArrive_airport() + "', " +
			" notes = '" + requestDetails.getNotes() + "', " +
			" WHERE request_id =" + requestDetails.getRequest_id() ;

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

	
	// save request details
	public void saveRequestDetails(RequestDetailsFormBean requestDetails, String changedTokens) throws Exception {
		Statement stmt = null;
		String stmtString = "";
		/* TODO kaushik implement this 
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			StringTokenizer st = new StringTokenizer(changedTokens, ",");
			String updateString = "";
			stmtString = "UPDATE CONTACT SET " ;
			System.out.println(changedTokens);
			int deleted_intval = 0;
			if (requestDetails.getDeleted()) deleted_intval = 1;
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				System.out.println("kaushik1212");
				System.out.println(token);
				if (!updateString.equals(""))
					updateString += ", ";
				if (token.equalsIgnoreCase("contact_name")) {
					updateString +=  " contact_name = '" + requestDetails.getRequest_name() + "' ";
				} else if (token.equalsIgnoreCase("first_name")) {
					updateString +=  " first_name = '" + requestDetails.getFirst_name() + "' "; 
				} else if (token.equalsIgnoreCase("middle_name")) {
					updateString +=  " middle_name = '" + requestDetails.getMiddle_name() + "' ";
				} else if (token.equalsIgnoreCase("last_name")) {
					updateString +=  " last_name = '" + requestDetails.getLast_name() + "' ";
				} else if (token.equalsIgnoreCase("num_referrals")) {
					updateString +=  " num_referrals = " + requestDetails.getNum_referrals() + ", "; 
				} else if (token.equalsIgnoreCase("num_tickets")) {
					updateString +=  " num_tickets = " + requestDetails.getNum_tickets() + ", ";
				} else if (token.equalsIgnoreCase("num_open_tickets")) {
					updateString +=  " num_open_tickets = " + requestDetails.getNum_open_tickets() + ", "; 
				} else if (token.equalsIgnoreCase("num_queries")) {
					updateString +=  " num_queries = " + requestDetails.getNum_queries() + ", ";
				} else if (token.equalsIgnoreCase("dues")) {
					updateString +=  " dues = " + requestDetails.getDues() + ", ";
				} else if (token.equalsIgnoreCase("insert_key")) {
					updateString +=  " insert_key = '" + requestDetails.getInsert_key() + "' "; 
				} else if (token.equalsIgnoreCase("phone_work")) {
					updateString +=  " phone_work = '" + requestDetails.getPhone_work() + "' "; 
				} else if (token.equalsIgnoreCase("phone_cell")) {
					updateString +=  " phone_cell = '" + requestDetails.getPhone_cell() + "' "; 
				} else if (token.equalsIgnoreCase("phone_home")) {
					updateString +=  " phone_home = '" + requestDetails.getPhone_home() + "' "; 
				} else if (token.equalsIgnoreCase("email_home")) {
					updateString +=  " email_home = '" + requestDetails.getEmail_home() + "' "; 
				} else if (token.equalsIgnoreCase("email_work")) {
					updateString +=  " email_work = '" + requestDetails.getEmail_work() + "' "; 
				} else if (token.equalsIgnoreCase("address_line1_home")) {
					updateString +=  " address_line1_home = '" + requestDetails.getAddress_line1_home() + "' "; 
				} else if (token.equalsIgnoreCase("address_line2_home")) {
					updateString +=  " address_line2_home = '" + requestDetails.getAddress_line2_home() + "' ";
				} else if (token.equalsIgnoreCase("address_line3_home")) {
					updateString +=  " address_line3_home = '" + requestDetails.getAddress_line3_home() + "' ";
				} else if (token.equalsIgnoreCase("city_home")) {
					updateString +=  " city_home = '" + requestDetails.getCity_home() + "' ";
				} else if (token.equalsIgnoreCase("state_home")) {
					updateString +=  " state_home = '" + requestDetails.getState_home() + "' ";
				} else if (token.equalsIgnoreCase("zip_home")) {
					updateString +=  " zip_home = '" + requestDetails.getZip_home() + "' ";
				} else if (token.equalsIgnoreCase("country_home")) {
					updateString +=  " country_home = '" + requestDetails.getCountry_home() + "' ";
				} else if (token.equalsIgnoreCase("address_line1_work")) {
					updateString +=  " address_line1_work = '" + requestDetails.getAddress_line1_work() + "' ";
				} else if (token.equalsIgnoreCase("address_line2_work")) {
					updateString +=  " address_line2_work = '" + requestDetails.getAddress_line2_work() + "' ";
				} else if (token.equalsIgnoreCase("address_line3_work")) {
					updateString +=  " address_line3_work = '" + requestDetails.getAddress_line3_work() + "' ";
				} else if (token.equalsIgnoreCase("city_work")) {
					updateString +=  " city_work = '" + requestDetails.getCity_work() + "' ";
				} else if (token.equalsIgnoreCase("state_work")) {
					updateString +=  " state_work = '" + requestDetails.getState_work() + "' ";
				} else if (token.equalsIgnoreCase("zip_work")) {
					updateString +=  " zip_work = '" + requestDetails.getZip_work() + "' ";
				} else if (token.equalsIgnoreCase("country_work")) {
					updateString +=  " country_work = '" + requestDetails.getCountry_work() + "' ";
				} else if (token.equalsIgnoreCase("contact_type")) {
					updateString +=  " contact_type = '" + requestDetails.getRequest_type() + "' ";
				} else if (token.equalsIgnoreCase("deleted")) {
					updateString +=  " deleted = " + deleted_intval + " ";
				} else if (token.equalsIgnoreCase("add_dttm")) {
					updateString +=  " add_dttm = " + requestDetails.getAdd_dttm() + ", "; 
				} else if (token.equalsIgnoreCase("update_dttm")) {
					updateString +=  " update_dttm = " + requestDetails.getUpdate_dttm() + ", "; 
				} else if (token.equalsIgnoreCase("delete_dttm")) {
					updateString +=  " delete_dttm = " + requestDetails.getDelete_dttm() + ", "; 
				} else if (token.equalsIgnoreCase("status")) {
					updateString +=  " status = '" + requestDetails.getStatus() + "' ";
				} else if (token.equalsIgnoreCase("referer_id")) {
					updateString +=  " referer_id = " + requestDetails.getReferer_id() + ", "; 
				} else if (token.equalsIgnoreCase("notes")) {
					updateString +=  " notes = '" + requestDetails.getNotes() + "' ";
				} else if (token.equalsIgnoreCase("num_itineraries")) {
					updateString +=  " num_itineraries = " + requestDetails.getNum_itineraries() + ", "; 
				}  
			}
			if (!updateString.equals("")) {
				//updateString +=  " contact_id = " + requestDetails.getRequest_id() + " ";
				stmtString += updateString + 
					" WHERE contact_id =" + requestDetails.getRequest_id();
				System.out.println(stmtString);
				stmt.executeUpdate(stmtString);
			}
		} catch (SQLException sqlEx) {
			System.out.println("Caught SQL Exception: " + sqlEx.toString());
		}
		*/
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

	// get contact details
	public RequestDetailsFormBean deleteRequestDetails(int request_id) throws Exception {
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "DELETE FROM ITINERARY_REQUEST WHERE request_id = " + request_id;
	
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
		return null;
	}
	

}
