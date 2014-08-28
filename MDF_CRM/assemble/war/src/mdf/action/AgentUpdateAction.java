package mdf.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mdf.dao.AgentUpdateDAO;
import mdf.forms.AgentDetailsFormBean;
import mdf.utils.DateUtil;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AgentUpdateAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response)
      	throws Exception {
	    AgentUpdateDAO agentDAO = new AgentUpdateDAO();
	    
        HttpSession session = request.getSession(false);

	    // agent summary
        AgentDetailsFormBean agentBean = (AgentDetailsFormBean)form;
		if (agentBean.getActionn().equalsIgnoreCase("agent_summary")) {
	    	List agentList = agentDAO.getActiveAgentsList();
	    	request.setAttribute("agentList", agentList);
	    	
	    	return(mapping.findForward("agent_summary"));
		} else if (agentBean.getActionn().equalsIgnoreCase("add")) {
	    	AgentDetailsFormBean agent = new AgentDetailsFormBean();
	    	form = agent;
	    	request.setAttribute("agentFormBean", agent);
	    	log.info("calling add_agent");
	    	return(mapping.findForward("edit_agent"));
	    } else if (agentBean.getActionn().equalsIgnoreCase("edit")) {
	    	AgentDetailsFormBean agent = agentDAO.getAgentDetails(agentBean.getAgent_id());
	    	
	    	form = agent;
	    	request.setAttribute("agentFormBean", agent);
	    	log.info("calling edit_agent");
	    	return(mapping.findForward("edit_agent"));
	    } else if (agentBean.getActionn().equalsIgnoreCase("save")) {
	    	if (agentBean.getAgent_id() != 0) {
	    		agentDAO.saveAgentDetails(agentBean);
	    	} else {
	    		Date currentDate = new Date();
	    		String insert_key = "KKV" + DateUtil.formatDate(currentDate, "MMddyyHHmmss");
	    		
	    		agentBean.setInsert_key(insert_key);
	    		agentBean.setAdd_dttm(currentDate);
	    		agentBean.setUpdate_dttm(currentDate);
	    		agentBean.setDelete_dttm(null);
	    		
	    		agentDAO.addAgentDetails(agentBean);
	    		agentBean = (AgentDetailsFormBean)agentDAO.getAgentInfoByInsertKey(agentBean.getInsert_key());
	    	}
	    	request.setAttribute("agentFormBean", agentBean);
	    	log.info("calling save_agent");
	    	return(mapping.findForward("edit_agent"));
	    } else if (agentBean.getActionn().equalsIgnoreCase("delete")) {
	    	agentDAO.deleteAgentDetails(agentBean.getAgent_id());
	    	log.info("calling delete_agent");
	    	return(mapping.findForward("delete_agent"));
	    } else {
	    	return(mapping.findForward("success"));
	    }
	}

}
