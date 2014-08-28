package mdf.forms;

import org.apache.struts.action.ActionForm;

public class ContactFormBean extends ActionForm {
	//ui fields
	private String actionn;
	
	private String ui_name = "";
	private String ui_number = "";
	private String ui_email = "";
	private int stale = 0;
	
	private int contact_id = 0;
	private String contact_name = "";
	private String contact_email = "";
	private String contact_phone = "";

	private String first_name = "";
	private String middle_name = "";
	private String last_name = "";
	private String agent_assigned = "";
	private String previous_agent_assigned = "";
	private String status_history = "";
	private int num_referrals = 0;
	private int num_tickets = 0;
	private int num_open_tickets = 0;
	private int num_queries = 0;
	private double dues = 0;
	private String insert_key = "";
	private String phone_work = "";
	private String phone_cell = "";
	private String phone_home = "";
	private String email_home = "";
	private String email_work = "";
	
	private String billingAddress_line1 = "";
	private String billingAddress_line2 = "";
	private String billingAddress_line3 = "";
	private String billingAddress_city = "";
	private String billingAddress_state = "";
	private String billingAddress_zip = "";
	private String billingAddress_country = "";
	private String mailingAddress_line1 = "";
	private String mailingAddress_line2 = "";
	private String mailingAddress_line3 = "";
	private String mailingAddress_city = "";
	private String mailingAddress_state = "";
	private String mailingAddress_zip = "";
	private String mailingAddress_country = "";
	private String contact_type = "";
	private String contact_source = "";
	private String tracking_number = "";
	
	private String ticketed_by = "";
	private String itinerary_by = "";
	
	private boolean deleted = false;
	private String add_dttm = null; 
	private String update_dttm = null; 
	private String delete_dttm = null; 
	private String status = ""; 
	private String previous_status = ""; 
	private int referer_id = 0; 
	private String notes = ""; 
	private int num_itineraries = 0; 
	private String created_by = ""; 
	private String updated_by = ""; 
		
