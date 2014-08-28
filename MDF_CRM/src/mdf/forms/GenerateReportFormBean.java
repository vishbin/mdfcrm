package mdf.forms;

import java.util.List;

import org.apache.struts.action.ActionForm;


public class GenerateReportFormBean  extends ActionForm{
	private ContactFormBean contactForm;
	private String actions;
	private String fromDD;
	private String fromMM;
	private String fromYYYY;
	private String fromDate;
	private String toDate;
	private String toDD;
	private String toMM;
	private String toYYYY;
	private String forMonth;
	private String totalNumofTickets;
	private String totalNumOfTicketfromAMT;
	private String totalNumOfTicketfromHYD;
	private String totalExpenditure;
	private String totalNumofItinGiven;
	private String totalNumofQuotesGiven;
	private String totalNumofCutomerscontacted;
	private String totalNumofCutomersResponded;
	private String totalNumofCutomersLost;
	private String topReasonforLosingCustomer;
	private String topAgentbyTickets;

	private String numOfCustUpdatedToday;
	private String numOfCustUpdatedYest;
	private String numOfCustAddedToday;
	private String numOfCustAddedYest;
	private String numOfCustNotUpdatedForLast3Days;

	private List custAddedList;
	private List custUpdatedList;
	private List custNotUpdatedLat3DaysList;
	private List agentStatList;
	/**
	 * @return the totalNumofTickets
	 */
	public String getTotalNumofTickets() {
		return totalNumofTickets;
	}
	/**
	 * @param totalNumofTickets the totalNumofTickets to set
	 */
	public void setTotalNumofTickets(String totalNumofTickets) {
		this.totalNumofTickets = totalNumofTickets;
	}
	/**
	 * @return the totalNumOfTicketfromAMT
	 */
	public String getTotalNumOfTicketfromAMT() {
		return totalNumOfTicketfromAMT;
	}
	/**
	 * @param totalNumOfTicketfromAMT the totalNumOfTicketfromAMT to set
	 */
	public void setTotalNumOfTicketfromAMT(String totalNumOfTicketfromAMT) {
		this.totalNumOfTicketfromAMT = totalNumOfTicketfromAMT;
	}
	/**
	 * @return the totalNumOfTicketfromHYD
	 */
	public String getTotalNumOfTicketfromHYD() {
		return totalNumOfTicketfromHYD;
	}
	/**
	 * @param totalNumOfTicketfromHYD the totalNumOfTicketfromHYD to set
	 */
	public void setTotalNumOfTicketfromHYD(String totalNumOfTicketfromHYD) {
		this.totalNumOfTicketfromHYD = totalNumOfTicketfromHYD;
	}
	/**
	 * @return the totalExpenditure
	 */
	public String getTotalExpenditure() {
		return totalExpenditure;
	}
	/**
	 * @param totalExpenditure the totalExpenditure to set
	 */
	public void setTotalExpenditure(String totalExpenditure) {
		this.totalExpenditure = totalExpenditure;
	}
	/**
	 * @return the totalNumofItinGiven
	 */
	public String getTotalNumofItinGiven() {
		return totalNumofItinGiven;
	}
	/**
	 * @param totalNumofItinGiven the totalNumofItinGiven to set
	 */
	public void setTotalNumofItinGiven(String totalNumofItinGiven) {
		this.totalNumofItinGiven = totalNumofItinGiven;
	}
	/**
	 * @return the totalNumofQuotesGiven
	 */
	public String getTotalNumofQuotesGiven() {
		return totalNumofQuotesGiven;
	}
	/**
	 * @param totalNumofQuotesGiven the totalNumofQuotesGiven to set
	 */
	public void setTotalNumofQuotesGiven(String totalNumofQuotesGiven) {
		this.totalNumofQuotesGiven = totalNumofQuotesGiven;
	}
	/**
	 * @return the totalNumofCutomerscontacted
	 */
	public String getTotalNumofCutomerscontacted() {
		return totalNumofCutomerscontacted;
	}
	/**
	 * @param totalNumofCutomerscontacted the totalNumofCutomerscontacted to set
	 */
	public void setTotalNumofCutomerscontacted(String totalNumofCutomerscontacted) {
		this.totalNumofCutomerscontacted = totalNumofCutomerscontacted;
	}
	/**
	 * @return the totalNumofCutomersResponded
	 */
	public String getTotalNumofCutomersResponded() {
		return totalNumofCutomersResponded;
	}
	/**
	 * @param totalNumofCutomersResponded the totalNumofCutomersResponded to set
	 */
	public void setTotalNumofCutomersResponded(String totalNumofCutomersResponded) {
		this.totalNumofCutomersResponded = totalNumofCutomersResponded;
	}
	/**
	 * @return the totalNumofCutomersLost
	 */
	public String getTotalNumofCutomersLost() {
		return totalNumofCutomersLost;
	}
	/**
	 * @param totalNumofCutomersLost the totalNumofCutomersLost to set
	 */
	public void setTotalNumofCutomersLost(String totalNumofCutomersLost) {
		this.totalNumofCutomersLost = totalNumofCutomersLost;
	}
	/**
	 * @return the topReasonforLosingCustomer
	 */
	public String getTopReasonforLosingCustomer() {
		return topReasonforLosingCustomer;
	}
	/**
	 * @param topReasonforLosingCustomer the topReasonforLosingCustomer to set
	 */
	public void setTopReasonforLosingCustomer(String topReasonforLosingCustomer) {
		this.topReasonforLosingCustomer = topReasonforLosingCustomer;
	}
	/**
	 * @return the topAgentbyTickets
	 */
	public String getTopAgentbyTickets() {
		return topAgentbyTickets;
	}
	/**
	 * @param topAgentbyTickets the topAgentbyTickets to set
	 */
	public void setTopAgentbyTickets(String topAgentbyTickets) {
		this.topAgentbyTickets = topAgentbyTickets;
	}



