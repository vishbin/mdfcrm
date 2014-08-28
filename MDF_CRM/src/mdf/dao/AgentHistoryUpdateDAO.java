package mdf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mdf.forms.AgentHistoryDetailsFormBean;
import mdf.forms.AgentHistoryFormBean;
import mdf.utils.DateUtil;

public class AgentHistoryUpdateDAO extends BaseUpdateDAO {
	// add contact details
	public void addAgentHistoryDetails(AgentHistoryDetailsFormBean agentHistoryDetails) throws Exception {
		addAgentHistoryDetails((AgentHistoryFormBean)agentHistoryDetails);
	}
	
	public void addAgentHistoryDetails(AgentHistoryFormBean agentHistoryDetails) throws Exception {
		log.info("inside agentHistoryUpdateDAO.addAgentHistoryDetails");
		Statement stmt = null;
		String stmtString = "";
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "INSERT INTO agent_history (contact_id, agent_id, agent_name, old_status, new_status, old_agent, new_agent, add_dttm) " +  
				"VALUES (" +
				agentHistoryDetails.getContact_id() + ", " + 
				agentHistoryDetails.getAgent_id() + ", " +  
				"'" + agentHistoryDetails.getAgent_name() + "', " + 
				"'" + agentHistoryDetails.getOld_status() + "', " +
				"'" + agentHistoryDetails.getNew_status() + "', " +
				"'" + agentHistoryDetails.getOld_agent() + "', " +
				"'" + agentHistoryDetails.getNew_agent() + "', " +
				"'" + DateUtil.parseSQLTimestamp(agentHistoryDetails.getAdd_dttm(), "yyyy-MM-dd HH:mm") + "');"  
				;
log.info(stmtString);
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

	// get agentHistory info by ID
	public AgentHistoryFormBean getAgentHistoryInfoByAgentID(int agent_id) throws Exception {
		log.info("inside agentHistoryUpdateDAO.getAgentHistoryInfoByAgentID");
		String paramString = "WHERE agent_id =" + agent_id;
		List agentHistoryList = getAgentHistoryInfo(paramString, ""); 
		if (agentHistoryList != null && agentHistoryList.size()>0) 
			return (AgentHistoryFormBean)agentHistoryList.get(0);
		else return null;
	}
	
	// get agentHistory info by ID
	public AgentHistoryFormBean getAgentHistoryInfoByAgentName(String agent_name) throws Exception {
		log.info("inside agentHistoryUpdateDAO.getAgentHistoryInfoByAgentName");
		String paramString = "WHERE agent_name =" + agent_name;
		List agentHistoryList = getAgentHistoryInfo(paramString, ""); 
		if (agentHistoryList != null && agentHistoryList.size()>0) 
			return (AgentHistoryFormBean)agentHistoryList.get(0);
		else return null;
	}
	
	// get contact info
	public List getAgentHistoryInfo(String paramString, String orderString) throws Exception {
		log.info("inside agentHistoryUpdateDAO.getAgentHistoryInfo");
		Statement stmt = null;
		String stmtString = "";
		List agentHistoryList = new ArrayList();
		try {
			initDB();	
			// and execute a simple query 
			stmt = conn.createStatement();
			stmtString = "SELECT * FROM agent_history " + paramString + orderString;
			log.info(stmtString);

			ResultSet rs = stmt.executeQuery(stmtString);
		
			while (rs.next()) {
				// iterate through the result set and get first record
				AgentHistoryDetailsFormBean agentHistory = new AgentHistoryDetailsFormBean();
				agentHistory.setItem_id(rs.getInt("item_id"));
				agentHistory.setContact_id(rs.getInt("contact_id"));
				agentHistory.setAgent_id(rs.getInt("agent_id"));
				if (rs.getString("agent_name")==null) agentHistory.setAgent_name(""); else 
					agentHistory.setAgent_name(rs.getString("agent_name"));
				if (rs.getString("old_status")==null) agentHistory.setOld_status(""); else 
					agentHistory.setOld_status(rs.getString("old_status"));
				if (rs.getString("new_status")==null) agentHistory.setNew_status(""); else 
					agentHistory.setNew_status(rs.getString("new_status"));
				if (rs.getString("old_agent")==null) agentHistory.setOld_agent(""); else 
					agentHistory.setOld_agent(rs.getString("old_agent"));
				if (rs.getString("new_agent")==null) agentHistory.setNew_agent(""); else 
					agentHistory.setNew_agent(rs.getString("new_agent"));
				agentHistory.setAdd_dttm(DateUtil.formatDate(rs.getTimestamp("add_dttm"), "yyyy-MM-dd HH:mm"));
				
				agentHistoryList.add(agentHistory);
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
		return agentHistoryList;
	}
	
	//	 get agentHistory details
	public AgentHistoryDetailsFormBean getAgentHistoryDetails(String agent_name) throws Exception {
		log.info("inside agentHistoryUpdateDAO.getAgentHistoryDetails");
		AgentHistoryDetailsFormBean agentHistoryDetails = new AgentHistoryDetailsFormBean();
		agentHistoryDetails = (AgentHistoryDetailsFormBean)getAgentHistoryInfoByAgentName(agent_name);
		
		return agentHistoryDetails;
	}
}
