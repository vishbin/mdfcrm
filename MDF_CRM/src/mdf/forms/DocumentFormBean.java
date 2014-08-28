package mdf.forms;

import org.apache.struts.action.ActionForm;

public class DocumentFormBean extends ActionForm {
	//ui fields
	private String ui_name = "";
	private String ui_number = "";
	private String ui_email = "";
		
	private int contact_id = 0;
	private String contact_name = "";
	private String first_name = "";
	private String middle_name = "";
	private String last_name = "";
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
	
	private String address_line1_home = "";
	private String address_line2_home = "";
	private String address_line3_home = "";
	private String city_home = "";
	private String state_home = "";
	private String zip_home = "";
	private String country_home = "";
	private String address_line1_work = "";
	private String address_line2_work = "";
	private String address_line3_work = "";
	private String city_work = "";
	private String state_work = "";
	private String zip_work = "";
	private String country_work = "";
	private String contact_type = "";
	private boolean deleted = false;
	private long add_dttm = 0; 
	private long update_dttm = 0; 
	private long delete_dttm = 0; 
	
	
	public String getAddress_line1_home() {
		return address_line1_home;
	}
	public void setAddress_line1_home(String address_line1_home) {
		this.address_line1_home = address_line1_home;
	}
	public String getAddress_line1_work() {
		return address_line1_work;
	}
	public void setAddress_line1_work(String address_line1_work) {
		this.address_line1_work = address_line1_work;
	}
	public String getAddress_line2_home() {
		return address_line2_home;
	}
	public void setAddress_line2_home(String address_line2_home) {
		this.address_line2_home = address_line2_home;
	}
	public String getAddress_line2_work() {
		return address_line2_work;
	}
	public void setAddress_line2_work(String address_line2_work) {
		this.address_line2_work = address_line2_work;
	}
	public String getAddress_line3_home() {
		return address_line3_home;
	}
	public void setAddress_line3_home(String address_line3_home) {
		this.address_line3_home = address_line3_home;
	}
	public String getAddress_line3_work() {
		return address_line3_work;
	}
	public void setAddress_line3_work(String address_line3_work) {
		this.address_line3_work = address_line3_work;
	}
	public String getCity_home() {
		return city_home;
	}
	public void setCity_home(String city_home) {
		this.city_home = city_home;
	}
	public String getCity_work() {
		return city_work;
	}
	public void setCity_work(String city_work) {
		this.city_work = city_work;
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
		this.contact_name = contact_name;
	}
	public String getContact_type() {
		return contact_type;
	}
	public void setContact_type(String contact_type) {
		this.contact_type = contact_type;
	}
	public String getCountry_home() {
		return country_home;
	}
	public void setCountry_home(String country_home) {
		this.country_home = country_home;
	}
	public String getCountry_work() {
		return country_work;
	}
	public void setCountry_work(String country_work) {
		this.country_work = country_work;
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
		this.email_home = email_home;
	}
	public String getEmail_work() {
		return email_work;
	}
	public void setEmail_work(String email_work) {
		this.email_work = email_work;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getInsert_key() {
		return insert_key;
	}
	public void setInsert_key(String insert_key) {
		this.insert_key = insert_key;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
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
		this.phone_cell = phone_cell;
	}
	public String getPhone_home() {
		return phone_home;
	}
	public void setPhone_home(String phone_home) {
		this.phone_home = phone_home;
	}
	public String getPhone_work() {
		return phone_work;
	}
	public void setPhone_work(String phone_work) {
		this.phone_work = phone_work;
	}
	public String getState_home() {
		return state_home;
	}
	public void setState_home(String state_home) {
		this.state_home = state_home;
	}
	public String getState_work() {
		return state_work;
	}
	public void setState_work(String state_work) {
		this.state_work = state_work;
	}
	public String getZip_home() {
		return zip_home;
	}
	public void setZip_home(String zip_home) {
		this.zip_home = zip_home;
	}
	public String getZip_work() {
		return zip_work;
	}
	public void setZip_work(String zip_work) {
		this.zip_work = zip_work;
	}
	public String getUi_email() {
		return ui_email;
	}
	public void setUi_email(String ui_email) {
		this.ui_email = ui_email;
	}
	public String getUi_name() {
		return ui_name;
	}
	public void setUi_name(String ui_name) {
		this.ui_name = ui_name;
	}
	public String getUi_number() {
		return ui_number;
	}
	public void setUi_number(String ui_number) {
		this.ui_number = ui_number;
	}
	
	public long getAdd_dttm() {
		return add_dttm;
	}
	public void setAdd_dttm(long add_dttm) {
		this.add_dttm = add_dttm;
	}
	public long getDelete_dttm() {
		return delete_dttm;
	}
	public void setDelete_dttm(long delete_dttm) {
		this.delete_dttm = delete_dttm;
	}
	public long getUpdate_dttm() {
		return update_dttm;
	}
	public void setUpdate_dttm(long update_dttm) {
		this.update_dttm = update_dttm;
	}

	public String toString() {
		String str = 
			"ui_name:" + ui_name + 
			"ui_number:" +  ui_number + 
			"ui_email:" +  ui_email + 
			"contact_id:" +  contact_id + 
			"contact_name:" +  contact_name + 
			"first_name:" +  first_name + 
			"middle_name:" + middle_name + 
			"last_name:" +  last_name + 
			"num_referrals:" +  num_referrals + 
			"num_tickets:" + num_tickets + 
			"num_open_tickets:" +  num_open_tickets + 
			"num_queries:" + num_queries + 
			"dues:" +  dues + 
			"insert_key:" +  insert_key + 
			"phone_work:" +  phone_work + 
			"phone_cell:" +  phone_cell + 
			"phone_home:" +  phone_home + 
			"email_home:" +  email_home + 
			"email_work:" +  email_work + 
			"address_line1_home:" +  address_line1_home + 
			"address_line2_home:" +  address_line2_home + 
			"address_line3_home:" +  address_line3_home + 
			"city_home:" +  city_home + 
			"state_home:" +  state_home + 
			"zip_home:" +  zip_home + 
			"country_home:" +  country_home + 
			"address_line1_work:" +  address_line1_work + 
			"address_line2_work:" +  address_line2_work + 
			"address_line3_work:" +  address_line3_work + 
			"city_work:" +  city_work + 
			"state_work:" +  state_work + 
			"zip_work:" +  zip_work + 
			"country_work:" +  country_work + 
			"contact_type:" +  contact_type + 
			"deleted:" + deleted + 
			"add_dttm:" +  add_dttm + 
			"update_dttm:" + update_dttm + 
			"delete_dttm:" + delete_dttm;
		return str;
	}
}
