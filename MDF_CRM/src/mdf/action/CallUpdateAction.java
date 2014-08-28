package mdf.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mdf.dao.CallUpdateDAO;
import mdf.dao.ContactUpdateDAO;
import mdf.dao.RequestUpdateDAO;
import mdf.forms.CallDetailsFormBean;
import mdf.forms.ContactDetailsFormBean;
import mdf.forms.ContactFormBean;
import mdf.forms.RequestDetailsFormBean;
import mdf.forms.RequestFormBean;
import mdf.utils.DateUtil;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CallUpdateAction extends Action {
/*
	protected Map getKeyMethodMap() {
		return new HashMap();
	}
	protected Map getKeyMethodMap(ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request) {
		Map map = new HashMap();
		map.put("add", "add");
		map.put("LOOKUP_PH", "lookupContactAndRequest");
		return map;
	}
	 */
		public ActionForward execute(ActionMapping mapping,
	            ActionForm form,
	            HttpServletRequest request,
	            HttpServletResponse response)
				throws Exception {
		
		HttpSession session = request.getSession(false);
		
		CallDetailsFormBean callBean = (CallDetailsFormBean)form;
		System.out.println("kaushik " + callBean.getActionn());
		if (callBean.getActionn().equalsIgnoreCase("lookupContactAndRequest")) {
			List contactList = lookupContact(callBean);
	    	callBean.setContactLookupList(contactList);
	    	callBean.setContact_id(-1);
	    	callBean.setContactForm(new ContactFormBean());
	    	session.setAttribute("callContactList", contactList);

			List requestList = lookupRequestByContact(callBean);
	    	callBean.setRequestLookupList(requestList);
	    	callBean.setRequest_id(-1);
	    	callBean.setRequestForm(new RequestFormBean());
	    	session.setAttribute("callRequestList", requestList);

	    	request.setAttribute("callFormBean", callBean);
	    	
	    	return(mapping.findForward("edit_call"));
		} else if (callBean.getActionn().equalsIgnoreCase("setContact")) {
			List contactList = (List)session.getAttribute("callContactList");
	    	callBean = setContact(callBean, contactList);
			callBean.setContact_id(callBean.getUi_selectedContact());
			form = callBean;
			System.out.println(callBean.toString());
	    	session.setAttribute("callFormBean", callBean);
	    	session.setAttribute("backupContactForm", callBean.getContactForm());
	    	return(mapping.findForward("edit_call"));
		} else if (callBean.getActionn().equalsIgnoreCase("setRequest")) {
			List requestList = (List)session.getAttribute("callRequestList");
	    	callBean = setRequest(callBean, requestList);
			callBean.setRequest_id(callBean.getUi_selectedRequest());
			form = callBean;
			System.out.println(callBean.toString());
	    	session.setAttribute("callFormBean", callBean);
	    	session.setAttribute("backupRequestForm", callBean.getRequestForm());
	    	return(mapping.findForward("edit_call"));
		} else if (callBean.getActionn().equalsIgnoreCase("edit")) {
			callBean = edit(callBean);
			form = callBean;
	    	session.setAttribute("callFormBean", callBean);
	    	System.out.println(form);
	    	System.out.println("calling edit_call");
	    	return(mapping.findForward("edit_call"));
		} else if (callBean.getActionn().equalsIgnoreCase("save")) {
    		callBean.setContact_dirty(checkDirtyContact(callBean.getContactForm(), (ContactFormBean)session.getAttribute("backupContactForm")));
	    	callBean = save(callBean);
			form = callBean;
	    	session.setAttribute("callFormBean", callBean);

	    	System.out.println(form);
	    	System.out.println("calling edit_call");
	    	return(mapping.findForward("edit_call"));
		} else if (callBean.getActionn().equalsIgnoreCase("add")) {
	    	callBean = add(callBean);
			form = callBean;
	    	session.setAttribute("callFormBean", callBean);
	    	System.out.println(form);
	    	System.out.println("calling edit_call");
	    	return(mapping.findForward("edit_call"));
		} else {
			return (mapping.findForward("success"));
		}
	}
		
	public boolean checkDirtyContact(ContactFormBean contactBean1, ContactFormBean contactBean2) {
		System.out.println("kaushik10");
		System.out.println("kaushik11" + contactBean1.toString());
		System.out.println("kaushik12" + contactBean2.toString());
		if (!contactBean1.getFirst_name().equalsIgnoreCase(contactBean2.getFirst_name()) || 
				!contactBean1.getMiddle_name().equalsIgnoreCase(contactBean2.getMiddle_name()) ||
				!contactBean1.getLast_name().equalsIgnoreCase(contactBean2.getLast_name()) ||
				!contactBean1.getContact_name().equalsIgnoreCase(contactBean2.getContact_name()) ||
				!contactBean1.getPhone_cell().equalsIgnoreCase(contactBean2.getPhone_cell()) ||
				!contactBean1.getPhone_work().equalsIgnoreCase(contactBean2.getPhone_work()) ||
				!contactBean1.getPhone_home().equalsIgnoreCase(contactBean2.getPhone_home()) ||
				!contactBean1.getEmail_work().equalsIgnoreCase(contactBean2.getEmail_work()) ||
				!contactBean1.getAddress_line1_home().equalsIgnoreCase(contactBean2.getAddress_line1_home()) ||
				!contactBean1.getAddress_line2_home().equalsIgnoreCase(contactBean2.getAddress_line2_home()) ||
				!contactBean1.getAddress_line3_home().equalsIgnoreCase(contactBean2.getAddress_line3_home()) ||
				!contactBean1.getCity_home().equalsIgnoreCase(contactBean2.getCity_home()) ||
				!contactBean1.getState_home().equalsIgnoreCase(contactBean2.getState_home()) ||
				!contactBean1.getZip_home().equalsIgnoreCase(contactBean2.getZip_home()) ||
				!contactBean1.getCountry_home().equalsIgnoreCase(contactBean2.getCountry_home())
			) {
			
			return true;
		} else {
			return false;
		}
	}
		
	public CallDetailsFormBean edit(CallDetailsFormBean callBean)
      	throws Exception {
	    ContactUpdateDAO contactDAO = new ContactUpdateDAO();
	    CallUpdateDAO callDAO = new CallUpdateDAO();
	    
		if (callBean.getActionn().equalsIgnoreCase("edit")) {
	    	if (callBean.getCall_id() >0) {
	    		callBean = callDAO.getCallDetails(callBean.getCall_id());
	    	}
	    	return callBean;
	    } else {
	    	return null;
	    }
	}

	public CallDetailsFormBean setContact(CallDetailsFormBean callBean, List contactList)
  	throws Exception {
		if (callBean.getActionn().equalsIgnoreCase("setContact")) {
			ContactFormBean newContact = new ContactFormBean();
			for (int i=0; i< contactList.size(); i++) {
				ContactFormBean contact = (ContactFormBean)contactList.get(i);
				if (contact.getContact_id() == callBean.getUi_selectedContact()) {
					callBean.setContactForm(contact);
					System.out.println(contact.getContact_id() + " : " + callBean.getUi_selectedContact());
					break;
				} else {
					callBean.setContactForm(newContact);
				}
			}
	    	return callBean;
	    } else {
	    	return null;
	    }
	}

	public CallDetailsFormBean setRequest(CallDetailsFormBean callBean, List requestList)
  	throws Exception {
		if (callBean.getActionn().equalsIgnoreCase("setRequest")) {
			RequestFormBean newRequest = new RequestFormBean();
			for (int i=0; i< requestList.size(); i++) {
				RequestFormBean request = (RequestFormBean)requestList.get(i);
				if (request.getRequest_id() == callBean.getUi_selectedRequest()) {
					callBean.setRequestForm(request);
					System.out.println(request.getRequest_id() + " : " + callBean.getUi_selectedRequest());
					break;
				} else {
					callBean.setRequestForm(newRequest);
				}
			}
	    	return callBean;
	    } else {
	    	return null;
	    }
	}

	public List lookupContact(CallDetailsFormBean callBean)
      	throws Exception {
	    ContactUpdateDAO contactDAO = new ContactUpdateDAO();
	    CallUpdateDAO callDAO = new CallUpdateDAO();
	    
	    // lookup
		if (callBean.getActionn().equalsIgnoreCase("lookupContactAndRequest")) {
			String ui_name = callBean.getUi_name();
		    String ui_number = callBean.getUi_number();
		    String ui_email = callBean.getUi_email();

		    if (!ui_name.equals("") ) {
		    	callBean.getContactForm().setContact_name(ui_name);
		    	callBean.getContactForm().setFirst_name(ui_name);
		    	callBean.getContactForm().setLast_name(ui_name);
		    }
	    	if (!ui_number.equals("") ) {
	    		callBean.getContactForm().setPhone_work(ui_number);
	    		callBean.getContactForm().setPhone_home(ui_number);
	    		callBean.getContactForm().setPhone_cell(ui_number);
	    	}
	    	if (!ui_email.equals("") ) {
	    		callBean.getContactForm().setEmail_home(ui_email);
	    		callBean.getContactForm().setEmail_work(ui_email);
	    	}
	    	List contactList = contactDAO.lookupContact(callBean.getContactForm());
	    	for (int i=0; i<contactList.size(); i++) {
	    		ContactDetailsFormBean contact = (ContactDetailsFormBean)contactList.get(i);
	    		contact.setUIAtributes();
	    	}
	    	return contactList;
	    } else {
	    	return null;
	    }
	}


	public List lookupRequestByContact(CallDetailsFormBean callBean)
      	throws Exception {
		RequestUpdateDAO requestDAO = new RequestUpdateDAO();
	    CallUpdateDAO callDAO = new CallUpdateDAO();
	    
	    // lookup
		if (callBean.getActionn().equalsIgnoreCase("lookupRequest")) {
	    	List requestList = requestDAO.getRequestInfoListByContactID(callBean.getContact_id());
	    	for (int i=0; i<requestList.size(); i++) {
	    		RequestDetailsFormBean request = (RequestDetailsFormBean)requestList.get(i);
	    		//request.setUIAtributes();
	    	}
	    	return requestList;
	    } else {
	    	return null;
	    }
	}

	public CallDetailsFormBean add(CallDetailsFormBean callBean)
      	throws Exception {
	    
		if (callBean.getActionn().equalsIgnoreCase("add")) {
	    	CallDetailsFormBean call = new CallDetailsFormBean();
	    	return call;
		} else {
	    	return null;
	    }
	}

	public CallDetailsFormBean save(CallDetailsFormBean callBean)
      	throws Exception {
	    ContactUpdateDAO contactDAO = new ContactUpdateDAO();
	    RequestUpdateDAO requestDAO = new RequestUpdateDAO();
	    CallUpdateDAO callDAO = new CallUpdateDAO();
	    
		System.out.println(callBean.getActionn());
		if (callBean.getActionn().equalsIgnoreCase("save")) {
	    	System.out.println(callBean.getCall_id());
	    	if (callBean.getCall_id() != 0) {
	    		callDAO.saveCallDetails(callBean);
	    	} else {
	    		Date currentDate = new Date();
	    		String currentDateString = DateUtil.formatDate(currentDate, "yyyy-MM-dd HH:mm");
	            String insert_key = "KKV" + DateUtil.formatDate(currentDate, "MMddyyHHmmss");
	    		callBean.setInsert_key(insert_key);
	    		
	    		if (callBean.isContact_dirty()) {
	    			System.out.println("CONTACT IS DIRTY");
	    			System.out.println(callBean.toString());
	    			ContactFormBean contact = callBean.getContactForm(); 
	    			System.out.println(contact.toString());
	    			if (contact.getContact_id() ==0) { // new contact
	    				contact.setInsert_key(insert_key);
	    				contact.setAdd_dttm(currentDateString);
	    				contact.setUpdate_dttm(currentDateString);
	    				contact.setDelete_dttm(null);
	    				contactDAO.addContactDetails(contact);
	    	    		contact = contactDAO.getContactInfoByInsertKey(insert_key);
	    			} else {
	    				contact.setUpdate_dttm(currentDateString);
	    				contactDAO.saveContactDetails((ContactDetailsFormBean)contact);
	    			}
    	    		callBean.setContactForm(contact);
	    		}
	    		if (callBean.isRequest_dirty()) {
	    			System.out.println("REQUEST IS DIRTY");
	    			System.out.println(callBean.toString());
	    			RequestFormBean request = callBean.getRequestForm(); 
	    			System.out.println(request.toString());
	    			if (request.getRequest_id() ==0) { // new request
	    				request.setInsert_key(insert_key);
	    				request.setAdd_dttm(currentDate.toString());
	    				request.setUpdate_dttm(currentDate.toString());
	    				request.setDelete_dttm(null);
	    				requestDAO.addRequestDetails(request);
	    				request = requestDAO.getRequestInfoByInsertKey(insert_key);
	    			} else {
	    				request.setUpdate_dttm(currentDate.toString());
	    				requestDAO.saveRequestDetails((RequestDetailsFormBean)request);
	    			}
    	    		callBean.setRequestForm(request);
	    		}
	    		
	    		callDAO.addCallDetails(callBean);
	    		callBean = (CallDetailsFormBean)callDAO.getCallDetailsByInsertKey(callBean.getInsert_key());
	    	}
	    	return callBean;
	    } else {
	    	return null;
	    }
	}

	public ActionForward delete(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response)
      	throws Exception {
	    ContactUpdateDAO contactDAO = new ContactUpdateDAO();
	    CallUpdateDAO callDAO = new CallUpdateDAO();
	    
        HttpSession session = request.getSession(false);
	    // lookup
		CallDetailsFormBean callBean = (CallDetailsFormBean)form;
		if (callBean.getActionn().equals("")) {
			callBean.setActionn(mapping.getParameter());
		}
		System.out.println(callBean.getActionn());
		System.out.println("kaushik0103");
		if (callBean.getActionn().equalsIgnoreCase("delete")) {
	    	System.out.println(callBean.getCall_id());
	    	callDAO.deleteCallDetails(callBean.getCall_id());
	    	System.out.println("calling delete_call");
	    	return(mapping.findForward("delete_call"));
	    } else {
	    	return(mapping.findForward("success"));
	    }
	}

	public ActionForward lookupCall(ActionMapping mapping,
                               ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response)
      	throws Exception {
	    ContactUpdateDAO contactDAO = new ContactUpdateDAO();
	    CallUpdateDAO callDAO = new CallUpdateDAO();
	    
        HttpSession session = request.getSession(false);
	    // lookup
		CallDetailsFormBean callBean = (CallDetailsFormBean)form;
		if (callBean.getActionn().equals("")) {
			callBean.setActionn(mapping.getParameter());
		}
		System.out.println(callBean.getActionn());
		System.out.println("kaushik0103");
		if (callBean.getActionn().equalsIgnoreCase("lookupCall")) {
			;
			return(mapping.findForward("list_calls"));
	    } else {
	    	return(mapping.findForward("success"));
	    }
	}

	
}
