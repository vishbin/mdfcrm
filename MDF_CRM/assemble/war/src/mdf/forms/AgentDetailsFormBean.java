package mdf.forms;

import java.util.ArrayList;
import java.util.List;

public class AgentDetailsFormBean extends AgentFormBean {
		
	private ContactFormBean contactForm;
	private List contactLookupList;
	private RequestFormBean requestForm;
	private List requestLookupList;
	public AgentDetailsFormBean () {
		contactForm = new ContactFormBean();
		contactLookupList = new ArrayList();
		requestForm = new RequestFormBean();
		requestLookupList = new ArrayList();
	}
	
	public String toString() {
		String str = super.toString();
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
