package mdf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import mdf.forms.AirlineInfoDetailsFormBean;
import mdf.forms.AirlineInfoFormBean;

public class AirlineInfoUpdateDAO extends BaseUpdateDAO {
	// add airline info
	public void addAirlineInfoDetails(AirlineInfoDetailsFormBean airlineInfoDetails) throws Exception {
		addAirlineInfoDetails((AirlineInfoFormBean)airlineInfoDetails);
	}
	
	public void addAirlineInfoDetails(AirlineInfoFormBean airlineInfoDetails) throws Exception {
		log.info("inside airlineinfoupdatedao.addAirlineInfoDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "INSERT INTO airlineinfo (airline_name, airline_code, airline_phone) " +  
				"VALUES (" +
				"'" + airlineInfoDetails.getAirlineName() + "', " + 
				"'" + airlineInfoDetails.getAirlineCode() + "', " +  
				"'" + airlineInfoDetails.getAirlinePhone() + "', " 
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
	public List lookupAirlineInfo(AirlineInfoDetailsFormBean airlineInfoBean) throws Exception {
		log.info("inside airlineinfoupdatedao.lookupAirlineInfoDetails");
		AirlineInfoFormBean airlineinfo = (AirlineInfoFormBean)airlineInfoBean;
		return(lookupAirlineInfo(airlineinfo));
	}
	public List lookupAirlineInfo(AirlineInfoFormBean airlineInfoBean) throws Exception {
		log.info("inside airlineinfoupdatedao.lookupAirlineInfo");
		List airlineInfoList = new ArrayList();
		String paramString = "";
		String orderString = "";
		boolean queryParam = false;
		try {
			// and execute a simple query 
			if (!airlineInfoBean.getAirlineName().equals("")) {
				if (queryParam == true) {
					paramString += " OR ";
					orderString += ",";
				}
				paramString += " airline_name LIKE '" + airlineInfoBean.getAirlineName() + "%'";
				orderString += " airline_name";
				queryParam = true;
			}
			if (!airlineInfoBean.getAirlineCode().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " airline_code LIKE '" + airlineInfoBean.getAirlineCode() + "%'";
				orderString += " airline_code";
				queryParam = true;
			}
			if (!airlineInfoBean.getAirlinePhone().equals("")) {
				if (queryParam == true) {
					paramString += " OR "; 
					orderString += ",";
				}
				paramString += " airline_phone LIKE '" + airlineInfoBean.getAirlinePhone() + "%'";
				orderString += " airline_phone";
				queryParam = true;
			}

			if (queryParam == true) {
				paramString = " WHERE " + paramString;
				orderString = " ORDER BY " + orderString + " airline_id DESC";
			}
			airlineInfoList = getContactInfo(paramString, orderString); 

			for (int i=0; i<airlineInfoList.size(); i++) {
				AirlineInfoDetailsFormBean airlineinfo = (AirlineInfoDetailsFormBean)airlineInfoList.get(i);
				airlineinfo.setUi_name(airlineInfoBean.getUi_name());
				airlineinfo.setUi_code(airlineInfoBean.getUi_code());
				airlineinfo.setUi_phone(airlineInfoBean.getUi_phone());
			}
		} catch (Exception ex) {
			log.error("Caught Exception: " + ex);
			throw ex;
		}
		return airlineInfoList;
	}
	
	// get airlineinfo info by ID
	public AirlineInfoFormBean getContactInfoByID(int airline_id) throws Exception {
		log.info("inside airlineinfoupdatedao.getContactInfoByID");
		String paramString = "WHERE airline_id =" + airline_id;
		List airlineInfoList = getContactInfo(paramString, ""); 
		if (airlineInfoList != null && airlineInfoList.size()>0) 
			return (AirlineInfoFormBean)airlineInfoList.get(0);
		else return null;
	}
	
	// get airlineinfo info by InsertKey
	public AirlineInfoFormBean getContactInfoByInsertKey(String insert_key) throws Exception {
		log.info("inside airlineinfoupdatedao.getContactInfoByInsertKey");
		String paramString = "WHERE insert_key ='" + insert_key + "'";
		List airlineInfoList = getContactInfo(paramString, ""); 
		if (airlineInfoList != null && airlineInfoList.size()>0) 
			return (AirlineInfoFormBean)airlineInfoList.get(0);
		else return null;
	}
	
	// get airlineinfo info
	public List getContactInfo(String paramString, String orderString) throws Exception {
		log.info("inside airlineinfoupdatedao.getContactInfo");
		Statement stmt = null;
		String stmtString = "";
		List airlineInfoList = new ArrayList();
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "SELECT * FROM airlineinfo " + paramString + orderString;
			log.info(stmtString);

			ResultSet rs = stmt.executeQuery(stmtString);
		
			while (rs.next()) {
				// iterate through the result set and get first record
				AirlineInfoDetailsFormBean airlineinfo = new AirlineInfoDetailsFormBean();
				airlineinfo.setAirline_id(rs.getInt("airline_id"));
				if (rs.getString("airline_name")==null) airlineinfo.setAirlineName(""); else 
					airlineinfo.setAirlineName(rs.getString("airline_name"));
				if (rs.getString("airline_code")==null) airlineinfo.setAirlineCode(""); else 
					airlineinfo.setAirlineCode(rs.getString("airline_code"));
				if (rs.getString("airline_phone")==null) airlineinfo.setAirlinePhone(""); else 
					airlineinfo.setAirlinePhone(rs.getString("airline_phone"));
				
				airlineInfoList.add(airlineinfo);
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
		return airlineInfoList;
	}
	
	//	 get airline info
	public AirlineInfoDetailsFormBean getAirlineInfoDetails(int airline_id) throws Exception {
		log.info("inside airlineinfoupdatedao.getAirlineInfoDetails");
		AirlineInfoDetailsFormBean airlineInfoDetails = new AirlineInfoDetailsFormBean();
		airlineInfoDetails = (AirlineInfoDetailsFormBean)getContactInfoByID(airline_id);
		
		return airlineInfoDetails;
	}
	
	// save airline info
	public void saveAirlineInfoDetails(AirlineInfoDetailsFormBean airlineInfoDetails) throws Exception {
		log.info("inside airlineinfoupdatedao.saveAirlineInfoDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "UPDATE airlineinfo SET " +
			" airline_name = '" + airlineInfoDetails.getAirlineName() + "', " + 
			" airline_code = '" + airlineInfoDetails.getAirlineCode() + "', " +  
			" airline_phone = '" + airlineInfoDetails.getAirlinePhone() + "' " + 
			" WHERE airline_id =" + airlineInfoDetails.getAirline_id() ;

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

	
	// get airline info
	public void saveAirlineInfoDetails(AirlineInfoDetailsFormBean airlineInfoDetails, String changedTokens) throws Exception {
		log.info("inside airlineinfoupdatedao.saveAirlineInfoDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			StringTokenizer st = new StringTokenizer(changedTokens, ",");
			String updateString = "";
			stmtString = "UPDATE airlineinfo SET " ;
			log.info(changedTokens);
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				log.info(token);
				if (!updateString.equals(""))
					updateString += ", ";
				if (token.equalsIgnoreCase("airline_name")) {
					updateString +=  " airline_nam = '" + airlineInfoDetails.getAirlineName() + "' ";
				} else if (token.equalsIgnoreCase("airline_code")) {
					updateString +=  " airline_code = '" + airlineInfoDetails.getAirlineCode() + "' "; 
				} else if (token.equalsIgnoreCase("airline_phone")) {
					updateString +=  " airline_phone = '" + airlineInfoDetails.getAirlinePhone() + "' ";
				}
			}
			if (!updateString.equals("")) {
				//updateString +=  " airline_id = " + airlineInfoDetails.getAirline_id() + " ";
				stmtString += updateString + 
					" WHERE airline_id =" + airlineInfoDetails.getAirline_id();
	
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

	// delete airline info
	public AirlineInfoDetailsFormBean deleteAirlineInfoDetails(int airline_id) throws Exception {
		log.info("inside airlineinfoupdatedao.deleteAirlineInfoDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "DELETE FROM airlineinfo WHERE airline_id = " + airline_id;
	
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
