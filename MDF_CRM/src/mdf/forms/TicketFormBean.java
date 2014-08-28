package mdf.forms;

import java.util.ArrayList;
import java.util.List;

import mdf.object.PersonName;
import mdf.object.TicketingLine;

import org.apache.struts.action.ActionForm;

public class TicketFormBean extends ActionForm {
	
	private String actionn = "add";
	
	private String ui_name = "";
	private String ui_number = "";
	private String ui_email = "";
	
	private List ticketingLines;
	private List paxNames;
	private List airlineInfoLines;
	
	private String linePresent = "false";
	
	private int ticket_id = 0;
	private boolean deleted = false;
	private String insert_key = "";
	private int contact_id = 0;
	private int itinerary_id = 0;
	private String pnr = "";
	private String crs = "";
	private String pcc = "";
	private String itinerary_link = "";
	private String ticket_link = "";
	private String invoice_link = "";
	private int transaction_number = 0;
	private int branch_id = 0;
	private int invoice_number = 0;
	private String sales_type = "";
	private String ticket_type = "";
	private int num_pax = 0;
	private String ticket_issuer = "";
	private String issuing_iata = "";
	private String agent_name = "";
	private int agent_id = 0;
	private String issue_date;
	private String depart_date;
	private String return_date;
	private String depart_airport = "";
	private String arrive_airport = "";
	private String primary_airline = "";
	private String totalCurrency = "";
	private double totalCharge = 0;
	private double totalBase = 0;
	private double totalTax = 0;
	private double totalSurcharge = 0;
	private double total_expenses = 0;
	private double total_margin = 0;
	private String form_of_payment = "";
	private String receivedBy = "";
	private String card_type = "";
	private String card_number = "";
	private String check_number = "";
	private String bank_name = "";
	private String comments = "";
	private String notes = "";
	private String tracking_link = "";
	private String tracking_number = "";
	private String mail_to = "";
	private String mailingAddress_line1 = "";
	private String mailingAddress_line2 = "";
	private String mailingAddress_line3 = "";
	private String mailingAddress_city = "";
	private String mailingAddress_state = "";
	private String mailingAddress_zip = "";
	private String mailingAddress_country = "";
	private String bill_to = "";
	private String billingAddress_line1 = "";
	private String billingAddress_line2 = "";
	private String billingAddress_line3 = "";
	private String billingAddress_city = "";
	private String billingAddress_state = "";
	private String billingAddress_zip = "";
	private String billingAddress_country = "";
	private String pax1Last_name = "";
	private String pax1First_name = "";
	private String pax1Middle_name = "";
	private String pax1Title = "";
	private int pax1Age = 0;
	private String pax1Description = "";
	private String pax1Currency = "";
	private double pax1Charge = 0;
	private double pax1Base = 0;
	private double pax1Tax = 0;
	private double pax1Surcharge = 0;
	private String pax2Last_name = "";
	private String pax2First_name = "";
	private String pax2Middle_name = "";
	private String pax2Title = "";
	private int pax2Age = 0;
	private String pax2Description = "";
	private String pax2Currency = "";
	private double pax2Charge = 0;
	private double pax2Base = 0;
	private double pax2Tax = 0;
	private double pax2Surcharge = 0;
	private String pax3Last_name = "";
	private String pax3First_name = "";
	private String pax3Middle_name = "";
	private String pax3Title = "";
	private int pax3Age = 0;
	private String pax3Description = "";
	private String pax3Currency = "";
	private double pax3Charge = 0;
	private double pax3Base = 0;
	private double pax3Tax = 0;
	private double pax3Surcharge = 0;
	private String pax4Last_name = "";
	private String pax4First_name = "";
	private String pax4Middle_name = "";
	private String pax4Title = "";
	private int pax4Age = 0;
	private String pax4Description = "";
	private String pax4Currency = "";
	private double pax4Charge = 0;
	private double pax4Base = 0;
	private double pax4Tax = 0;
	private double pax4Surcharge = 0;
	private String pax5First_name = "";
	private String pax5Last_name = "";
	private String pax5Middle_name = "";
	private String pax5Title = "";
	private int pax5Age = 0;
	private String pax5Description = "";
	private String pax5Currency = "";
	private double pax5Charge = 0;
	private double pax5Base = 0;
	private double pax5Tax = 0;
	private double pax5Surcharge = 0;
	private String added_by = "";
	private String updated_by = "";
	private String add_dttm;
	private String update_dttm;
	private String delete_dttm;
	private String raw_text = "";

