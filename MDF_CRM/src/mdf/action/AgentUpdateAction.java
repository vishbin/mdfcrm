package mdf.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mdf.dao.AgentUpdateDAO;
import mdf.dao.ContactUpdateDAO;
import mdf.forms.AgentDetailsFormBean;
import mdf.forms.ContactDetailsFormBean;
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

        //set agent 
        if (agentBean == null) {
            agentBean = new AgentDetailsFormBean();
            agentBean.setAgent_name(request.getParameter("user_name"));
        }
        String agentName = agentBean.getAgent_name();
        if (agentName == null || agentName.equals("")) { 
            agentBean = (AgentDetailsFormBean)session.getAttribute("user");
            if (agentBean == null) {
                agentBean = new AgentDetailsFormBean();
            }
            if (agentBean.getAgent_name() == null || agentBean.getAgent_name().equals("")) { 
                agentName = "NONE";
                agentBean.setAgent_name(agentName);
            } else agentName = agentBean.getAgent_name();
        }
        AgentDetailsFormBean agentInfo = (AgentDetailsFormBean) agentDAO.getAgentInfoByName(agentName);
        //set agents default actionn
        if (agentBean.getActionn() == null) {
            agentBean.setActionn("agent_summary");
        }
        // set agent ends
        if (agentBean.getActionn().equalsIgnoreCase("agent_summary")) {
            form = agentBean;
            request.setAttribute("agentFormBean", agentBean);
            List agentList = agentDAO.getActiveAgentsList();
            request.setAttribute("agentList", agentList);
            
            return(mapping.findForward("agent_summary"));
        } else if (agentBean.getActionn().equalsIgnoreCase("agent_dashboard")) {
            ContactUpdateDAO contactDAO = new ContactUpdateDAO();

            // lets lookup agents assigned contacts
            ContactDetailsFormBean contactBean = new ContactDetailsFormBean();
            contactBean.setAgent_assigned(agentBean.getAgent_name());
            List contactList = contactDAO.lookupContact(contactBean);
            for (int i = 0; i< contactList.size(); i++) {
                ContactDetailsFormBean contact = (ContactDetailsFormBean) contactList.get(i);
            	//set the contact age
        		contact.setStale(calculateStaleAge(contact.getAdd_dttm()));
    	        //log.info(contact);
            }
            request.setAttribute("contactList", contactList);

            request.setAttribute("agentFormBean", agentInfo);
            log.info("calling agent_dashboard");
            return(mapping.findForward("agent_dashboard"));
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
            Date currentDate = new Date();
            String currentDateString = DateUtil.formatDate(currentDate, "yyyy-MM-dd HH:mm");
            agentBean.setUpdate_dttm(currentDateString);
            agentBean.setUpdated_by(agentName);
            if (agentBean.getAgent_id() != 0) {
                agentDAO.saveAgentDetails(agentBean);
            } else {
                String insert_key = agentName + DateUtil.formatDate(currentDate, "MMddyyHHmmss");
                
                agentBean.setInsert_key(insert_key);
                agentBean.setAdd_dttm(currentDateString);
                agentBean.setDelete_dttm(null);
                agentBean.setCreated_by(agentName);
                
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
	private int calculateStaleAge(String add_dttm) {
		int staleAge =0;
		log.info("inside calculateStaleAge");
		log.info("kaushik12:::" + add_dttm);
		
		Date addDate = DateUtil.parseDate(add_dttm, "yyyy-MM-dd HH:mm");
		staleAge = DateUtil.diffDays(addDate, new Date());
		return staleAge;
	}

}
