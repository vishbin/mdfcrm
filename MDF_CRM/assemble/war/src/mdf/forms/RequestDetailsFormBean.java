package mdf.forms;

import java.util.ArrayList;
import java.util.List;

public class RequestDetailsFormBean extends RequestFormBean {

	private List tasksList;
	private List callsList;
	private List contactsList;
	private List itinerariesList;
	private List documentsList;

	public RequestDetailsFormBean() {
		tasksList = new ArrayList();
		callsList = new ArrayList();
		contactsList = new ArrayList();
		itinerariesList = new ArrayList();
		documentsList = new ArrayList();
	}
	
	public String toString() {
		String str="";
		str = super.toString();
		if (getNum_itinerary() >0 && itinerariesList != null)
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

	public List getContaList() {
		return contactsList;
	}

	public void setRequestsList(List requestsList) {
		this.contactsList = requestsList;
	}

	public List getTasksList() {
		return tasksList;
	}

	public void setTasksList(List tasksList) {
		this.tasksList = tasksList;
	}

}
