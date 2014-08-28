package mdf.forms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mdf.object.PersonName;
import mdf.object.TicketingLine;

import org.apache.struts.action.ActionForm;

public class TicketFormBean extends ActionForm {
	
	private String actionn = "add";

	private int ticket_id = 0;
	private String pnr = "";
	private String ticket_number = "";
	private String ticket_type = "";
	private int num_pax = 0;
	private String link = "";
	private String buffer = "";
	private String ticket_issuer = "";
	private String agent_name = "";
	private int agent_id = 0;
	private Date issue_date;
	private Date depart_date;
	private String comments;
	private double total_charge =0;
	private double tax =0;
	private double surcharge =0;
	private double penalty =0;
	private String formOfPayment = "";
	private String cardType = "";
	private String cardNumber = "";
	private String mailingAddress_line1 = "";
	private String mailingAddress_line2 = "";
	private String mailingAddress_line3 = "";
	private String mailingAddress_city = "";
	private String mailingAddress_state = "";
	private String mailingAddress_zip = "";
	private String mailingAddress_country = "";
	private String billingAddress_line1 = "";
	private String billingAddress_line2 = "";
	private String billingAddress_line3 = "";
	private String billingAddress_city = "";
	private String billingAddress_state = "";
	private String billingAddress_zip = "";
	private String billingAddress_country = "";
	private List ticketingLines;
	private List paxNames;
	
	//
	private String insert_key = "";
	private int contact_id = 0;
	private boolean deleted = false;
	private String call_type = "";
	private String user = "";
	private String notes = "";