	public String getBillingAddress_line1() {
		return billingAddress_line1;
	}
	public void setBillingAddress_line1(String billingAddress_line1) {
		this.billingAddress_line1 = billingAddress_line1.toUpperCase().trim();
	}
	public String getMailingAddress_line1() {
		return mailingAddress_line1;
	}
	public void setMailingAddress_line1(String mailingAddress_line1) {
		this.mailingAddress_line1 = mailingAddress_line1.toUpperCase().trim();
	}
	public String getBillingAddress_line2() {
		return billingAddress_line2;
	}
	public void setBillingAddress_line2(String billingAddress_line2) {
		this.billingAddress_line2 = billingAddress_line2.toUpperCase().trim();
	}
	public String getMailingAddress_line2() {
		return mailingAddress_line2;
	}
	public void setMailingAddress_line2(String mailingAddress_line2) {
		this.mailingAddress_line2 = mailingAddress_line2.toUpperCase().trim();
	}
	public String getBillingAddress_line3() {
		return billingAddress_line3;
	}
	public void setBillingAddress_line3(String billingAddress_line3) {
		this.billingAddress_line3 = billingAddress_line3.toUpperCase().trim();
	}
	public String getMailingAddress_line3() {
		return mailingAddress_line3;
	}
	public void setMailingAddress_line3(String mailingAddress_line3) {
		this.mailingAddress_line3 = mailingAddress_line3.toUpperCase().trim();
	}
	public String getBillingAddress_city() {
		return billingAddress_city;
	}
	public void setBillingAddress_city(String billingAddress_city) {
		this.billingAddress_city = billingAddress_city.toUpperCase().trim();
	}
	public String getMailingAddress_city() {
		return mailingAddress_city;
	}
	public void setMailingAddress_city(String mailingAddress_city) {
		this.mailingAddress_city = mailingAddress_city.toUpperCase().trim();
	}
	public int getContact_id() {
		return contact_id;
	}
	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name.toUpperCase().trim();
	}
	public String getContact_type() {
		return contact_type;
	}
	public void setContact_type(String contact_type) {
		this.contact_type = contact_type.toUpperCase().trim();
	}
	public String getBillingAddress_country() {
		return billingAddress_country;
	}
	public void setBillingAddress_country(String billingAddress_country) {
		this.billingAddress_country = billingAddress_country.toUpperCase().trim();
	}
	public String getMailingAddress_country() {
		return mailingAddress_country;
	}
	public void setMailingAddress_country(String mailingAddress_country) {
		this.mailingAddress_country = mailingAddress_country.toUpperCase().trim();
	}
	public boolean getDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public double getDues() {
		return dues;
	}
	public void setDues(double dues) {
		this.dues = dues;
	}
	public String getEmail_home() {
		return email_home;
	}
	public void setEmail_home(String email_home) {
		this.email_home = email_home.toUpperCase().trim();
	}
	public String getEmail_work() {
		return email_work;
	}
	public void setEmail_work(String email_work) {
		this.email_work = email_work.toUpperCase().trim();
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name.toUpperCase().trim();
	}
	public String getInsert_key() {
		return insert_key;
	}
	public void setInsert_key(String insert_key) {
		this.insert_key = insert_key.toUpperCase().trim();
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name.toUpperCase().trim();
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name.toUpperCase().trim();
	}
	public int getNum_open_tickets() {
		return num_open_tickets;
	}
	public void setNum_open_tickets(int num_open_tickets) {
		this.num_open_tickets = num_open_tickets;
	}
	public int getNum_queries() {
		return num_queries;
	}
	public void setNum_queries(int num_queries) {
		this.num_queries = num_queries;
	}
	public int getNum_referrals() {
		return num_referrals;
	}
	public void setNum_referrals(int num_referrals) {
		this.num_referrals = num_referrals;
	}
	public int getNum_tickets() {
		return num_tickets;
	}
	public void setNum_tickets(int num_tickets) {
		this.num_tickets = num_tickets;
	}
	public String getPhone_cell() {
		return phone_cell;
	}
	public void setPhone_cell(String phone_cell) {
		this.phone_cell = phone_cell.toUpperCase().trim();
	}
	public String getPhone_home() {
		return phone_home;
	}
	public void setPhone_home(String phone_home) {
		this.phone_home = phone_home.toUpperCase().trim();
	}
	public String getPhone_work() {
		return phone_work;
	}
	public void setPhone_work(String phone_work) {
		this.phone_work = phone_work.toUpperCase().trim();
	}
	public String getBillingAddress_state() {
		return billingAddress_state;
	}
	public void setBillingAddress_state(String billingAddress_state) {
		this.billingAddress_state = billingAddress_state.toUpperCase().trim();
	}
	public String getMailingAddress_state() {
		return mailingAddress_state;
	}
	public void setMailingAddress_state(String mailingAddress_state) {
		this.mailingAddress_state = mailingAddress_state.toUpperCase().trim();
	}
	public String getBillingAddress_zip() {
		return billingAddress_zip;
	}
	public void setBillingAddress_zip(String billingAddress_zip) {
		this.billingAddress_zip = billingAddress_zip.toUpperCase().trim();
	}
	public String getMailingAddress_zip() {
		return mailingAddress_zip;
	}
	public void setMailingAddress_zip(String mailingAddress_zip) {
		this.mailingAddress_zip = mailingAddress_zip.toUpperCase().trim();
	}
	public String getUi_email() {
		return ui_email;
	}
	public void setUi_email(String ui_email) {
		this.ui_email = ui_email.toUpperCase().trim();
	}
	public String getUi_name() {
		return ui_name;
	}
	public void setUi_name(String ui_name) {
		this.ui_name = ui_name.toUpperCase().trim();
	}
	public String getUi_number() {
		return ui_number;
	}
	public void setUi_number(String ui_number) {
		this.ui_number = ui_number.toUpperCase().trim();
	}
	
	public String getAdd_dttm() {
		return add_dttm;
	}
	public void setAdd_dttm(String add_dttm) {
		this.add_dttm = add_dttm;
	}
	public String getDelete_dttm() {
		return delete_dttm;
	}
	public void setDelete_dttm(String delete_dttm) {
		this.delete_dttm = delete_dttm;
	}
	public String getUpdate_dttm() {
		return update_dttm;
	}
	public void setUpdate_dttm(String update_dttm) {
		this.update_dttm = update_dttm;
	}

	public String toString() {
		String str = 
			"ui_name:" + ui_name + 
			"ui_number:" +  ui_number + 
			"ui_email:" +  ui_email + 
			"contact_id:" +  contact_id + 
			"contact_name:" +  contact_name + 
			"contact_phone:" +  contact_phone + 
			"contact_email:" +  contact_email + 
			"first_name:" +  first_name + 
			"middle_name:" + middle_name + 
			"last_name:" +  last_name + 
			"agent_assigned:" +  agent_assigned + 
			"previous_agent_assigned:" +  previous_agent_assigned + 
			"num_referrals:" +  num_referrals + 
			"num_tickets:" + num_tickets + 
			"num_open_tickets:" +  num_open_tickets + 
			"num_queries:" + num_queries + 
			"dues:" +  dues + 
			"insert_key:" +  insert_key + 
			"phone_work:" +  phone_work + 
			"phone_cell:" +  phone_cell + 
			"phone:" +  phone_home + 
			"email:" +  email_home + 
			"email_work:" +  email_work + 
			"billingAddress_line1:" +  billingAddress_line1 + 
			"billingAddress_line2:" +  billingAddress_line2 + 
			"billingAddress_line3:" +  billingAddress_line3 + 
			"billingAddress_city:" +  billingAddress_city + 
			"billingAddress_state:" +  billingAddress_state + 
			"billingAddress_zip:" +  billingAddress_zip + 
			"billingAddress_country:" +  billingAddress_country + 
			"mailingAddress_line1:" +  mailingAddress_line1 + 
			"mailingAddress_line2:" +  mailingAddress_line2 + 
			"mailingAddress_line3:" +  mailingAddress_line3 + 
			"mailingAddress_city:" +  mailingAddress_city + 
			"mailingAddress_state:" +  mailingAddress_state + 
			"mailingAddress_zip:" +  mailingAddress_zip + 
			"mailingAddress_country:" +  mailingAddress_country + 
			"contact_type:" +  contact_type + 
			"deleted:" + deleted + 
			"add_dttm:" +  add_dttm + 
			"update_dttm:" + update_dttm + 
			"delete_dttm:" + delete_dttm +
			"status:" + status + 
			"previous_status:" + previous_status + 
			"referer_id:" + referer_id + 
			"notes:" + notes + 
			"num_itineraries:" + num_itineraries;
		return str;
	}
	public String getActionn() {
		return actionn;
	}
	public void setActionn(String actionn) {
		this.actionn = actionn;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		notes.replaceAll("'", "\'");
		this.notes = notes;
	}
	public int getNum_itineraries() {
		return num_itineraries;
	}
	public void setNum_itineraries(int num_itineraries) {
		this.num_itineraries = num_itineraries;
	}
	public int getReferer_id() {
		return referer_id;
	}
	public void setReferer_id(int referer_id) {
		this.referer_id = referer_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status.toUpperCase().trim();
	}
	
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by.toUpperCase().trim();
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by.toUpperCase().trim();
	}

	
	public void setUIAtributes() {
		if (ui_name.equals("")) {
			if (!contact_name.equals("")) {
				ui_name = contact_name;
			} else {
				ui_name = first_name + " " + middle_name + " " + last_name;
			}
		}
		if (ui_number.equals("")) {
			if (!phone_cell.equals("")) {
				ui_number = phone_cell;
			} else if (!phone_work.equals("")) {
				ui_number = phone_work;
			} else if (!phone_home.equals("")) {
				ui_number = phone_home;
			}
		}
		if (ui_email.equals("")) {
			if (!email_work.equals("")) {
				ui_email = email_work;
			} else if (!email_home.equals("")) {
				ui_email = email_home;
			}
		}
	}
	public String getAgent_assigned() {
		return agent_assigned;
	}
	public void setAgent_assigned(String agent_assigned) {
		this.agent_assigned = agent_assigned.toUpperCase().trim();
	}
	public String getStatus_history() {
		return status_history;
	}
	public void setStatus_history(String status_history) {
		this.status_history = status_history.toUpperCase().trim();
	}

	public String getPrevious_agent_assigned() {
		return previous_agent_assigned;
	}

	public void setPrevious_agent_assigned(String previous_agent_assigned) {
		this.previous_agent_assigned = previous_agent_assigned;
	}

	public String getPrevious_status() {
		return previous_status;
	}

	public void setPrevious_status(String previous_status) {
		this.previous_status = previous_status;
	}
	public String getContact_email() {
		return contact_email;
	}
	public void setContact_email(String contact_email) {
		this.contact_email = contact_email.toUpperCase();
	}
	public String getContact_phone() {
		return contact_phone;
	}
	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone.toUpperCase();
	}
	public String getContact_source() {
		return contact_source;
	}
	public void setContact_source(String contact_source) {
		this.contact_source = contact_source.toUpperCase().trim();
	}
	public String getTicketed_by() {
		return ticketed_by;
	}
	public void setTicketed_by(String ticketed_by) {
		this.ticketed_by = ticketed_by.toUpperCase().trim();
	}
	public String getItinerary_by() {
		return itinerary_by;
	}
	public void setItinerary_by(String itinerary_by) {
		this.itinerary_by = itinerary_by.toUpperCase().trim();
	}
	public String getTracking_number() {
		return tracking_number;
	}
	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number;
	}
	public int getStale() {
		return stale;
	}
	public void setStale(int stale) {
		this.stale = stale;
	}
}
