package mdf.forms;

import java.util.ArrayList;
import java.util.List;

public class CallDetailsFormBean extends CallFormBean {
		
	private ContactFormBean contactForm;
	private List contactLookupList;
	private RequestFormBean requestForm;
	private List requestLookupList;
	public CallDetailsFormBean () {
		contactForm = new ContactFormBean();
		contactLookupList = new ArrayList();
		requestForm = new RequestFormBean();
		requestLookupList = new ArrayList();
	}
	
	public String toString() {
		String str = super.toString();
		str += " CONTACT LIST:";
		for (int i=0; i<contactLookupList.size(); i++) {
			str += contactLookupList.get(i).toString();			
		}
		str += contactForm.toString();
		str += " REQUEST LIST:";
		for (int i=0; i<requestLookupList.size(); i++) {
			str += requestLookupList.get(i).toString();			
		}
		str += requestForm.toString();
		return str;
	}


	public ContactFormBean getContactForm() {
		return contactForm;
	}


	public void setContactForm(ContactFormBean contactForm) {
		this.contactForm = contactForm;
	}


	public List getContactLookupList() {
		return contactLookupList;
	}


	public void setContactLookupList(List contactLookupList) {
		this.contactLookupList = contactLookupList;
	}


	public RequestFormBean getRequestForm() {
		return requestForm;
	}


	public void setRequestForm(RequestFormBean requestForm) {
		this.requestForm = requestForm;
	}


	public List getRequestLookupList() {
		return requestLookupList;
	}


	public void setRequestLookupList(List requestLookupList) {
		this.requestLookupList = requestLookupList;
	}


}