	public void addPersonName(PersonName personName) {
		if (paxNames == null)
			paxNames = new ArrayList();
		paxNames.add(personName);
	}
	
	public PersonName createPersonName(String firstName, String lastName, String middleName, String title, String suffix) {
		PersonName personName = new PersonName();
		personName.setFirstName(firstName);
		personName.setMiddleName(middleName);
		personName.setLastName(lastName);
		personName.setTitle(title);
		personName.setSuffix(suffix);
		
		return personName;
	}
	
	public void addTicketingLine(TicketingLine ticketingLine) {
		if (ticketingLines == null)
			ticketingLines = new ArrayList();
		ticketingLines.add(ticketingLine);
	}
	
	public TicketingLine createTicketingLine(
			String lineNumber,
			boolean voidLine,
			String airlineCode,
			String airlineName,
			String flightNumber,
			String departDateOfMonth,
			String departDayOfWeek,
			String departAirport,
			String arriveAirport,
			String confirmStatus,
			int numPax,
			String departTime,
			String arriveTime,
			String arriveDateOfMonth,
			String arriveDayOfWeek,
			String airlineConfirmCode) {
		
		TicketingLine ticketingLine = new TicketingLine();
		ticketingLine.setAirlineCode(airlineCode);
		ticketingLine.setAirlineConfirmCode(airlineConfirmCode);
		ticketingLine.setAirlineName(airlineName);
		ticketingLine.setArriveAirport(arriveAirport);
		ticketingLine.setArriveDateOfMonth(arriveDateOfMonth);
		ticketingLine.setArriveDayOfWeek(arriveDayOfWeek);
		ticketingLine.setArriveTime(arriveTime);
		ticketingLine.setConfirmStatus(confirmStatus);
		ticketingLine.setDepartAirport(departAirport);
		ticketingLine.setDepartDateOfMonth(departDateOfMonth);
		ticketingLine.setDepartDayOfWeek(departDayOfWeek);
		ticketingLine.setDepartTime(departTime);
		ticketingLine.setFlightNumber(flightNumber);
		ticketingLine.setLineNumber(lineNumber);
		ticketingLine.setNumPax(numPax);
		ticketingLine.setVoidLine(voidLine);
		
		return ticketingLine;
	}
	