	/**
	 * @return the forMonth
	 */
	public String getForMonth() {
		return forMonth;
	}
	/**
	 * @param forMonth the forMonth to set
	 */
	public void setForMonth(String forMonth) {
		this.forMonth = forMonth;
	}
	/**
	 * @return the agentStatList
	 */
	public List getAgentStatList() {
		return agentStatList;
	}
	/**
	 * @param agentStatList the agentStatList to set
	 */
	public void setAgentStatList(List agentStatList) {
		this.agentStatList = agentStatList;
	}
	/**
	 * @return the fromDD
	 */
	public String getFromDD() {
		return fromDD;
	}
	/**
	 * @param fromDD the fromDD to set
	 */
	public void setFromDD(String fromDD) {
		this.fromDD = fromDD;
	}
	/**
	 * @return the fromMM
	 */
	public String getFromMM() {
		return fromMM;
	}
	/**
	 * @param fromMM the fromMM to set
	 */
	public void setFromMM(String fromMM) {
		this.fromMM = fromMM;
	}
	/**
	 * @return the fromYYYY
	 */
	public String getFromYYYY() {
		return fromYYYY;
	}
	/**
	 * @param fromYYYY the fromYYYY to set
	 */
	public void setFromYYYY(String fromYYYY) {
		this.fromYYYY = fromYYYY;
	}
	/**
	 * @return the toDD
	 */
	public String getToDD() {
		return toDD;
	}
	/**
	 * @param toDD the toDD to set
	 */
	public void setToDD(String toDD) {
		this.toDD = toDD;
	}
	/**
	 * @return the toMM
	 */
	public String getToMM() {
		return toMM;
	}
	/**
	 * @param toMM the toMM to set
	 */
	public void setToMM(String toMM) {
		this.toMM = toMM;
	}
	/**
	 * @return the toYYYY
	 */
	public String getToYYYY() {
		return toYYYY;
	}
	/**
	 * @param toYYYY the toYYYY to set
	 */
	public void setToYYYY(String toYYYY) {
		this.toYYYY = toYYYY;
	}
	/**
	 * @return the fromDate
	 */
	public String getFromDate() {
		if (getFromYYYY() !=null && getFromYYYY()!="" && getFromMM() !=null
				&& getFromMM()!="" && getFromDD()!=null && getFromDD() !=""){
			return getFromYYYY()+"-"+getFromMM()+"-"+getFromDD();
		}else{
			return null;
		}
	}
	/**
	 * @param fromDate the fromDate to set
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	/**
	 * @return the toDate
	 */
	public String getToDate() {
		if (getToYYYY() !=null && getToYYYY()!="" && getToMM() !=null
				&& getToMM() !="" && getToDD()!=null && getToDD()!=""){
			return getToYYYY()+"-"+getToMM()+"-"+getToDD();
		}else{
			return null;
		}

	}
	/**
	 * @param toDate the toDate to set
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	/**
	 * @return the actions
	 */
	public String getActions() {
		return actions;
	}
	/**
	 * @param actions the actions to set
	 */
	public void setActions(String actions) {
		this.actions = actions;
	}
	/**
	 * @return the numOfCustUpdatedToday
	 */
	public String getNumOfCustUpdatedToday() {
		return numOfCustUpdatedToday;
	}
	/**
	 * @param numOfCustUpdatedToday the numOfCustUpdatedToday to set
	 */
	public void setNumOfCustUpdatedToday(String numOfCustUpdatedToday) {
		this.numOfCustUpdatedToday = numOfCustUpdatedToday;
	}
	/**
	 * @return the numOfCustUpdatedYest
	 */
	public String getNumOfCustUpdatedYest() {
		return numOfCustUpdatedYest;
	}
	/**
	 * @param numOfCustUpdatedYest the numOfCustUpdatedYest to set
	 */
	public void setNumOfCustUpdatedYest(String numOfCustUpdatedYest) {
		this.numOfCustUpdatedYest = numOfCustUpdatedYest;
	}
	/**
	 * @return the numOfCustAddedToday
	 */
	public String getNumOfCustAddedToday() {
		return numOfCustAddedToday;
	}
	/**
	 * @param numOfCustAddedToday the numOfCustAddedToday to set
	 */
	public void setNumOfCustAddedToday(String numOfCustAddedToday) {
		this.numOfCustAddedToday = numOfCustAddedToday;
	}
	/**
	 * @return the numOfCustAddedYest
	 */
	public String getNumOfCustAddedYest() {
		return numOfCustAddedYest;
	}
	/**
	 * @param numOfCustAddedYest the numOfCustAddedYest to set
	 */
	public void setNumOfCustAddedYest(String numOfCustAddedYest) {
		this.numOfCustAddedYest = numOfCustAddedYest;
	}
	/**
	 * @return the numOfCustNotUpdatedForLast3Days
	 */
	public String getNumOfCustNotUpdatedForLast3Days() {
		return numOfCustNotUpdatedForLast3Days;
	}
	/**
	 * @param numOfCustNotUpdatedForLast3Days the numOfCustNotUpdatedForLast3Days to set
	 */
	public void setNumOfCustNotUpdatedForLast3Days(
			String numOfCustNotUpdatedForLast3Days) {
		this.numOfCustNotUpdatedForLast3Days = numOfCustNotUpdatedForLast3Days;
	}
	/**
	 * @return the custAddedList
	 */
	public List getCustAddedList() {
		return custAddedList;
	}
	/**
	 * @param custAddedList the custAddedList to set
	 */
	public void setCustAddedList(List custAddedList) {
		this.custAddedList = custAddedList;
	}
	/**
	 * @return the custUpdatedList
	 */
	public List getCustUpdatedList() {
		return custUpdatedList;
	}
	/**
	 * @param custUpdatedList the custUpdatedList to set
	 */
	public void setCustUpdatedList(List custUpdatedList) {
		this.custUpdatedList = custUpdatedList;
	}
	/**
	 * @return the custNotUpdatedLat3DaysList
	 */
	public List getCustNotUpdatedLat3DaysList() {
		return custNotUpdatedLat3DaysList;
	}
	/**
	 * @param custNotUpdatedLat3DaysList the custNotUpdatedLat3DaysList to set
	 */
	public void setCustNotUpdatedLat3DaysList(List custNotUpdatedLat3DaysList) {
		this.custNotUpdatedLat3DaysList = custNotUpdatedLat3DaysList;
	}
	/**
	 * @return the contactForm
	 */
	public ContactFormBean getContactForm() {
		return contactForm;
	}
	/**
	 * @param contactForm the contactForm to set
	 */
	public void setContactForm(ContactFormBean contactForm) {
		this.contactForm = contactForm;
	}




}
