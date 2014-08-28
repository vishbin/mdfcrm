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

public class LoginAction extends BaseAction {
	public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response)
      	throws Exception {
		log.info("inside execute method for LoginAction");
		
		AgentUpdateDAO agentDAO = new AgentUpdateDAO();
		ContactUpdateDAO contactDAO = new ContactUpdateDAO();

        HttpSession session = request.getSession(false);
        
        AgentDetailsFormBean agentBean = (AgentDetailsFormBean)form;

        String agentName = agentBean.getAgent_name();
     	if (agentName == null || agentName.equals("")) { 
         	agentBean = (AgentDetailsFormBean)session.getAttribute("user");
     		if (agentBean == null || agentBean.getAgent_name() == null || agentBean.getAgent_name().equals("")) { 
     	     	agentName = "NONE";
	            return mapping.findForward("login");
     		} else agentName = agentBean.getAgent_name();
     	}
        AgentDetailsFormBean agent = (AgentDetailsFormBean) agentDAO.getAgentInfoByName(agentName);
        if (agent != null) {
        	session.setAttribute("user", agent);
        }
        // lets also lookup agents assigned contacts
		ContactDetailsFormBean contactBean = new ContactDetailsFormBean();
		contactBean.setAgent_assigned(agent.getAgent_name());
     	List contactList = contactDAO.lookupContact(contactBean);
    	//for (Iterator i = contactList.iterator(); i.hasNext();) {
    	for (int i = 0; i< contactList.size(); i++) {
    		ContactDetailsFormBean contact = (ContactDetailsFormBean) contactList.get(i);
    		//set the contact age
    		contact.setStale(calculateStaleAge(contact.getAdd_dttm()));
	    	//log.info(contact);
    	}
    	request.setAttribute("contactList", contactList);
        
        log.info(agent);
    	return(mapping.findForward("agent_dashboard"));
	}

	private int calculateStaleAge(String add_dttm) {
		int staleAge =0;
		log.info("inside calculateStaleAge");
		log.info("kaushik11:::" + add_dttm);
		
		Date addDate = DateUtil.parseDate(add_dttm, "yyyy-MM-dd HH:mm");
		staleAge = DateUtil.diffDays(addDate, new Date());
		return staleAge;
	}
}
