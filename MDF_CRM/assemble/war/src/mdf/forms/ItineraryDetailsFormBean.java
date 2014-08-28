package mdf.forms;


public class ItineraryDetailsFormBean extends ItineraryFormBean {
	private int itinerary_id = 0;
	private int request_id = 0;
	private int contact_id = 0;
	private String pnr = "";
	private String crs = "";
	private String pcc = "";
	private String link = "";
	private String ticket_number = "";
	private double quote_sell = 0;
	private double base_sell = 0;
	private double tax_sell = 0;
	private double quote_buy = 0;
	private double base_buy = 0;
	private double tax_buy = 0;
	private double other_expenses = 0;
	private double margin = 0;
	private String insert_key = "";
	private boolean deleted = false;
	private long create_dttm = 0; 
	private long update_dttm = 0; 
	private long delete_dttm = 0; 
	private String created_by = ""; 
	private String updated_by = ""; 
	
	private long depart_date = 0; 
	private long return_date = 0;
	private String depart_airport = "";
	private String arrive_airport = "";
	private String primary_airline = "";
	
	private String pax1_title = "";
	private String pax1_last_name = "";
	private String pax1_first_name = "";
	private String pax1_middle_name = "";
	private double pax1_age = 0;
	private String pax2_title = "";
	private String pax2_last_name = "";
	private String pax2_first_name = "";
	private String pax2_middle_name = "";
	private double pax2_age = 0;
	private String pax3_title = "";
	private String pax3_last_name = "";
	private String pax3_first_name = "";
	private String pax3_middle_name = "";
	private double pax3_age = 0;
	private String pax4_title = "";
	private String pax4_last_name = "";
	private String pax4_first_name = "";
	private String pax4_middle_name = "";
	private double pax4_age = 0;
	private String pax5_title = "";
	private String pax5_last_name = "";
	private String pax5_first_name = "";
	private String pax5_middle_name = "";
	private double pax5_age = 0;
	
	
	public String toString() {
		String str = 
			"itinerary_id:" + itinerary_id + 
			"request_id:" + request_id + 
			"contact_id:" + contact_id + 
			"pnr:" + pnr + 
			"crs:" + crs + 
			"pcc:" + pcc + 
			"link:" + link + 
			"ticket_number:" +ticket_number + 
			"quote_sell:" + quote_sell + 
			"base_sell:" + base_sell + 
			"tax_sell:" + tax_sell + 
			"quote_buy:" + quote_buy + 
			"base_buy:" + base_buy + 
			"tax_buy:" + tax_buy + 
			"other_expenses:" + other_expenses + 
			"margin:" + margin + 
			"insert_key:" + insert_key + 
			"deleted:" + deleted + 
			"create_dttm:" + create_dttm + 
			"update_dttm:" + update_dttm + 
			"delete_dttm:" + delete_dttm + 
			"created_by:" + created_by + 
			"updated_by:" + updated_by + 
			"depart_date:" + depart_date + 
			"return_date:" + return_date + 
			"depart_airport:" + depart_airport + 
			"arrive_airport:" + arrive_airport + 
			"primary_airline:" + primary_airline + 
			"pax1_title:" + pax1_title + 
			"pax1_last_name:" + pax1_last_name + 
			"pax1_first_name:" + pax1_first_name + 
			"pax1_middle_name:" + pax1_middle_name + 
			"pax1_age:" + pax1_age + 
			"pax2_title:" + pax2_title + 
			"pax2_last_name:" + pax2_last_name + 
			"pax2_first_name:" + pax2_first_name + 
			"pax2_middle_name:" + pax2_middle_name + 
			"pax2_age:" + pax2_age + 
			"pax3_title:" + pax3_title + 
			"pax3_last_name:" + pax3_last_name + 
			"pax3_first_name:" + pax3_first_name + 
			"pax3_middle_name:" + pax3_middle_name + 
			"pax3_age:" + pax3_age + 
			"pax4_title:" + pax4_title + 
			"pax4_last_name:" + pax4_last_name + 
			"pax4_first_name:" + pax4_first_name + 
			"pax4_middle_name:" + pax4_middle_name + 
			"pax4_age:" + pax4_age + 
			"pax5_title:" + pax5_title + 
			"pax5_last_name:" + pax5_last_name + 
			"pax5_first_name:" + pax5_first_name + 
			"pax5_middle_name:" + pax5_middle_name + 
			"pax5_age:" + pax5_age; 
		return str;
	}




	public String getArrive_airport() {
		return arrive_airport;
	}




	public void setArrive_airport(String arrive_airport) {
		this.arrive_airport = arrive_airport;
	}




	public double getBase_buy() {
		return base_buy;
	}




	public void setBase_buy(double base_buy) {
		this.base_buy = base_buy;
	}




	public double getBase_sell() {
		return base_sell;
	}




	public void setBase_sell(double base_sell) {
		this.base_sell = base_sell;
	}