	public String toString() {
		String str = 
			"actionn:" + actionn + 
			"ticket_id:" + ticket_id + 
			"pnr:" + pnr + 
			"ticket_number:" + ticket_number + 
			"ticket_type:" + ticket_type + 
			"num_pax:" + num_pax + 
			"link:" + link + 
			"buffer:" + buffer + 
			"ticket_issuer:" + ticket_issuer + 
			"agent_name:" + agent_name + 
			"agent_id:" + agent_id + 
			"issue_date:" + issue_date + 
			"depart_date:" + depart_date + 
			"comments:" + comments + 
			"total_charge:" + total_charge + 
			"tax:" + tax + 
			"surcharge:" + surcharge + 
			"penalty:" + penalty + 
			"formOfPayment:" + formOfPayment + 
			"cardType:" + cardType + 
			"cardNumber:" + cardNumber + 
			"mailingAddress_line1:" + mailingAddress_line1 + 
			"mailingAddress_line2:" + mailingAddress_line2 + 
			"mailingAddress_line3:" + mailingAddress_line3 + 
			"mailingAddress_city:" + mailingAddress_city + 
			"mailingAddress_state:" + mailingAddress_state + 
			"mailingAddress_zip:" + mailingAddress_zip + 
			"mailingAddress_country:" + mailingAddress_country + 
			"billingAddress_line1:" + billingAddress_line1 + 
			"billingAddress_line2:" + billingAddress_line2 + 
			"billingAddress_line3:" + billingAddress_line3 + 
			"billingAddress_city:" + billingAddress_city + 
			"billingAddress_state:" + billingAddress_state + 
			"billingAddress_zip:" + billingAddress_zip + 
			"billingAddress_country:" + billingAddress_country + 
			"insert_key:" + insert_key + 
			"contact_id:" + contact_id + 
			"deleted:" + deleted + 
			"call_type:" + call_type + 
			"user:" + user + 
			"notes:" + notes;
		return str;
	}

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
			String departDate,
			String departDayOfWeek,
			String departAirport,
			String arriveAirport,
			String confirmStatus,
			int numPax,
			String departTime,
			String arriveTime,
			String arriveDate,
			String arriveDayOfWeek,
			String airlineConfirmCode) {
		
		TicketingLine ticketingLine = new TicketingLine();
		ticketingLine.setAirlineCode(airlineCode);
		ticketingLine.setAirlineConfirmCode(airlineConfirmCode);
		ticketingLine.setAirlineName(airlineName);
		ticketingLine.setArriveAirport(arriveAirport);
		ticketingLine.setArriveDate(arriveDate);
		ticketingLine.setArriveDayOfWeek(arriveDayOfWeek);
		ticketingLine.setArriveTime(arriveTime);
		ticketingLine.setConfirmStatus(confirmStatus);
		ticketingLine.setDepartAirport(departAirport);
		ticketingLine.setDepartDate(departDate);
		ticketingLine.setDepartDayOfWeek(departDayOfWeek);
		ticketingLine.setDepartTime(departTime);
		ticketingLine.setFlightNumber(flightNumber);
		ticketingLine.setLineNumber(lineNumber);
		ticketingLine.setNumPax(numPax);
		ticketingLine.setVoidLine(voidLine);
		
		return ticketingLine;
	}
	
	public String getActionn() {
		return actionn;
	}

	public void setActionn(String actionn) {
		this.actionn = actionn.toUpperCase().trim();
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr.toUpperCase().trim();
	}

	public String getTicket_number() {
		return ticket_number;
	}

	public void setTicket_number(String ticket_number) {
		this.ticket_number = ticket_number.toUpperCase().trim();
	}

	public String getTicket_type() {
		return ticket_type;
	}

	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type.toUpperCase().trim();
	}

	public int getNum_pax() {
		return num_pax;
	}

	public void setNum_pax(int num_pax) {
		this.num_pax = num_pax;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link.toUpperCase().trim();
	}

	public String getBuffer() {
		return buffer;
	}

	public void setBuffer(String buffer) {
		this.buffer = buffer.toUpperCase().trim();
	}

	public String getTicket_issuer() {
		return ticket_issuer;
	}

	public void setTicket_issuer(String ticket_issuer) {
		this.ticket_issuer = ticket_issuer.toUpperCase().trim();
	}

	public String getAgent_name() {
		return agent_name;
	}

	public void setAgent_name(String agent_name) {
		this.agent_name = agent_name.toUpperCase().trim();
	}

	public int getAgent_id() {
		return agent_id;
	}

	public void setAgent_id(int agent_id) {
		this.agent_id = agent_id;
	}

	public Date getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(Date issue_date) {
		this.issue_date = issue_date;
	}

	public Date getDepart_date() {
		return depart_date;
	}

	public void setDepart_date(Date depart_date) {
		this.depart_date = depart_date;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments.toUpperCase().trim();
	}

	public double getTotal_charge() {
		return total_charge;
	}

	public void setTotal_charge(double total_charge) {
		this.total_charge = total_charge;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getSurcharge() {
		return surcharge;
	}

	public void setSurcharge(double surcharge) {
		this.surcharge = surcharge;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public String getFormOfPayment() {
		return formOfPayment;
	}

	public void setFormOfPayment(String formOfPayment) {
		this.formOfPayment = formOfPayment.toUpperCase().trim();
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType.toUpperCase().trim();
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber.toUpperCase().trim();
	}

	public String getMailingAddress_line1() {
		return mailingAddress_line1;
	}

	public void setMailingAddress_line1(String mailingAddress_line1) {
		this.mailingAddress_line1 = mailingAddress_line1.toUpperCase().trim();
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

	public String getMailingAddress_city() {
		return mailingAddress_city;
	}

	public void setMailingAddress_city(String mailingAddress_city) {
		this.mailingAddress_city = mailingAddress_city.toUpperCase().trim();
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

	public String getMailingAddress_country() {
		return mailingAddress_country;
	}

	public void setMailingAddress_country(String mailingAddress_country) {
		this.mailingAddress_country = mailingAddress_country.toUpperCase().trim();
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
		this.billingAddress_line2 = billingAddress_line2.toUpperCase().trim();
	}

	public String getBillingAddress_line3() {
		return billingAddress_line3;
	}

	public void setBillingAddress_line3(String billingAddress_line3) {
		this.billingAddress_line3 = billingAddress_line3.toUpperCase().trim();
	}

	public String getBillingAddress_city() {
		return billingAddress_city;
	}

	public void setBillingAddress_city(String billingAddress_city) {
		this.billingAddress_city = billingAddress_city.toUpperCase().trim();
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

	public String getBillingAddress_country() {
		return billingAddress_country;
	}

	public void setBillingAddress_country(String billingAddress_country) {
		this.billingAddress_country = billingAddress_country.toUpperCase().trim();
	}

	public String getInsert_key() {
		return insert_key;
	}

	public void setInsert_key(String insert_key) {
		this.insert_key = insert_key.toUpperCase().trim();
	}

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public String getCall_type() {
		return call_type;
	}

	public void setCall_type(String call_type) {
		this.call_type = call_type.toUpperCase().trim();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user.toUpperCase().trim();
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes.toUpperCase().trim();
	}

}
