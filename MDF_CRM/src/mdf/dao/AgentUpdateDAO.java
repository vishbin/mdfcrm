package mdf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mdf.forms.AgentDetailsFormBean;
import mdf.forms.AgentFormBean;
import mdf.utils.DateUtil;

public class AgentUpdateDAO extends BaseUpdateDAO {
	// add agent details
	public void addAgentDetails(AgentDetailsFormBean agentDetails) throws Exception {
		log.info("inside AgentUpdateDAO.addAgentDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			int deleted_intval = 0;
			int active_intval = 1;
			java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
			if (agentDetails.isDeleted()) deleted_intval = 1;
			stmtString = "INSERT INTO agent ((agent_name, password, role, active, transferred_customers, failed_customers, lost_customers, open_customers, ticketed_customers, pending_itinerary, pending_followup, pending_docs, closed_customers, total_customers, total_updates, insert_key, deleted, add_dttm, update_dttm, delete_dttm, created_by, updated_by) " +  
				"VALUES (" +
				"'" + agentDetails.getAgent_name() + "', " + 
				"'" + agentDetails.getPassword() + "', " +  
				"'" + agentDetails.getRole() + "', " +  
				active_intval + ", " + 
				agentDetails.getTransferred_customers() + ", " + 
				agentDetails.getFailed_customers() + ", " +
				agentDetails.getLost_customers() + ", " +
				agentDetails.getOpen_customers() + ", " +  
				agentDetails.getTicketed_customers() + ", " +
				agentDetails.getClosed_customers() + ", " + 
				agentDetails.getPending_itinerary() + ", " + 
				agentDetails.getPending_followup() + ", " + 
				agentDetails.getPending_docs() + ", " + 
				agentDetails.getTotal_customers() + ", " + 
				agentDetails.getTotal_updates() + ", " + 
				"'" + agentDetails.getInsert_key() + "', " + 
				deleted_intval + ", " +
				"'" + (java.sql.Date)currentDate +  "', " + //contactDetails.getAdd_dttm()
				"'" + (java.sql.Date)(currentDate) +  "', " + //contactDetails.getUpdate_dttm() 
				"'1900-01-01', " + //contactDetails.getDelete_dttm()
				"'" + agentDetails.getCreated_by() + "', " +
				"'" + agentDetails.getUpdated_by() + "') " 
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
				log.error("Could not close: " + ex.toString());
				throw ex;
			}
		}
		closeDB();
	}

		
	// get agent info by ID
	public AgentFormBean getAgentInfoByID(int agent_id) throws Exception {
		String paramString = "WHERE agent_id =" + agent_id;
		List agentsList = getAgentInfo(paramString); 
		if (agentsList != null && agentsList.size()>0) 
			return (AgentFormBean)agentsList.get(0);
		else return null;
	}

	// get active agents List
	public List getActiveAgentsList() throws Exception {
		String paramString = "WHERE active = 1";
		List agentsList = getAgentInfo(paramString); 
		return agentsList;
	}
	
	// get agent info by name
	public AgentFormBean getAgentInfoByName(String agent_name) throws Exception {
		String paramString = "WHERE agent_name ='" + agent_name + "'";
		List agentsList = getAgentInfo(paramString); 
		if (agentsList != null && agentsList.size()>0) 
			return (AgentFormBean)agentsList.get(0);
		else return null;
	}
	
	// get agent info by InsertKey
	public AgentFormBean getAgentInfoByInsertKey(String insert_key) throws Exception {
		String paramString = "WHERE insert_key ='" + insert_key + "'";
		List agentsList = getAgentInfo(paramString); 
		if (agentsList != null && agentsList.size()>0) 
			return (AgentFormBean)agentsList.get(0);
		else return null;
	}
	
	
	// get agent info
	public List getAgentInfo(String paramString) throws Exception {
		log.info("inside agentupdateDAO.getAgentInfo");
		Statement stmt = null;
		String stmtString = "";
		List agentsList = new ArrayList();
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "SELECT * FROM agent " + paramString;

			ResultSet rs = stmt.executeQuery(stmtString);
		
			while (rs.next()) {
				// iterate through the result set and get first record
				AgentDetailsFormBean agent = new AgentDetailsFormBean();
				agent.setAgent_id(rs.getInt("agent_id"));
				if (rs.getString("agent_name")==null) agent.setAgent_name(""); else 
					agent.setAgent_name(rs.getString("agent_name"));
				if (rs.getString("password")==null) agent.setPassword(""); else 
					agent.setPassword(rs.getString("password"));
				if (rs.getString("role")==null) agent.setRole(""); else 
					agent.setRole(rs.getString("role"));

				agent.setActive(rs.getBoolean("active"));
				agent.setTransferred_customers(rs.getInt("transferred_customers"));
				agent.setFailed_customers(rs.getInt("failed_customers"));
				agent.setLost_customers(rs.getInt("lost_customers"));
				agent.setOpen_customers(rs.getInt("open_customers"));
				agent.setTicketed_customers(rs.getInt("ticketed_customers"));
				agent.setClosed_customers(rs.getInt("closed_customers"));
				agent.setPending_itinerary(rs.getInt("pending_itinerary"));
				agent.setPending_followup(rs.getInt("pending_followup"));
				agent.setPending_docs(rs.getInt("pending_docs"));
				agent.setTotal_customers(rs.getInt("total_customers"));
				agent.setTotal_updates(rs.getInt("total_updates"));

				if (rs.getString("insert_key")==null) agent.setInsert_key(""); else 
					agent.setInsert_key(rs.getString("insert_key"));
				agent.setDeleted(rs.getBoolean("deleted"));
				agent.setAdd_dttm(DateUtil.formatDate(rs.getDate("add_dttm"), "MMddyyHHmmss"));
				agent.setUpdate_dttm(DateUtil.formatDate(rs.getDate("update_dttm"), "MMddyyHHmmss"));
				agent.setDelete_dttm(DateUtil.formatDate(rs.getDate("delete_dttm"), "MMddyyHHmmss"));
				if (rs.getString("created_by")==null) agent.setCreated_by(""); else 
					agent.setCreated_by(rs.getString("created_by"));
				if (rs.getString("updated_by")==null) agent.setUpdated_by(""); else 
					agent.setUpdated_by(rs.getString("updated_by"));
				agentsList.add(agent);
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
				log.error("Could not close: " + ex.toString());
				throw ex;
			}
		}
		closeDB();
		log.info("return from agentupdateDAO.getAgentInfo");
		return agentsList;
	}
	
	//	 get Agent details
	public AgentDetailsFormBean getAgentDetails(int agent_id) throws Exception {
		log.info("inside agentupdateDAO.getAgentDetails");
		return null;
	}
	
	// save Agent details
	public void saveAgentDetails(AgentDetailsFormBean agentDetails) throws Exception {
		log.info("inside agentupdateDAO.saveAgentDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			int deleted_intval = 0;
			if (agentDetails.isDeleted()) deleted_intval = 1;
			int active_intval = 0;
			if (agentDetails.isActive()) active_intval = 1;
			stmtString = "UPDATE agent SET " +
			" agent_name = '" + agentDetails.getAgent_name() + "', " + 
			" password = '" + agentDetails.getPassword() + "', " +  
			" role = '" + agentDetails.getRole() + "', " +  
			" active = " + active_intval + ", " + 
			" transferred_customers = " + agentDetails.getTransferred_customers() + ", " + 
			" failed_customers = " + agentDetails.getFailed_customers() + ", " + 
			" lost_customers = " + agentDetails.getLost_customers() + ", " + 
			" open_customers = " + agentDetails.getOpen_customers() + ", " +
			" ticketed_customers = " + agentDetails.getTicketed_customers() + ", " + 
			" closed_customers = " + agentDetails.getClosed_customers() + ", " + 
			" pending_itinerary = " + agentDetails.getPending_itinerary() + ", " +
			" pending_followup = " + agentDetails.getPending_followup() + ", " +
			" pending_docs = " + agentDetails.getPending_docs() + ", " +
			" total_customers = " + agentDetails.getTotal_customers() + ", " +
			" total_updates = " + agentDetails.getTotal_updates() + ", " +
			" insert_key = '" + agentDetails.getInsert_key() + "', " + 
			" deleted = " + deleted_intval + ", " + 
			" add_dttm = '" + DateUtil.parseSQLDate(agentDetails.getAdd_dttm(), "MMddyyHHmmss") + "', " + 
			" update_dttm = '" + DateUtil.parseSQLDate(agentDetails.getUpdate_dttm(), "MMddyyHHmmss") + "', " + 
			" delete_dttm = '" + DateUtil.parseSQLDate(agentDetails.getDelete_dttm(), "MMddyyHHmmss") + "' " + 
			" WHERE agent_id =" + agentDetails.getAgent_id() ;


			stmt.executeUpdate(stmtString);
		} catch (SQLException ex) {
			log.error("Caught SQL Exception: " + ex.toString());
			throw ex;
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				log.error("Could not close: " + ex.toString());
				throw ex;
			}
		}
		closeDB();
	}

	// delete agent details
	public AgentDetailsFormBean deleteAgentDetails(int agent_id) throws Exception {
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "DELETE FROM agent WHERE agent_id = " + agent_id;
	
			stmt.executeUpdate(stmtString);
		} catch (SQLException ex) {
			log.error("Caught SQL Exception: " + ex.toString());
			throw ex;
		}
		// now close the statement and connection if they exist
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException ex) {
				log.error("Could not close: " + ex.toString());
				throw ex;
			}
		}
		closeDB();
		return null;
	}
	

}
