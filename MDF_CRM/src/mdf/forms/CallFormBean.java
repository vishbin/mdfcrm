package mdf.forms;

import org.apache.struts.action.ActionForm;

public class CallFormBean extends ActionForm {
	
	private String ui_name = "";
	private String ui_number = "";
	private String ui_email = "";
	private int ui_selectedContact = -1;
	private int ui_selectedRequest = -1;
	
	private String actionn = "add";
	private int call_id = 0;
	private String channel = "";
	private String email = "";
	private String number = "";
	private int request_id = 0;
	//
	private String date_time = "";
	private String insert_key = "";
	private int contact_id = 0;
	private boolean deleted = false;
	private String call_type = "";
	private String user = "";
	private String notes = "";
	
	private boolean contact_dirty = false;
	private boolean request_dirty = false;

	public String toString() {
		String str = 
			"ui_name:" + ui_name + 
			"ui_number:" +  ui_number + 
			"ui_email:" +  ui_email +
			"ui_selectedContact:" + ui_selectedContact +
			"actionn:" +  actionn + 
			"call_id:" + call_id + 
			"channel:" +  channel + 
			"email:" +  email + 
			"number:" +  number + 
			"request_id:" +  request_id + 
			"date_time:" +  date_time + 
			"insert_key:" + insert_key + 
			"contact_id:" +  contact_id + 
			"deleted:" +  deleted + 
			"call_type:" + call_type + 
			"user:" +  user + 
			"notes:" + notes;
		return str;
	}


	public int getCall_id() {
		return call_id;
	}


	public void setCall_id(int call_id) {
		this.call_id = call_id;
	}


	public String getCall_type() {
		return call_type;
	}


	public void setCall_type(String call_type) {
		this.call_type = call_type;
	}


	public String getChannel() {
		return channel;
	}


	public void setChannel(String channel) {
		this.channel = channel;
	}


	public int getContact_id() {
		return contact_id;
	}


	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}


	public String getDate_time() {
		return date_time;
	}


	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getInsert_key() {
		return insert_key;
	}


	public void setInsert_key(String insert_key) {
		this.insert_key = insert_key;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public int getRequest_id() {
		return request_id;
	}


	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}


	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getActionn() {
		return actionn;
	}


	public void setActionn(String actionn) {
		this.actionn = actionn;
	}


	public boolean isContact_dirty() {
		return contact_dirty;
	}


	public void setContact_dirty(boolean contact_dirty) {
		this.contact_dirty = contact_dirty;
	}


	public boolean isRequest_dirty() {
		return request_dirty;
	}


	public void setRequest_dirty(boolean request_dirty) {
		this.request_dirty = request_dirty;
	}


	public String getUi_name() {
		return ui_name;
	}


	public void setUi_name(String ui_name) {
		this.ui_name = ui_name;
	}


	public String getUi_email() {
		return ui_email;
	}


	public void setUi_email(String ui_email) {
		this.ui_email = ui_email;
	}


	public String getUi_number() {
		return ui_number;
	}


	public void setUi_number(String ui_number) {
		this.ui_number = ui_number;
	}


	public int getUi_selectedContact() {
		return ui_selectedContact;
	}


	public void setUi_selectedContact(int ui_selectedContact) {
		this.ui_selectedContact = ui_selectedContact;
	}


	public int getUi_selectedRequest() {
		return ui_selectedRequest;
	}


	public void setUi_selectedRequest(int ui_selectedRequest) {
		this.ui_selectedRequest = ui_selectedRequest;
	}
}
