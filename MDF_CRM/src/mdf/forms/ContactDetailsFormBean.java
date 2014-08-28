package mdf.forms;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

public class ContactDetailsFormBean extends ContactFormBean {
	
	private List tasksList;
	private List callsList;
	private List requestsList;
	private List itinerariesList;
	private List documentsList;

	public ContactDetailsFormBean() {
		tasksList = new ArrayList();
		callsList = new ArrayList();
		requestsList = new ArrayList();
		itinerariesList = new ArrayList();
		documentsList = new ArrayList();
	}
	
	public String toString() {
		String str="";
		str = super.toString();
		if (getNum_itineraries() >0 && itinerariesList != null)
			for (int i=0; i<itinerariesList.size(); i++) {
				str += "\n";
				str += itinerariesList.get(i).toString();
				
			}
		return str;
	}

	public List getCallsList() {
		return callsList;
	}

	public void setCallsList(List callsList) {
		this.callsList = callsList;
	}

	public List getDocumentsList() {
		return documentsList;
	}

	public void setDocumentsList(List documentsList) {
		this.documentsList = documentsList;
	}

	public List getItinerariesList() {
		return itinerariesList;
	}

	public void setItinerariesList(List itinerariesList) {
		this.itinerariesList = itinerariesList;
	}

	public List getRequestsList() {
		return requestsList;
	}

	public void setRequestsList(List requestsList) {
		this.requestsList = requestsList;
	}

	public List getTasksList() {
		return tasksList;
	}

	public void setTasksList(List tasksList) {
		this.tasksList = tasksList;
	}

}