	public String toString() {
		String str = 
			"ui_name:" + ui_name +
			"ui_number:" + ui_number +
			"ui_email:" + ui_email +

			"ticketingLines:" + ticketingLines +
			"paxNames:" + paxNames +

			"ticket_id:" + ticket_id +
			"deleted:" + deleted +
			"insert_key:" + insert_key +
			"contact_id:" + contact_id +
			"itinerary_id:" + itinerary_id +
			"pnr:" + pnr +
			"crs:" + crs +
			"pcc:" + pcc +
			"itinerary_link:" + itinerary_link +
			"ticket_link:" + ticket_link +
			"invoice_link:" + invoice_link +
			"transaction_number:" + transaction_number +
			"branch_id:" + branch_id +
			"invoice_number:" + invoice_number +
			"sales_type:" + sales_type +
			"ticket_type:" + ticket_type +
			"num_pax:" + num_pax +
			"ticket_issuer:" + ticket_issuer +
			"agent_name:" + agent_name +
			"agent_id:" + agent_id +
			"issue_date:" + issue_date +
			"depart_date:" + depart_date +
			"return_date:" + return_date +
			"depart_airport:" + depart_airport +
			"arrive_airport:" + arrive_airport +
			"primary_airline:" + primary_airline +
			"totalCharge:" + totalCharge +
			"totalBase:" + totalBase +
			"totalTax:" + totalTax +
			"totalSurcharge:" + totalSurcharge +
			"total_expenses:" + total_expenses +
			"total_margin:" + total_margin +
			"form_of_payment:" + form_of_payment +
			"receivedBy:" + receivedBy +
			"card_type:" + card_type +
			"card_number:" + card_number +
			"check_number:" + check_number +
			"bank_name:" + bank_name +
			"comments:" + comments +
			"notes:" + notes +
			"tracking_link:" + tracking_link +
			"tracking_number:" + tracking_number +
			"mail_to:" + mail_to +
			"mailingAddress_line1:" + mailingAddress_line1 +
			"mailingAddress_line2:" + mailingAddress_line2 +
			"mailingAddress_line3:" + mailingAddress_line3 +
			"mailingAddress_city:" + mailingAddress_city +
			"mailingAddress_state:" + mailingAddress_state +
			"mailingAddress_zip:" + mailingAddress_zip +
			"mailingAddress_country:" + mailingAddress_country +
			"bill_to:" + bill_to +
			"billingAddress_line1:" + billingAddress_line1 +
			"billingAddress_line2:" + billingAddress_line2 +
			"billingAddress_line3:" + billingAddress_line3 +
			"billingAddress_city:" + billingAddress_city +
			"billingAddress_state:" + billingAddress_state +
			"billingAddress_zip:" + billingAddress_zip +
			"billingAddress_country:" + billingAddress_country +
			"pax1Last_name:" + pax1Last_name +
			"pax1First_name:" + pax1First_name +
			"pax1Middle_name:" + pax1Middle_name +
			"pax1Title:" + pax1Title +
			"pax1Age:" + pax1Age +
			"pax1Description:" + pax1Description +
			"pax1Charge:" + pax1Charge +
			"pax1Base:" + pax1Base +
			"pax1Tax:" + pax1Tax +
			"pax1Surcharge:" + pax1Surcharge +
			"pax2Last_name:" + pax2Last_name +
			"pax2First_name:" + pax2First_name +
			"pax2Middle_name:" + pax2Middle_name +
			"pax2Title:" + pax2Title +
			"pax2Age:" + pax2Age +
			"pax2Description:" + pax2Description +
			"pax2Charge:" + pax2Charge +
			"pax2Base:" + pax2Base +
			"pax2Tax:" + pax2Tax +
			"pax2Surcharge:" + pax2Surcharge +
			"pax3Last_name:" + pax3Last_name +
			"pax3First_name:" + pax3First_name +
			"pax3Middle_name:" + pax3Middle_name +
			"pax3Title:" + pax3Title +
			"pax3Age:" + pax3Age +
			"pax3Description:" + pax3Description +
			"pax3Charge:" + pax3Charge +
			"pax3Base:" + pax3Base +
			"pax3Tax:" + pax3Tax +
			"pax3Surcharge:" + pax3Surcharge +
			"pax4Last_name:" + pax4Last_name +
			"pax4First_name:" + pax4First_name +
			"pax4Middle_name:" + pax4Middle_name +
			"pax4Title:" + pax4Title +
			"pax4Age:" + pax4Age +
			"pax4Description:" + pax4Description +
			"pax4Charge:" + pax4Charge +
			"pax4Base:" + pax4Base +
			"pax4Tax:" + pax4Tax +
			"pax4Surcharge:" + pax4Surcharge +
			"pax5First_name:" + pax5First_name +
			"pax5Last_name:" + pax5Last_name +
			"pax5Middle_name:" + pax5Middle_name +
			"pax5Title:" + pax5Title +
			"pax5Age:" + pax5Age +
			"pax5Description:" + pax5Description +
			"pax5Charge:" + pax5Charge +
			"pax5Base:" + pax5Base +
			"pax5Tax:" + pax5Tax +
			"pax5Surcharge:" + pax5Surcharge +
			"added_by:" + added_by +
			"updated_by:" + updated_by +
			"add_dttm:" + add_dttm +
			"update_dttm:" + update_dttm +
			"delete_dttm:" + delete_dttm +
			"raw_text:" + raw_text
			;
		return str;
	}

	public String getActionn() {
		return actionn;
	}

