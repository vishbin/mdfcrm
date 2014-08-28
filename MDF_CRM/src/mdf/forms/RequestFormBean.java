package mdf.forms;

import org.apache.struts.action.ActionForm;

public class RequestFormBean extends ActionForm {
	//ui fields
		
	private String actionn ="add";

	private int request_id =0;
	private int customer_id = 0;
	private String depart_date = "";
	private String return_date = "";
	private String depart_airport = "";
	private String arrive_airport = "";
	private String primary_airline = "";
	private String notes = "";
	
	private String pax1_first_name = "";
	private String pax1_middle_name = "";
	private String pax1_last_name = "";
	private String pax1_title = "";
	private int pax1_age = 0;
	private String pax2_first_name = "";
	private String pax2_middle_name = "";
	private String pax2_last_name = "";
	private String pax2_title = "";
	private int pax2_age = 0;
	private String pax3_first_name = "";
	private String pax3_middle_name = "";
	private String pax3_last_name = "";
	private String pax3_title = "";
	private int pax3_age = 0;
	private String pax4_first_name = "";
	private String pax4_middle_name = "";
	private String pax4_last_name = "";
	private String pax4_title = "";
	private int pax4_age = 0;
	private String pax5_first_name = "";
	private String pax5_middle_name = "";
	private String pax5_last_name = "";
	private String pax5_title = "";
	private int pax5_age = 0;
	private int num_calls = 0;
	private int num_itinerary = 0;
	private int num_tickets = 0;
	private String insert_key = "";
	private boolean deleted = false;

	private String add_dttm = ""; 
	private String update_dttm = ""; 
	private String delete_dttm = ""; 

	private String created_by = ""; 
	private String updated_by = "";
	private String login_Id = "";
	private String Password = "";

	
	public String toString() {
		String str = 
			"actionn:" + actionn +
			"request_id:" + request_id +
			"customer_id:" + customer_id +
			"depart_date:" + depart_date + 
			"return_date:" + return_date +
			"depart_airport:" + depart_airport +
			"arrive_airport:" + arrive_airport +
			"notes:" + notes +

			"primary_airline:" + primary_airline + 
			"pax1_first_name:" + pax1_first_name +
			"pax1_last_name:" + pax1_last_name +
			"pax1_title:" + pax1_title +
			"pax1_age:" + pax1_age +
			"pax2_first_name:" + pax2_first_name +
			"pax2_last_name:" + pax2_last_name +
			"pax2_title:" + pax2_title +
			"pax2_age:" + pax2_age +
			"pax3_first_name:" + pax3_first_name +
			"pax3_last_name:" + pax3_last_name +
			"pax3_title:" + pax3_title +
			"pax3_age:" + pax3_age +
			"pax4_first_name:" + pax4_first_name +
			"pax4_last_name:" + pax4_last_name +
			"pax4_title:" + pax4_title +
			"pax4_age:" + pax4_age +
			"pax5_first_name:" + pax5_first_name +
			"pax5_last_name:" + pax5_last_name +
			"pax5_title:" + pax5_title +
			"pax5_age:" + pax5_age +
			"num_calls:" + num_calls +
			"num_itinerary:" + num_itinerary +
			"num_tickets:" + num_tickets +
			"insert_key:" + insert_key +
			"deleted:" + deleted +
			"add_dttm:" + add_dttm +
			"update_dttm:" + update_dttm +
			"delete_dttm:" + delete_dttm +
			"created_by:" + created_by +
			"updated_by:" + updated_by;
		return str;
	}


	public String getAdd_dttm() {
		return add_dttm;
	}


	public void setAdd_dttm(String add_dttm) {
		this.add_dttm = add_dttm;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}


	public String getDelete_dttm() {
		return delete_dttm;
	}


	public void setDelete_dttm(String delete_dttm) {
		this.delete_dttm = delete_dttm;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}


	public String getInsert_key() {
		return insert_key;
	}


	public void setInsert_key(String insert_key) {
		this.insert_key = insert_key;
	}


	public int getNum_calls() {
		return num_calls;
	}


	public void setNum_calls(int num_calls) {
		this.num_calls = num_calls;
	}


	public int getPax1_age() {
		return pax1_age;
	}


	public void setPax1_age(int pax1_age) {
		this.pax1_age = pax1_age;
	}


	public String getPax1_first_name() {
		return pax1_first_name;
	}


	public void setPax1_first_name(String pax1_first_name) {
		this.pax1_first_name = pax1_first_name;
	}


	public String getPax1_last_name() {
		return pax1_last_name;
	}


	public void setPax1_last_name(String pax1_last_name) {
		this.pax1_last_name = pax1_last_name;
	}


	public String getPax1_title() {
		return pax1_title;
	}


	public void setPax1_title(String pax1_title) {
		this.pax1_title = pax1_title;
	}


	public int getPax2_age() {
		return pax2_age;
	}


	public void setPax2_age(int pax2_age) {
		this.pax2_age = pax2_age;
	}


	public String getPax2_first_name() {
		return pax2_first_name;
	}


	public void setPax2_first_name(String pax2_first_name) {
		this.pax2_first_name = pax2_first_name;
	}


