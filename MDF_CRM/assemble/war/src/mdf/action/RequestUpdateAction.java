package mdf.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mdf.dao.RequestUpdateDAO;
import mdf.forms.RequestDetailsFormBean;
import mdf.utils.DateUtil;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RequestUpdateAction extends Action {
	public ActionForward execute(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response)
      	throws Exception {
	    RequestUpdateDAO requestDAO = new RequestUpdateDAO();
	    
        HttpSession session = request.getSession(false);

	    // lookup
        
		RequestDetailsFormBean requestBean = (RequestDetailsFormBean)form;
		System.out.println(requestBean.getActionn());
		if (requestBean.getActionn().equalsIgnoreCase("lookup")) {
	    	
	    	List requestList = requestDAO.lookupRequest(requestBean);
	    	//for (Iterator i = contactList.iterator(); i.hasNext();) {
	    	for (int i = 0; i< requestList.size(); i++) {
	    		RequestDetailsFormBean lookupRequest = (RequestDetailsFormBean) requestList.get(i);
	    		lookupRequest.setRequest_id(requestBean.getRequest_id());
	    		
		    	System.out.println(lookupRequest);
	    	}
	    	request.setAttribute("contactList", requestList);
	    	
	    	return(mapping.findForward("list_requests"));
	    } else if (requestBean.getActionn().equalsIgnoreCase("add")) {
	    	RequestDetailsFormBean requestDetailsBean = new RequestDetailsFormBean();
	    	form = requestDetailsBean;
	    	request.setAttribute("requestFormBean", requestDetailsBean);
	    	System.out.println("calling add_request");
	    	return(mapping.findForward("edit_request"));
	    } else if (requestBean.getActionn().equalsIgnoreCase("edit")) {
	    	System.out.println(requestBean.getRequest_id());
	    	RequestDetailsFormBean requestDetailsBean = requestDAO.getRequestDetails(requestBean.getRequest_id());
	    	form = requestDetailsBean;
	    	request.setAttribute("requestFormBean", requestDetailsBean);
	    	System.out.println(form);
	    	System.out.println("calling edit_request");
	    	return(mapping.findForward("edit_request"));
	    } else if (requestBean.getActionn().equalsIgnoreCase("save")) {
	    	System.out.println(requestBean.getRequest_id());
	    	if (requestBean.getRequest_id() != 0) {
	    		//requestDAO.saveContactDetails(requestBean, "first_name,last_name");
	    		requestDAO.saveRequestDetails(requestBean);
	    	} else {
	    		Date currentDate = new Date();
	    		String currentDateString = DateUtil.formatDate(currentDate, "MMddyyHHmmss");
	    		String insert_key = "KKV" + currentDateString;
	    		//requestBean.setConta("kaushik123");
	    		requestBean.setInsert_key(insert_key);
	    		requestBean.setAdd_dttm(currentDateString);
	    		requestBean.setUpdate_dttm(currentDateString);
	    		requestBean.setDelete_dttm(null);
	    		
	    		requestDAO.addRequestDetails(requestBean);
	    		requestBean = (RequestDetailsFormBean)requestDAO.getRequestInfoByInsertKey(requestBean.getInsert_key());
	    	}
	    	request.setAttribute("requestFormBean", requestBean);
	    	System.out.println("calling save_request");
	    	return(mapping.findForward("edit_request"));
	    } else if (requestBean.getActionn().equalsIgnoreCase("delete")) {
	    	System.out.println(requestBean.getRequest_id());
	    	requestDAO.deleteRequestDetails(requestBean.getRequest_id());
	    	System.out.println("calling delete_request");
	    	return(mapping.findForward("delete_request"));
	    } else {
	    	return(mapping.findForward("success"));
	    }
	}
}