	public void setActionn(String actionn) {
		this.actionn = actionn.toUpperCase().trim();
	}

	public String getAdd_dttm() {
		return add_dttm;
	}

	public void setAdd_dttm(String add_dttm) {
		this.add_dttm = add_dttm;
	}

	public String getAdded_by() {
		return added_by;
	}

	public void setAdded_by(String added_by) {
		this.added_by = added_by.toUpperCase().trim();
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name.toUpperCase().trim();
	}

	public String getArrive_airport() {
		return arrive_airport;
	}

	public void setArrive_airport(String arrive_airport) {
		this.arrive_airport = arrive_airport.toUpperCase().trim();
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name.toUpperCase().trim();
	}

	public String getBill_to() {
		return bill_to;
	}

	public void setBill_to(String bill_to) {
		this.bill_to = bill_to.toUpperCase().trim();
	}

	public String getBillingAddress_city() {
		return billingAddress_city;
	}

	public void setBillingAddress_city(String billingAddress_city) {
		this.billingAddress_city = billingAddress_city.toUpperCase().trim();
	}

	public String getBillingAddress_country() {
		return billingAddress_country;
	}

	public void setBillingAddress_country(String billingAddress_country) {
		this.billingAddress_country = billingAddress_country.toUpperCase().trim();
	}

	public String getBillingAddress_line1() {
		return billingAddress_line1;
	}

	public void setBillingAddress_line1(String billingAddress_line1) {
		this.billingAddress_line1 = billingAddress_line1.toUpperCase().trim();
	}

	public String getBillingAddress_line2() {
		return billingAddress_line2;
	}

	public void setBillingAddress_line2(String billingAddress_line2) {
		this.billingAddress_line2 = billingAddress_line2;
	}

	public String getBillingAddress_line3() {
		return billingAddress_line3;
	}

	public void setBillingAddress_line3(String billingAddress_line3) {
		this.billingAddress_line3 = billingAddress_line3.toUpperCase().trim();
	}

	public String getBillingAddress_state() {
		return billingAddress_state;
	}

	public void setBillingAddress_state(String billingAddress_state) {
		this.billingAddress_state = billingAddress_state.toUpperCase().trim();
	}

	public String getBillingAddress_zip() {
		return billingAddress_zip;
	}

	public void setBillingAddress_zip(String billingAddress_zip) {
		this.billingAddress_zip = billingAddress_zip.toUpperCase().trim();
	}

	public String getCard_number() {
		return card_number;
	}

	public void setCard_number(String card_number) {
		this.card_number = card_number.toUpperCase().trim();
	}

	public String getCard_type() {
		return card_type;
	}

	public void setCard_type(String card_type) {
		this.card_type = card_type.toUpperCase().trim();
	}

	public String getCheck_number() {
		return check_number;
	}

	public void setCheck_number(String check_number) {
		this.check_number = check_number.toUpperCase().trim();
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments.toUpperCase().trim();
	}

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public String getCrs() {
		return crs;
	}