	public String getPax2_last_name() {
		return pax2_last_name;
	}


	public void setPax2_last_name(String pax2_last_name) {
		this.pax2_last_name = pax2_last_name;
	}


	public String getPax2_title() {
		return pax2_title;
	}


	public void setPax2_title(String pax2_title) {
		this.pax2_title = pax2_title;
	}


	public int getPax3_age() {
		return pax3_age;
	}


	public void setPax3_age(int pax3_age) {
		this.pax3_age = pax3_age;
	}


	public String getPax3_first_name() {
		return pax3_first_name;
	}


	public void setPax3_first_name(String pax3_first_name) {
		this.pax3_first_name = pax3_first_name;
	}


	public String getPax3_last_name() {
		return pax3_last_name;
	}


	public void setPax3_last_name(String pax3_last_name) {
		this.pax3_last_name = pax3_last_name;
	}


	public String getPax3_title() {
		return pax3_title;
	}


	public void setPax3_title(String pax3_title) {
		this.pax3_title = pax3_title;
	}


	public int getPax4_age() {
		return pax4_age;
	}


	public void setPax4_age(int pax4_age) {
		this.pax4_age = pax4_age;
	}


	public String getPax4_first_name() {
		return pax4_first_name;
	}


	public void setPax4_first_name(String pax4_first_name) {
		this.pax4_first_name = pax4_first_name;
	}


	public String getPax4_last_name() {
		return pax4_last_name;
	}


	public void setPax4_last_name(String pax4_last_name) {
		this.pax4_last_name = pax4_last_name;
	}


	public String getPax4_title() {
		return pax4_title;
	}


	public void setPax4_title(String pax4_title) {
		this.pax4_title = pax4_title;
	}


	public int getPax5_age() {
		return pax5_age;
	}


	public void setPax5_age(int pax5_age) {
		this.pax5_age = pax5_age;
	}


	public String getPax5_first_name() {
		return pax5_first_name;
	}


	public void setPax5_first_name(String pax5_first_name) {
		this.pax5_first_name = pax5_first_name;
	}


	public String getPax5_last_name() {
		return pax5_last_name;
	}


	public void setPax5_last_name(String pax5_last_name) {
		this.pax5_last_name = pax5_last_name;
	}


	public String getPax5_title() {
		return pax5_title;
	}


	public void setPax5_title(String pax5_title) {
		this.pax5_title = pax5_title;
	}


	public int getRequest_id() {
		return request_id;
	}


	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}


	public String getUpdate_dttm() {
		return update_dttm;
	}


	public void setUpdate_dttm(String update_dttm) {
		this.update_dttm = update_dttm;
	}


	public String getCreated_by() {
		return created_by;
	}


	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}


	public String getUpdated_by() {
		return updated_by;
	}


	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}


	public int getNum_itinerary() {
		return num_itinerary;
	}


	public void setNum_itinerary(int num_itinerary) {
		this.num_itinerary = num_itinerary;
	}


	public String getDepart_date() {
		return depart_date;
	}


	public void setDepart_date(String depart_date) {
		this.depart_date = depart_date;
	}


	public int getNum_tickets() {
		return num_tickets;
	}


	public void setNum_tickets(int num_tickets) {
		this.num_tickets = num_tickets;
	}


	public String getPrimary_airline() {
		return primary_airline;
	}


	public void setPrimary_airline(String primary_airline) {
		this.primary_airline = primary_airline;
	}


	public String getReturn_date() {
		return return_date;
	}


	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}


	public String getArrive_airport() {
		return arrive_airport;
	}


	public void setArrive_airport(String arrive_airport) {
		this.arrive_airport = arrive_airport;
	}


	public String getDepart_airport() {
		return depart_airport;
	}


	public void setDepart_airport(String depart_airport) {
		this.depart_airport = depart_airport;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public String getActionn() {
		return actionn;
	}


	public void setActionn(String actionn) {
		this.actionn = actionn;
	}


	public String getPax1_middle_name() {
		return pax1_middle_name;
	}


	public void setPax1_middle_name(String pax1_middle_name) {
		this.pax1_middle_name = pax1_middle_name;
	}


	public String getPax2_middle_name() {
		return pax2_middle_name;
	}


	public void setPax2_middle_name(String pax2_middle_name) {
		this.pax2_middle_name = pax2_middle_name;
	}


	public String getPax3_middle_name() {
		return pax3_middle_name;
	}


	public void setPax3_middle_name(String pax3_middle_name) {
		this.pax3_middle_name = pax3_middle_name;
	}


	public String getPax4_middle_name() {
		return pax4_middle_name;
	}


	public void setPax4_middle_name(String pax4_middle_name) {
		this.pax4_middle_name = pax4_middle_name;
	}


	public String getPax5_middle_name() {
		return pax5_middle_name;
	}


	public void setPax5_middle_name(String pax5_middle_name) {
		this.pax5_middle_name = pax5_middle_name;
	}


	public String getLogin_Id() {
		return login_Id;
	}


	public void setLogin_Id(String login_Id) {
		this.login_Id = login_Id;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}
}
