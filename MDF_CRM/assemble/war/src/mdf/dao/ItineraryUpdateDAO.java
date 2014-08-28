package mdf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import mdf.forms.ContactDetailsFormBean;
import mdf.forms.ItineraryDetailsFormBean;
import mdf.forms.ItineraryFormBean;

public class ItineraryUpdateDAO extends BaseUpdateDAO {

	public void addItinerary(ItineraryDetailsFormBean itineraryBean) throws Exception {
		Statement stmt = null;
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * from users");
		
			while (rs.next()) {
				// iterate through the result set and print 
				// the query results to the page 
				System.out.println("user_name = " + rs.getString("user_name") + "<br>");
			}
		} catch (SQLException sqlEx) {
				System.out.println("Caught SQL Exception: " + sqlEx.toString() + "<br>");
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
				System.out.println("Could not close: " + sqlEx.toString() + "<br>");
			}
		}
		closeDB();
	}
	
	// search

	public List lookupContact(ContactDetailsFormBean contactBean) throws Exception {
		List contactsList = new ArrayList();
		Statement stmt = null;
		String stmtString = "";
		String paramString = "";
		boolean queryParam = false;
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "SELECT * FROM CONTACT ";
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
			}

			if (queryParam == true) stmtString += " WHERE " + paramString;
			System.out.println(stmtString);
			ResultSet rs = stmt.executeQuery(stmtString);
		
			while (rs.next()) {
				// iterate through the result set and add to list
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
				contact.setReferer_id(rs.getInt("referer_id"));
				if (rs.getString("notes")==null) contact.setNotes(""); else 
					contact.setNotes(rs.getString("notes"));
				contact.setNum_itineraries(rs.getInt("num_itineraries"));
				//System.out.println(contact.toString());
				contactsList.add(contact);
			}
		} catch (SQLException sqlEx) {
				System.out.println("Caught SQL Exception: " + sqlEx.toString() + "<br>");
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
				System.out.println("Could not close: " + sqlEx.toString() + "<br>");
			}
		}
		closeDB();
		return contactsList;
	}

	// get itinerary info list for contact id given
	public List getItineraryInfoListByContact(int contact_id) throws Exception {
		String query_string = " WHERE contact_id = " + contact_id;
		List itineraryList = getItineraryInfoBySearchString(query_string);
		return itineraryList;
	}

	// get itinerary info list for request id given
	public List getItineraryInfoListByRequest(int request_id) throws Exception {
		String query_string = " WHERE request_id = " + request_id;
		List itineraryList = getItineraryInfoBySearchString(query_string);
		return itineraryList;
	}

	// get itinerary info list for contact id given
	public ItineraryFormBean getItineraryInfoListByID(Integer itinerary_id) throws Exception {
		String query_string = " WHERE itinerary_id = " + itinerary_id;
		List itineraryList = getItineraryInfoBySearchString(query_string);
		if (itineraryList == null && itineraryList.size()>0)
			return null;
		else
			return (ItineraryFormBean)itineraryList.get(0);
	}

	// get itinerary info by search string
	public List getItineraryInfoBySearchString(String searchString) throws Exception {
		List itineraryList = new ArrayList();
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "SELECT * FROM itinerary_details " + searchString ;

			System.out.println(stmtString);
			ResultSet rs = stmt.executeQuery(stmtString);
		
			while (rs.next()) {
				// iterate through the result set and get first record
				ItineraryFormBean itinerary = new ItineraryDetailsFormBean();
				itinerary.setItinerary_id(rs.getInt("itinerary_id"));
				itinerary.setRequest_id(rs.getInt("request_id"));
				itinerary.setContact_id(rs.getInt("contact_id"));
				if (rs.getString("pnr")==null) itinerary.setPnr(""); else 
					itinerary.setPnr(rs.getString("pnr"));
				if (rs.getString("crs")==null) itinerary.setCrs(""); else 
					itinerary.setCrs(rs.getString("crs"));
				if (rs.getString("pcc")==null) itinerary.setPcc(""); else 
					itinerary.setPcc(rs.getString("pcc"));
				if (rs.getString("link")==null) itinerary.setLink(""); else 
					itinerary.setLink(rs.getString("link"));
				if (rs.getString("ticket_number")==null) itinerary.setTicket_number(""); else 
					itinerary.setTicket_number(rs.getString("ticket_number"));
				itinerary.setQuote_sell(rs.getDouble("quote_sell"));
				itinerary.setBase_sell(rs.getDouble("base_sell"));
				itinerary.setTax_sell(rs.getDouble("tax_sell"));
				itinerary.setQuote_buy(rs.getDouble("quote_buy"));
				itinerary.setBase_buy(rs.getDouble("base_buy"));
				itinerary.setTax_buy(rs.getDouble("tax_buy"));
				itinerary.setOther_expenses(rs.getDouble("other_expenses"));
				itinerary.setMargin(rs.getDouble("margin"));
				if (rs.getString("insert_key")==null) itinerary.setInsert_key(""); else 
					itinerary.setInsert_key(rs.getString("insert_key"));
				itinerary.setDeleted(rs.getBoolean("deleted"));
				itinerary.setCreate_dttm(rs.getLong("create_dttm"));
				itinerary.setUpdate_dttm(rs.getLong("update_dttm"));
				itinerary.setDelete_dttm(rs.getLong("delete_dttm"));
				if (rs.getString("created_by")==null) itinerary.setCreated_by(""); else 
					itinerary.setCreated_by(rs.getString("created_by"));
				if (rs.getString("updated_by")==null) itinerary.setUpdated_by(""); else 
					itinerary.setUpdated_by(rs.getString("updated_by"));
				itinerary.setDepart_date(rs.getLong("depart_date"));
				itinerary.setReturn_date(rs.getLong("return_date"));
				if (rs.getString("depart_airport")==null) itinerary.setDepart_airport(""); else 
					itinerary.setDepart_airport(rs.getString("depart_airport"));
				if (rs.getString("arrive_airport")==null) itinerary.setArrive_airport(""); else 
					itinerary.setArrive_airport(rs.getString("arrive_airport"));
				if (rs.getString("primary_airline")==null) itinerary.setPrimary_airline(""); else 
					itinerary.setPrimary_airline(rs.getString("primary_airline"));

				if (rs.getString("raw_text")==null) itinerary.setRaw_text(""); else 
					itinerary.setRaw_text(rs.getString("raw_text"));

				if (rs.getString("pax1_title")==null) itinerary.setPax1_title(""); else 
					itinerary.setPax1_title(rs.getString("pax1_title"));
				if (rs.getString("pax1_last_name")==null) itinerary.setPax1_last_name(""); else 
					itinerary.setPax1_last_name(rs.getString("pax1_last_name"));
				if (rs.getString("pax1_first_name")==null) itinerary.setPax1_first_name(""); else 
					itinerary.setPax1_first_name(rs.getString("pax1_first_name"));
				if (rs.getString("pax1_middle_name")==null) itinerary.setPax1_middle_name(""); else 
					itinerary.setPax1_middle_name(rs.getString("pax1_middle_name"));
				itinerary.setPax1_age(rs.getDouble("pax1_age"));
				if (rs.getString("pax2_title")==null) itinerary.setPax2_title(""); else 
					itinerary.setPax2_title(rs.getString("pax2_title"));
				if (rs.getString("pax2_last_name")==null) itinerary.setPax2_last_name(""); else 
					itinerary.setPax2_last_name(rs.getString("pax2_last_name"));
				if (rs.getString("pax2_first_name")==null) itinerary.setPax2_first_name(""); else 
					itinerary.setPax2_first_name(rs.getString("pax2_first_name"));
				if (rs.getString("pax2_middle_name")==null) itinerary.setPax2_middle_name(""); else 
					itinerary.setPax2_middle_name(rs.getString("pax2_middle_name"));
				itinerary.setPax2_age(rs.getDouble("pax2_age"));
				if (rs.getString("pax3_title")==null) itinerary.setPax3_title(""); else 
					itinerary.setPax3_title(rs.getString("pax3_title"));
				if (rs.getString("pax3_last_name")==null) itinerary.setPax3_last_name(""); else 
					itinerary.setPax3_last_name(rs.getString("pax3_last_name"));
				if (rs.getString("pax3_first_name")==null) itinerary.setPax3_first_name(""); else 
					itinerary.setPax3_first_name(rs.getString("pax3_first_name"));
				if (rs.getString("pax3_middle_name")==null) itinerary.setPax3_middle_name(""); else 
					itinerary.setPax3_middle_name(rs.getString("pax3_middle_name"));
				itinerary.setPax3_age(rs.getDouble("pax3_age"));
				if (rs.getString("pax4_title")==null) itinerary.setPax4_title(""); else 
					itinerary.setPax4_title(rs.getString("pax4_title"));
				if (rs.getString("pax4_last_name")==null) itinerary.setPax4_last_name(""); else 
					itinerary.setPax4_last_name(rs.getString("pax4_last_name"));
				if (rs.getString("pax4_first_name")==null) itinerary.setPax4_first_name(""); else 
					itinerary.setPax4_first_name(rs.getString("pax4_first_name"));
				if (rs.getString("pax4_middle_name")==null) itinerary.setPax4_middle_name(""); else 
					itinerary.setPax4_middle_name(rs.getString("pax4_middle_name"));
				itinerary.setPax4_age(rs.getDouble("pax4_age"));
				if (rs.getString("pax5_title")==null) itinerary.setPax5_title(""); else 
					itinerary.setPax5_title(rs.getString("pax5_title"));
				if (rs.getString("pax5_last_name")==null) itinerary.setPax5_last_name(""); else 
					itinerary.setPax5_last_name(rs.getString("pax5_last_name"));
				if (rs.getString("pax5_first_name")==null) itinerary.setPax5_first_name(""); else 
					itinerary.setPax5_first_name(rs.getString("pax5_first_name"));
				if (rs.getString("pax5_middle_name")==null) itinerary.setPax5_middle_name(""); else 
					itinerary.setPax5_middle_name(rs.getString("pax5_middle_name"));
				itinerary.setPax5_age(rs.getDouble("pax5_age"));
				itineraryList.add(itinerary);
			}
		} catch (SQLException sqlEx) {
			System.out.println("Caught SQL Exception: " + sqlEx.toString() + "<br>");
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
				System.out.println("Could not close: " + sqlEx.toString() + "<br>");
			}
		}
		closeDB();
		return itineraryList;
	}
	
	//	 get Itinerary details
	public ItineraryDetailsFormBean getItineraryDetails(Integer itinerary_id) throws Exception {
		ItineraryDetailsFormBean itineraryDetails = new ItineraryDetailsFormBean();
		itineraryDetails = (ItineraryDetailsFormBean)getItineraryInfoListByID(itinerary_id);
		
		return itineraryDetails;
	}
	
	// save Itinerary details
	public void saveItineraryDetails(ItineraryDetailsFormBean itineraryDetails) throws Exception {
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "UPDATE ITINERARY_DETAILS " +
			" SET contact_name = '" + itineraryDetails.getContact_name() + "', " + 
			" SET first_name = '" + itineraryDetails.getFirst_name() + "', " +  
			" SET middle_name = '" + itineraryDetails.getMiddle_name() + "', " + 
			" SET last_name = '" + itineraryDetails.getLast_name() + "', " +
			" SET num_referrals = " + itineraryDetails.getNum_referrals() + ", " + 
			" SET num_tickets = " + itineraryDetails.getNum_tickets() + ", " +
			" SET num_open_tickets = " + itineraryDetails.getNum_open_tickets() + ", " + 
			" SET num_queries = " + itineraryDetails.getNum_queries() + ", " +
			" SET dues = " + itineraryDetails.getDues() + ", " +
			" SET insert_key = '" + itineraryDetails.getInsert_key() + "', " + 
			" SET phone_work = '" + itineraryDetails.getPhone_work() + "', " +
			" SET phone_cell = '" + itineraryDetails.getPhone_cell() + "', " +
			" SET phone_home = '" + itineraryDetails.getPhone_home() + "', " +
			" SET email_home = '" + itineraryDetails.getEmail_home() + "', " + 
			" SET email_work = '" + itineraryDetails.getEmail_work() + "', " + 
			" SET address_line1_home = '" + itineraryDetails.getAddress_line1_home() + "', " + 
			" SET address_line2_home = '" + itineraryDetails.getAddress_line2_home() + "', " + 
			" SET address_line3_home = '" + itineraryDetails.getAddress_line3_home() + "', " + 
			" SET city_home = '" + itineraryDetails.getCity_home() + "', " + 
			" SET state_home = '" + itineraryDetails.getState_home() + "', " + 
			" SET zip_home = '" + itineraryDetails.getZip_home() + "', " + 
			" SET country_home = '" + itineraryDetails.getCountry_home() + "', " + 
			" SET address_line1_work = '" + itineraryDetails.getAddress_line1_work() + "', " + 
			" SET address_line2_work = '" + itineraryDetails.getAddress_line2_work() + "', " + 
			" SET address_line3_work = '" + itineraryDetails.getAddress_line3_work() + "', " + 
			" SET city_work = '" + itineraryDetails.getCity_work() + "', " + 
			" SET state_work = '" + itineraryDetails.getState_work() + "', " + 
			" SET zip_work = '" + itineraryDetails.getZip_work() + "', " + 
			" SET country_work = '" + itineraryDetails.getCountry_work() + "', " + 
			" SET contact_type = '" + itineraryDetails.getContact_type() + "', " + 
			" SET deleted = '" + itineraryDetails.getDeleted() + "', " + 
			" SET add_dttm = " + itineraryDetails.getAdd_dttm() + ", " + 
			" SET update_dttm = " + itineraryDetails.getUpdate_dttm() + ", " + 
			" SET delete_dttm = " + itineraryDetails.getDelete_dttm() + ", " + 
			" SET status = '" + itineraryDetails.getStatus() + "', " + 
			" SET referer_id = " + itineraryDetails.getReferer_id() + ", " + 
			" SET notes = '" + itineraryDetails.getNotes() + "', " + 
			" SET num_itineraries = " + itineraryDetails.getNum_itineraries() + ", " + 
			"WHERE contact_id =" + itineraryDetails.getContact_id() ;

			System.out.println(stmtString);
			stmt.executeUpdate(stmtString);
		} catch (SQLException sqlEx) {
			System.out.println("Caught SQL Exception: " + sqlEx.toString() + "<br>");
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
				System.out.println("Could not close: " + sqlEx.toString() + "<br>");
			}
		}
		closeDB();
	}

	
	// save Itinerary details
	public void saveItineraryDetails(ItineraryDetailsFormBean itineraryDetails, String changedTokens) throws Exception {
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			StringTokenizer st = new StringTokenizer(changedTokens, ",");
			String updateString = "";
			stmtString = "UPDATE ITINERARY_DETAILS " ;
			System.out.println(changedTokens);
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				System.out.println(token);
				if (!updateString.equals(""))
					updateString += ", ";
				if (token.equalsIgnoreCase("contact_name")) {
					updateString +=  " SET contact_name = '" + itineraryDetails.getContact_name() + "', ";
				} else if (token.equalsIgnoreCase("first_name")) {
					System.out.println("kaushik1212");
					updateString +=  " SET first_name = '" + itineraryDetails.getFirst_name() + "' "; 
				} else if (token.equalsIgnoreCase("middle_name")) {
					updateString +=  " SET middle_name = '" + itineraryDetails.getMiddle_name() + "', ";
				} else if (token.equalsIgnoreCase("last_name")) {
					updateString +=  " SET last_name = '" + itineraryDetails.getLast_name() + "', ";
				} else if (token.equalsIgnoreCase("num_referrals")) {
					updateString +=  " SET num_referrals = " + itineraryDetails.getNum_referrals() + ", "; 
				} else if (token.equalsIgnoreCase("num_tickets")) {
					updateString +=  " SET num_tickets = " + itineraryDetails.getNum_tickets() + ", ";
				} else if (token.equalsIgnoreCase("num_open_tickets")) {
					updateString +=  " SET num_open_tickets = " + itineraryDetails.getNum_open_tickets() + ", "; 
				} else if (token.equalsIgnoreCase("num_queries")) {
					updateString +=  " SET num_queries = " + itineraryDetails.getNum_queries() + ", ";
				} else if (token.equalsIgnoreCase("dues")) {
					updateString +=  " SET dues = " + itineraryDetails.getDues() + ", ";
				} else if (token.equalsIgnoreCase("insert_key")) {
					updateString +=  " SET insert_key = '" + itineraryDetails.getInsert_key() + "', "; 
				} else if (token.equalsIgnoreCase("phone_work")) {
					updateString +=  " SET phone_work = '" + itineraryDetails.getPhone_work() + "', "; 
				} else if (token.equalsIgnoreCase("phone_cell")) {
					updateString +=  " SET phone_cell = '" + itineraryDetails.getPhone_cell() + "', "; 
				} else if (token.equalsIgnoreCase("phone_home")) {
					updateString +=  " SET phone_home = '" + itineraryDetails.getPhone_home() + "', "; 
				} else if (token.equalsIgnoreCase("email_home")) {
					updateString +=  " SET email_home = '" + itineraryDetails.getEmail_home() + "', "; 
				} else if (token.equalsIgnoreCase("email_work")) {
					updateString +=  " SET email_work = '" + itineraryDetails.getEmail_work() + "', "; 
				} else if (token.equalsIgnoreCase("address_line1_home")) {
					updateString +=  " SET address_line1_home = '" + itineraryDetails.getAddress_line1_home() + "', "; 
				} else if (token.equalsIgnoreCase("address_line2_home")) {
					updateString +=  " SET address_line2_home = '" + itineraryDetails.getAddress_line2_home() + "', ";
				} else if (token.equalsIgnoreCase("address_line3_home")) {
					updateString +=  " SET address_line3_home = '" + itineraryDetails.getAddress_line3_home() + "', ";
				} else if (token.equalsIgnoreCase("city_home")) {
					updateString +=  " SET city_home = '" + itineraryDetails.getCity_home() + "', ";
				} else if (token.equalsIgnoreCase("state_home")) {
					updateString +=  " SET state_home = '" + itineraryDetails.getState_home() + "', ";
				} else if (token.equalsIgnoreCase("zip_home")) {
					updateString +=  " SET zip_home = '" + itineraryDetails.getZip_home() + "', ";
				} else if (token.equalsIgnoreCase("country_home")) {
					updateString +=  " SET country_home = '" + itineraryDetails.getCountry_home() + "', ";
				} else if (token.equalsIgnoreCase("address_line1_work")) {
					updateString +=  " SET address_line1_work = '" + itineraryDetails.getAddress_line1_work() + "', ";
				} else if (token.equalsIgnoreCase("address_line2_work")) {
					updateString +=  " SET address_line2_work = '" + itineraryDetails.getAddress_line2_work() + "', ";
				} else if (token.equalsIgnoreCase("address_line3_work")) {
					updateString +=  " SET address_line3_work = '" + itineraryDetails.getAddress_line3_work() + "', ";
				} else if (token.equalsIgnoreCase("city_work")) {
					updateString +=  " SET city_work = '" + itineraryDetails.getCity_work() + "', ";
				} else if (token.equalsIgnoreCase("state_work")) {
					updateString +=  " SET state_work = '" + itineraryDetails.getState_work() + "', ";
				} else if (token.equalsIgnoreCase("zip_work")) {
					updateString +=  " SET zip_work = '" + itineraryDetails.getZip_work() + "', ";
				} else if (token.equalsIgnoreCase("country_work")) {
					updateString +=  " SET country_work = '" + itineraryDetails.getCountry_work() + "', ";
				} else if (token.equalsIgnoreCase("contact_type")) {
					updateString +=  " SET contact_type = '" + itineraryDetails.getContact_type() + "', ";
				} else if (token.equalsIgnoreCase("deleted")) {
					updateString +=  " SET deleted = '" + itineraryDetails.getDeleted() + "', ";
				} else if (token.equalsIgnoreCase("add_dttm")) {
					updateString +=  " SET add_dttm = " + itineraryDetails.getAdd_dttm() + ", "; 
				} else if (token.equalsIgnoreCase("update_dttm")) {
					updateString +=  " SET update_dttm = " + itineraryDetails.getUpdate_dttm() + ", "; 
				} else if (token.equalsIgnoreCase("delete_dttm")) {
					updateString +=  " SET delete_dttm = " + itineraryDetails.getDelete_dttm() + ", "; 
				} else if (token.equalsIgnoreCase("status")) {
					updateString +=  " SET status = '" + itineraryDetails.getStatus() + "', ";
				} else if (token.equalsIgnoreCase("referer_id")) {
					updateString +=  " SET referer_id = " + itineraryDetails.getReferer_id() + ", "; 
				} else if (token.equalsIgnoreCase("notes")) {
					updateString +=  " SET notes = '" + itineraryDetails.getNotes() + "', ";
				} else if (token.equalsIgnoreCase("num_itineraries")) {
					updateString +=  " SET num_itineraries = " + itineraryDetails.getNum_itineraries() + ", "; 
				}  
			}
			if (!updateString.equals("")) {
				stmtString += updateString + 
					" WHERE itinerary_id =" + itineraryDetails.getContact_id();
				System.out.println(stmtString);
				stmt.executeUpdate(stmtString);
			}
		} catch (SQLException sqlEx) {
			System.out.println("Caught SQL Exception: " + sqlEx.toString() + "<br>");
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
				System.out.println("Could not close: " + sqlEx.toString() + "<br>");
			}
		}
		closeDB();
	}

	// get contact details
	public ItineraryDetailsFormBean deleteItineraryDetails(int itinerary_id) throws Exception {
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "DELETE FROM ITINERARY WHERE itinerary_id = " + itinerary_id;
			// TODO: KAUSHIK, WHAT OTHER RELATED ENTRIES TO BE DELETED WHEN AN ITIN IS DELETED ?? 
			System.out.println(stmtString);
			stmt.executeUpdate(stmtString);
		} catch (SQLException sqlEx) {
			System.out.println("Caught SQL Exception: " + sqlEx.toString() + "<br>");
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
				System.out.println("Could not close: " + sqlEx.toString() + "<br>");
			}
		}
		closeDB();
		return null;
	}
	

}