	public void setCrs(String crs) {
		this.crs = crs.toUpperCase().trim();
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

	public String getDepart_airport() {
		return depart_airport;
	}

	public void setDepart_airport(String depart_airport) {
		this.depart_airport = depart_airport.toUpperCase().trim();
	}

	public String getDepart_date() {
		return depart_date;
	}

	public void setDepart_date(String depart_date) {
		this.depart_date = depart_date;
	}

	public String getForm_of_payment() {
		return form_of_payment;
	}

	public void setForm_of_payment(String form_of_payment) {
		this.form_of_payment = form_of_payment.toUpperCase().trim();
	}

	public String getInsert_key() {
		return insert_key;
	}

	public void setInsert_key(String insert_key) {
		this.insert_key = insert_key;
	}

	public String getInvoice_link() {
		return invoice_link;
	}

	public void setInvoice_link(String invoice_link) {
		this.invoice_link = invoice_link;
	}

	public int getInvoice_number() {
		return invoice_number;
	}

	public void setInvoice_number(int invoice_number) {
		this.invoice_number = invoice_number;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public int getItinerary_id() {
		return itinerary_id;
	}

	public void setItinerary_id(int itinerary_id) {
		this.itinerary_id = itinerary_id;
	}

	public String getItinerary_link() {
		return itinerary_link;
	}

	public void setItinerary_link(String itinerary_link) {
		this.itinerary_link = itinerary_link;
	}

	public String getMail_to() {
		return mail_to;
	}

	public void setMail_to(String mail_to) {
		this.mail_to = mail_to.toUpperCase().trim();
	}

	public String getMailingAddress_city() {
		return mailingAddress_city;
	}

	public void setMailingAddress_city(String mailingAddress_city) {
		this.mailingAddress_city = mailingAddress_city.toUpperCase().trim();
	}

	public String getMailingAddress_country() {
		return mailingAddress_country;
	}

	public void setMailingAddress_country(String mailingAddress_country) {
		this.mailingAddress_country = mailingAddress_country.toUpperCase().trim();
	}

	public String getMailingAddress_line1() {
		return mailingAddress_line1;
	}

	public void setMailingAddress_line1(String mailingAddress_line1) {
		this.mailingAddress_line1 = mailingAddress_line1;
	}

	public String getMailingAddress_line2() {
		return mailingAddress_line2;
	}

	public void setMailingAddress_line2(String mailingAddress_line2) {
		this.mailingAddress_line2 = mailingAddress_line2.toUpperCase().trim();
	}

	public String getMailingAddress_line3() {
		return mailingAddress_line3;
	}

	public void setMailingAddress_line3(String mailingAddress_line3) {
		this.mailingAddress_line3 = mailingAddress_line3.toUpperCase().trim();
	}

	public String getMailingAddress_state() {
		return mailingAddress_state;
	}

	public void setMailingAddress_state(String mailingAddress_state) {
		this.mailingAddress_state = mailingAddress_state.toUpperCase().trim();
	}

	public String getMailingAddress_zip() {
		return mailingAddress_zip;
	}

	public void setMailingAddress_zip(String mailingAddress_zip) {
		this.mailingAddress_zip = mailingAddress_zip.toUpperCase().trim();
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getNum_pax() {
		return num_pax;
	}

	public void setNum_pax(int num_pax) {
		this.num_pax = num_pax;
	}

	public int getPax1Age() {
		return pax1Age;
	}

	public void setPax1Age(int pax1Age) {
		this.pax1Age = pax1Age;
	}

	public double getPax1Base() {
		return pax1Base;
	}

	public void setPax1Base(double pax1Base) {
		this.pax1Base = pax1Base;
	}

	public double getPax1Charge() {
		return pax1Charge;
	}

	public void setPax1Charge(double pax1Charge) {
		this.pax1Charge = pax1Charge;
	}

	public String getPax1Description() {
		return pax1Description;
	}

	public void setPax1Description(String pax1Description) {
		this.pax1Description = pax1Description.toUpperCase().trim();
	}

	public String getPax1First_name() {
		return pax1First_name;
	}

	public void setPax1First_name(String pax1First_name) {
		this.pax1First_name = pax1First_name.toUpperCase().trim();
	}

	public String getPax1Last_name() {
		return pax1Last_name;
	}

	public void setPax1Last_name(String pax1Last_name) {
		this.pax1Last_name = pax1Last_name.toUpperCase().trim();
	}

	public String getPax1Middle_name() {
		return pax1Middle_name;
	}

	public void setPax1Middle_name(String pax1Middle_name) {
		this.pax1Middle_name = pax1Middle_name.toUpperCase().trim();
	}

	public double getPax1Surcharge() {
		return pax1Surcharge;
	}

	public void setPax1Surcharge(double pax1Surcharge) {
		this.pax1Surcharge = pax1Surcharge;
	}

	public double getPax1Tax() {
		return pax1Tax;
	}

	public void setPax1Tax(double pax1Tax) {
		this.pax1Tax = pax1Tax;
	}

	public String getPax1Title() {
		return pax1Title;
	}

	public void setPax1Title(String pax1Title) {
		this.pax1Title = pax1Title.toUpperCase().trim();
	}

	public int getPax2Age() {
		return pax2Age;
	}

	public void setPax2Age(int pax2Age) {
		this.pax2Age = pax2Age;
	}

	public double getPax2Base() {
		return pax2Base;
	}

	public void setPax2Base(double pax2Base) {
		this.pax2Base = pax2Base;
	}

	public double getPax2Charge() {
		return pax2Charge;
	}

	public void setPax2Charge(double pax2Charge) {
		this.pax2Charge = pax2Charge;
	}

	public String getPax2Description() {
		return pax2Description;
	}

	public void setPax2Description(String pax2Description) {
		this.pax2Description = pax2Description.toUpperCase().trim();
	}

	public String getPax2First_name() {
		return pax2First_name;
	}

	public void setPax2First_name(String pax2First_name) {
		this.pax2First_name = pax2First_name.toUpperCase().trim();
	}

	public String getPax2Last_name() {
		return pax2Last_name;
	}

	public void setPax2Last_name(String pax2Last_name) {
		this.pax2Last_name = pax2Last_name.toUpperCase().trim();
	}

	public String getPax2Middle_name() {
		return pax2Middle_name;
	}

	public void setPax2Middle_name(String pax2Middle_name) {
		this.pax2Middle_name = pax2Middle_name.toUpperCase().trim();
	}

	public double getPax2Surcharge() {
		return pax2Surcharge;
	}

	public void setPax2Surcharge(double pax2Surcharge) {
		this.pax2Surcharge = pax2Surcharge;
	}

	public double getPax2Tax() {
		return pax2Tax;
	}

	public void setPax2Tax(double pax2Tax) {
		this.pax2Tax = pax2Tax;
	}

	public String getPax2Title() {
		return pax2Title;
	}

	public void setPax2Title(String pax2Title) {
		this.pax2Title = pax2Title.toUpperCase().trim();
	}

	public int getPax3Age() {
		return pax3Age;
	}

	public void setPax3Age(int pax3Age) {
		this.pax3Age = pax3Age;
	}

	public double getPax3Base() {
		return pax3Base;
	}

	public void setPax3Base(double pax3Base) {
		this.pax3Base = pax3Base;
	}

	public double getPax3Charge() {
		return pax3Charge;
	}

	public void setPax3Charge(double pax3Charge) {
		this.pax3Charge = pax3Charge;
	}

	public String getPax3Description() {
		return pax3Description;
	}

	public void setPax3Description(String pax3Description) {
		this.pax3Description = pax3Description.toUpperCase().trim();
	}

	public String getPax3First_name() {
		return pax3First_name;
	}

	public void setPax3First_name(String pax3First_name) {
		this.pax3First_name = pax3First_name.toUpperCase().trim();
	}

	public String getPax3Last_name() {
		return pax3Last_name;
	}

	public void setPax3Last_name(String pax3Last_name) {
		this.pax3Last_name = pax3Last_name.toUpperCase().trim();
	}

	public String getPax3Middle_name() {
		return pax3Middle_name;
	}

	public void setPax3Middle_name(String pax3Middle_name) {
		this.pax3Middle_name = pax3Middle_name.toUpperCase().trim();
	}

	public double getPax3Surcharge() {
		return pax3Surcharge;
	}

	public void setPax3Surcharge(double pax3Surcharge) {
		this.pax3Surcharge = pax3Surcharge;
	}

	public double getPax3Tax() {
		return pax3Tax;
	}

	public void setPax3Tax(double pax3Tax) {
		this.pax3Tax = pax3Tax;
	}

	public String getPax3Title() {
		return pax3Title;
	}

	public void setPax3Title(String pax3Title) {
		this.pax3Title = pax3Title.toUpperCase().trim();
	}

	public int getPax4Age() {
		return pax4Age;
	}

	public void setPax4Age(int pax4Age) {
		this.pax4Age = pax4Age;
	}

	public double getPax4Base() {
		return pax4Base;
	}

	public void setPax4Base(double pax4Base) {
		this.pax4Base = pax4Base;
	}

	public double getPax4Charge() {
		return pax4Charge;
	}

	public void setPax4Charge(double pax4Charge) {
		this.pax4Charge = pax4Charge;
	}

	public String getPax4Description() {
		return pax4Description;
	}

	public void setPax4Description(String pax4Description) {
		this.pax4Description = pax4Description.toUpperCase().trim();
	}

	public String getPax4First_name() {
		return pax4First_name;
	}

	public void setPax4First_name(String pax4First_name) {
		this.pax4First_name = pax4First_name.toUpperCase().trim();
	}

	public String getPax4Last_name() {
		return pax4Last_name;
	}

	public void setPax4Last_name(String pax4Last_name) {
		this.pax4Last_name = pax4Last_name.toUpperCase().trim();
	}

	public String getPax4Middle_name() {
		return pax4Middle_name;
	}

	public void setPax4Middle_name(String pax4Middle_name) {
		this.pax4Middle_name = pax4Middle_name.toUpperCase().trim();
	}

	public double getPax4Surcharge() {
		return pax4Surcharge;
	}

	public void setPax4Surcharge(double pax4Surcharge) {
		this.pax4Surcharge = pax4Surcharge;
	}

	public double getPax4Tax() {
		return pax4Tax;
	}

	public void setPax4Tax(double pax4Tax) {
		this.pax4Tax = pax4Tax;
	}

	public String getPax4Title() {
		return pax4Title;
	}

	public void setPax4Title(String pax4Title) {
		this.pax4Title = pax4Title;
	}

	public int getPax5Age() {
		return pax5Age;
	}

	public void setPax5Age(int pax5Age) {
		this.pax5Age = pax5Age;
	}

	public double getPax5Base() {
		return pax5Base;
	}

	public void setPax5Base(double pax5Base) {
		this.pax5Base = pax5Base;
	}

	public double getPax5Charge() {
		return pax5Charge;
	}

	public void setPax5Charge(double pax5Charge) {
		this.pax5Charge = pax5Charge;
	}

	public String getPax5Description() {
		return pax5Description.toUpperCase().trim();
	}

	public void setPax5Description(String pax5Description) {
		this.pax5Description = pax5Description.toUpperCase().trim();
	}

	public String getPax5First_name() {
		return pax5First_name;
	}

	public void setPax5First_name(String pax5First_name) {
		this.pax5First_name = pax5First_name.toUpperCase().trim();
	}

	public String getPax5Last_name() {
		return pax5Last_name;
	}

	public void setPax5Last_name(String pax5Last_name) {
		this.pax5Last_name = pax5Last_name;
	}

	public String getPax5Middle_name() {
		return pax5Middle_name;
	}

	public void setPax5Middle_name(String pax5Middle_name) {
		this.pax5Middle_name = pax5Middle_name.toUpperCase().trim();
	}

	public double getPax5Surcharge() {
		return pax5Surcharge;
	}

	public void setPax5Surcharge(double pax5Surcharge) {
		this.pax5Surcharge = pax5Surcharge;
	}

	public double getPax5Tax() {
		return pax5Tax;
	}

	public void setPax5Tax(double pax5Tax) {
		this.pax5Tax = pax5Tax;
	}

	public String getPax5Title() {
		return pax5Title;
	}

	public void setPax5Title(String pax5Title) {
		this.pax5Title = pax5Title.toUpperCase().trim();
	}

	public List getPaxNames() {
		return paxNames;
	}

	public void setPaxNames(List paxNames) {
		this.paxNames = paxNames;
	}

	public String getPcc() {
		return pcc;
	}

	public void setPcc(String pcc) {
		this.pcc = pcc.toUpperCase().trim();
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr.toUpperCase().trim();
	}

	public String getPrimary_airline() {
		return primary_airline;
	}

	public void setPrimary_airline(String primary_airline) {
		this.primary_airline = primary_airline.toUpperCase().trim();
	}

	public String getRaw_text() {
		return raw_text;
	}

	public void setRaw_text(String raw_text) {
		this.raw_text = raw_text.toUpperCase().trim();
	}

	public String getReturn_date() {
		return return_date;
	}

	public void setReturn_date(String return_date) {
		this.return_date = return_date;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getTicket_issuer() {
		return ticket_issuer;
	}

	public void setTicket_issuer(String ticket_issuer) {
		this.ticket_issuer = ticket_issuer.toUpperCase().trim();
	}

	public String getTicket_link() {
		return ticket_link;
	}

	public void setTicket_link(String ticket_link) {
		this.ticket_link = ticket_link;
	}

	public String getTicket_type() {
		return ticket_type;
	}

	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type.toUpperCase().trim();
	}

	public List getTicketingLines() {
		return ticketingLines;
	}

	public void setTicketingLines(List ticketingLines) {
		this.ticketingLines = ticketingLines;
	}

	public double getTotal_expenses() {
		return total_expenses;
	}

	public void setTotal_expenses(double total_expenses) {
		this.total_expenses = total_expenses;
	}

	public double getTotal_margin() {
		return total_margin;
	}

	public void setTotal_margin(double total_margin) {
		this.total_margin = total_margin;
	}

	public double getTotalBase() {
		return totalBase;
	}

	public void setTotalBase(double totalBase) {
		this.totalBase = totalBase;
	}

	public double getTotalCharge() {
		return totalCharge;
	}

	public void setTotalCharge(double totalCharge) {
		this.totalCharge = totalCharge;
	}

	public double getTotalSurcharge() {
		return totalSurcharge;
	}

	public void setTotalSurcharge(double totalSurcharge) {
		this.totalSurcharge = totalSurcharge;
	}

	public double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(double totalTax) {
		this.totalTax = totalTax;
	}

	public String getTracking_link() {
		return tracking_link;
	}

	public void setTracking_link(String tracking_link) {
		this.tracking_link = tracking_link;
	}

	public String getTracking_number() {
		return tracking_number;
	}

	public void setTracking_number(String tracking_number) {
		this.tracking_number = tracking_number.toUpperCase().trim();
	}

	public int getTransaction_number() {
		return transaction_number;
	}

	public void setTransaction_number(int transaction_number) {
		this.transaction_number = transaction_number;
	}

	public String getUpdate_dttm() {
		return update_dttm;
	}

	public void setUpdate_dttm(String update_dttm) {
		this.update_dttm = update_dttm;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by.toUpperCase().trim();
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

	public int getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy.toUpperCase().trim();
	}

	public String getPax1Currency() {
		return pax1Currency;
	}

	public void setPax1Currency(String pax1Currency) {
		this.pax1Currency = pax1Currency.toUpperCase().trim();
	}

	public String getPax2Currency() {
		return pax2Currency;
	}

	public void setPax2Currency(String pax2Currency) {
		this.pax2Currency = pax2Currency.toUpperCase().trim();
	}

	public String getPax3Currency() {
		return pax3Currency;
	}

	public void setPax3Currency(String pax3Currency) {
		this.pax3Currency = pax3Currency.toUpperCase().trim();
	}

	public String getPax4Currency() {
		return pax4Currency;
	}

	public void setPax4Currency(String pax4Currency) {
		this.pax4Currency = pax4Currency.toUpperCase().trim();
	}

	public String getPax5Currency() {
		return pax5Currency;
	}

	public void setPax5Currency(String pax5Currency) {
		this.pax5Currency = pax5Currency.toUpperCase().trim();
	}

	public String getTotalCurrency() {
		return totalCurrency;
	}

	public void setTotalCurrency(String totalCurrency) {
		this.totalCurrency = totalCurrency.toUpperCase().trim();
	}

	public String getLinePresent() {
		return linePresent;
	}

	public void setLinePresent(String linePresent) {
		this.linePresent = linePresent;
	}

	public List getAirlineInfoLines() {
		return airlineInfoLines;
	}

	public void setAirlineInfoLines(List airlineInfoLines) {
		this.airlineInfoLines = airlineInfoLines;
	}

	public String getSales_type() {
		return sales_type;
	}

	public void setSales_type(String sales_type) {
		this.sales_type = sales_type;
	}

	public String getIssuing_iata() {
		return issuing_iata;
	}

	public void setIssuing_iata(String issuing_iata) {
		this.issuing_iata = issuing_iata;
	}

}