	public int getContact_id() {
		return contact_id;
	}




	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}




	public long getCreate_dttm() {
		return create_dttm;
	}




	public void setCreate_dttm(long create_dttm) {
		this.create_dttm = create_dttm;
	}




	public String getCreated_by() {
		return created_by;
	}




	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}




	public String getCrs() {
		return crs;
	}




	public void setCrs(String crs) {
		this.crs = crs;
	}




	public long getDelete_dttm() {
		return delete_dttm;
	}




	public void setDelete_dttm(long delete_dttm) {
		this.delete_dttm = delete_dttm;
	}




	public boolean isDeleted() {
		return deleted;
	}




	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}




	public String getDepart_airport() {
		return depart_airport;
	}




	public void setDepart_airport(String depart_airport) {
		this.depart_airport = depart_airport;
	}




	public long getDepart_date() {
		return depart_date;
	}




	public void setDepart_date(long depart_date) {
		this.depart_date = depart_date;
	}




	public String getInsert_key() {
		return insert_key;
	}




	public void setInsert_key(String insert_key) {
		this.insert_key = insert_key;
	}




	public int getItinerary_id() {
		return itinerary_id;
	}




	public void setItinerary_id(int itinerary_id) {
		this.itinerary_id = itinerary_id;
	}




	public String getLink() {
		return link;
	}




	public void setLink(String link) {
		this.link = link;
	}




	public double getMargin() {
		return margin;
	}




	public void setMargin(double margin) {
		this.margin = margin;
	}




	public double getOther_expenses() {
		return other_expenses;
	}




	public void setOther_expenses(double other_expenses) {
		this.other_expenses = other_expenses;
	}




	public double getPax1_age() {
		return pax1_age;
	}




	public void setPax1_age(double pax1_age) {
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




	public String getPax1_middle_name() {
		return pax1_middle_name;
	}




	public void setPax1_middle_name(String pax1_middle_name) {
		this.pax1_middle_name = pax1_middle_name;
	}




	public String getPax1_title() {
		return pax1_title;
	}




	public void setPax1_title(String pax1_title) {
		this.pax1_title = pax1_title;
	}




	public double getPax2_age() {
		return pax2_age;
	}




	public void setPax2_age(double pax2_age) {
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




	public String getPax2_middle_name() {
		return pax2_middle_name;
	}




	public void setPax2_middle_name(String pax2_middle_name) {
		this.pax2_middle_name = pax2_middle_name;
	}




	public String getPax2_title() {
		return pax2_title;
	}




	public void setPax2_title(String pax2_title) {
		this.pax2_title = pax2_title;
	}




	public double getPax3_age() {
		return pax3_age;
	}




	public void setPax3_age(double pax3_age) {
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




	public String getPax3_middle_name() {
		return pax3_middle_name;
	}




	public void setPax3_middle_name(String pax3_middle_name) {
		this.pax3_middle_name = pax3_middle_name;
	}




	public String getPax3_title() {
		return pax3_title;
	}




	public void setPax3_title(String pax3_title) {
		this.pax3_title = pax3_title;
	}




	public double getPax4_age() {
		return pax4_age;
	}




	public void setPax4_age(double pax4_age) {
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




	public String getPax4_middle_name() {
		return pax4_middle_name;
	}




	public void setPax4_middle_name(String pax4_middle_name) {
		this.pax4_middle_name = pax4_middle_name;
	}




	public String getPax4_title() {
		return pax4_title;
	}




	public void setPax4_title(String pax4_title) {
		this.pax4_title = pax4_title;
	}




	public double getPax5_age() {
		return pax5_age;
	}




	public void setPax5_age(double pax5_age) {
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




	public String getPax5_middle_name() {
		return pax5_middle_name;
	}




	public void setPax5_middle_name(String pax5_middle_name) {
		this.pax5_middle_name = pax5_middle_name;
	}




	public String getPax5_title() {
		return pax5_title;
	}




	public void setPax5_title(String pax5_title) {
		this.pax5_title = pax5_title;
	}




	public String getPcc() {
		return pcc;
	}




	public void setPcc(String pcc) {
		this.pcc = pcc;
	}




	public String getPnr() {
		return pnr;
	}




	public void setPnr(String pnr) {
		this.pnr = pnr;
	}




	public String getPrimary_airline() {
		return primary_airline;
	}




	public void setPrimary_airline(String primary_airline) {
		this.primary_airline = primary_airline;
	}




	public double getQuote_buy() {
		return quote_buy;
	}




	public void setQuote_buy(double quote_buy) {
		this.quote_buy = quote_buy;
	}




	public double getQuote_sell() {
		return quote_sell;
	}




	public void setQuote_sell(double quote_sell) {
		this.quote_sell = quote_sell;
	}




	public int getRequest_id() {
		return request_id;
	}




	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}




	public long getReturn_date() {
		return return_date;
	}




	public void setReturn_date(long return_date) {
		this.return_date = return_date;
	}




	public double getTax_buy() {
		return tax_buy;
	}




	public void setTax_buy(double tax_buy) {
		this.tax_buy = tax_buy;
	}




	public double getTax_sell() {
		return tax_sell;
	}




	public void setTax_sell(double tax_sell) {
		this.tax_sell = tax_sell;
	}




	public String getTicket_number() {
		return ticket_number;
	}




	public void setTicket_number(String ticket_number) {
		this.ticket_number = ticket_number;
	}




	public long getUpdate_dttm() {
		return update_dttm;
	}




	public void setUpdate_dttm(long update_dttm) {
		this.update_dttm = update_dttm;
	}




	public String getUpdated_by() {
		return updated_by;
	}




	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
}
