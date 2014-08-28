package mdf.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import mdf.forms.AgentDetailsFormBean;
import mdf.forms.AgentStatFormBean;
import mdf.forms.ContactDetailsFormBean;
import mdf.forms.GenerateReportFormBean;
import mdf.reports.PDF.utils.DateUtil;
import mdf.utils.Dateutils;

public class GenerateAgentStatDAO extends BaseUpdateDAO {


	// search
	public void generateStatForGivenAgent(AgentStatFormBean aAgentStatFormBean){


	}


	public void generateStatAtAGlance(GenerateReportFormBean aGenerateReportFormBean) throws Exception {
		getCustAddedToday(aGenerateReportFormBean);
		getCustNotUpdLast3Days(aGenerateReportFormBean);
		getCustUpdatedToday(aGenerateReportFormBean);


	}



	public void getCustAddedToday (GenerateReportFormBean aGenerateReportFormBean) throws Exception {

		String paramString = "";
		String orderString = "";
		boolean queryParam = false;
		try {
			paramString += " add_dttm >= '" + Dateutils.getCurrentDateString()+" 00:00:00"+"'";
			paramString += " AND ";
 			paramString += " add_dttm <= '" +Dateutils.getCurrentDateString()+" 99:99:99"+"'" ;
			paramString = " WHERE " + paramString;
			orderString = " ORDER BY " + orderString + " update_dttm DESC, contact_id DESC";
			//Fuck man I'ld be using Spring for this shit
			ContactUpdateDAO myContactUpdateDAO = new ContactUpdateDAO();
	     	List contactList = myContactUpdateDAO.getContactInfo(paramString,orderString);

	     	aGenerateReportFormBean.setCustAddedList(contactList);


		} catch (Exception ex) {
			log.error("Caught Exception: " + ex);
			throw ex;
		}

	}

	public void getCustNotUpdLast3Days (GenerateReportFormBean aGenerateReportFormBean) throws Exception {

		String paramString = "";
		String orderString = "";
		boolean queryParam = false;
		try {

			paramString +="To_days(update_dttm) - To_DAYS(add_dttm ) > 3";


//			paramString += " add_dttm >= '" + mdf.utils.DateUtil.getDate3BussDaysBeforeToday()+" 00:00:00"+"'";
//			paramString += " AND ";
// 			paramString += " update_dttm <= '" +Dateutils.getCurrentDateString()+" 99:99:99"+"'" ;
			paramString = " WHERE " + paramString;
			orderString = " ORDER BY " + orderString + " add_dttm DESC, contact_id DESC";
			//Fuck man I'ld be using Spring for this shit
			ContactUpdateDAO myContactUpdateDAO = new ContactUpdateDAO();
	     	List contactList = myContactUpdateDAO.getContactInfo(paramString,orderString);
	     	aGenerateReportFormBean.setCustNotUpdatedLat3DaysList(contactList);
		} catch (Exception ex) {
			log.error("Caught Exception: " + ex);
			throw ex;
		}

	}



	public void getCustUpdatedToday (GenerateReportFormBean aGenerateReportFormBean) throws Exception {
		String paramString = "";
		String orderString = "";
		boolean queryParam = false;
		try {
			paramString += " update_dttm >= '" + Dateutils.getCurrentDateString()+" 00:00:00"+"'";
			paramString += " AND ";
 			paramString += " update_dttm <= '" +Dateutils.getCurrentDateString()+" 99:99:99"+"'" ;
			paramString = " WHERE " + paramString;
			orderString = " ORDER BY " + orderString + " update_dttm DESC, contact_id DESC";

			//Fuck man I'ld be using Spring for this shit
			ContactUpdateDAO myContactUpdateDAO = new ContactUpdateDAO();
	     	List contactList = myContactUpdateDAO.getContactInfo(paramString,orderString);
	     	aGenerateReportFormBean.setCustUpdatedList(contactList);

		} catch (Exception ex) {
			log.error("Caught Exception: " + ex);
			throw ex;
		}

	}

	public void generateStatForToday (GenerateReportFormBean aGenerateReportFormBean) throws Exception {



		String paramString = "";
		String orderString = "";
		boolean queryParam = false;
		try {
				paramString += " update_dttm >= '" + Dateutils.getCurrentDateString()+" 00:00:00"+"'";
				paramString += " AND ";
     			paramString += " update_dttm <= '" +Dateutils.getCurrentDateString()+" 99:99:99"+"'" ;
				paramString = " WHERE " + paramString;
				orderString = " ORDER BY " + orderString + " update_dttm DESC, contact_id DESC";



			//Fuck man I'ld be using Spring for this shit
			ContactUpdateDAO myContactUpdateDAO = new ContactUpdateDAO();
	     	List contactList = myContactUpdateDAO.getContactInfo(paramString,orderString);

	     	//set total tickets for ALL
	     	findTotalNumofTickets(contactList,aGenerateReportFormBean);

	     	//set all frek'n numbers
	     	findTotalNumofTicketsForAgents(contactList,aGenerateReportFormBean);


		} catch (Exception ex) {
			log.error("Caught Exception: " + ex);
			throw ex;
		}




	}


	public void generateStatForYest (GenerateReportFormBean aGenerateReportFormBean) throws Exception {



		String paramString = "";
		String orderString = "";
		boolean queryParam = false;
		try {


			paramString += " update_dttm >= '" + mdf.utils.DateUtil.getPrevBusinessDateinyyyymmdd()+" 00:00:00"+"'";
			paramString += " AND ";
			paramString += " update_dttm <= '" +mdf.utils.DateUtil.getPrevBusinessDateinyyyymmdd()+" 99:99:99"+"'" ;
			paramString = " WHERE " + paramString;
			orderString = " ORDER BY " + orderString + " update_dttm DESC, contact_id DESC";

			//Fuck man I'ld be using Spring for this shit
			ContactUpdateDAO myContactUpdateDAO = new ContactUpdateDAO();
	     	List contactList = myContactUpdateDAO.getContactInfo(paramString,orderString);

	     	//set total tickets for ALL
	     	findTotalNumofTickets(contactList,aGenerateReportFormBean);

	     	//set all frek'n numbers
	     	findTotalNumofTicketsForAgents(contactList,aGenerateReportFormBean);


		} catch (Exception ex) {
			log.error("Caught Exception: " + ex);
			throw ex;
		}
	}

	public void generateStatForAllAgent (GenerateReportFormBean aGenerateReportFormBean) throws Exception {
		log.info("inside contactupdatedao.lookupContact");

		String paramString = "";
		String orderString = "";
		boolean queryParam = false;
		try {

			if (aGenerateReportFormBean.getFromDate() !=null) {
				if (queryParam == true) {
					paramString += " AND ";
					orderString += ",";
				}
				paramString += " update_dttm >= '" + aGenerateReportFormBean.getFromDate()+"'";

				queryParam = true;
			}
			if (aGenerateReportFormBean.getToDate() !=null) {
				if (queryParam == true) {
					paramString += " AND ";

				}
				paramString += " update_dttm <= '" + aGenerateReportFormBean.getToDate() +"'" ;

				queryParam = true;
			}
			if (queryParam == true) {
				paramString = " WHERE " + paramString;
				orderString = " ORDER BY " + orderString + " update_dttm DESC, contact_id DESC";
			}


			//Fuck man I'ld be using Spring for this shit
			ContactUpdateDAO myContactUpdateDAO = new ContactUpdateDAO();
	     	List contactList = myContactUpdateDAO.getContactInfo(paramString,orderString);

	     	//set total tickets for ALL
	     	findTotalNumofTickets(contactList,aGenerateReportFormBean);

	     	//set all frek'n numbers
	     	findTotalNumofTicketsForAgents(contactList,aGenerateReportFormBean);


		} catch (Exception ex) {
			log.error("Caught Exception: " + ex);
			throw ex;
		}

	}



	private void findTotalNumofTickets(List contactList,GenerateReportFormBean aGenerateReportFormBean) {
		// TODO Auto-generated method stub
		Iterator mycontactListIT = contactList.iterator();
		int totalNumofTickets=0;
		int totalNumofCutomersResponded=0;
		int  totalNumofItinGiven=0;
		int  totalNumofQuotesGiven=0;

		int  totalNumofCutomersLost=0;
		aGenerateReportFormBean.setTotalNumofCutomerscontacted(Integer.toString(contactList.size()));
		//get the overall stats
		while (mycontactListIT.hasNext()) {
			ContactDetailsFormBean myContactDetailsFormBean = (ContactDetailsFormBean) mycontactListIT.next();

			//for all the ticketed customer only
			if (myContactDetailsFormBean.getTicketed_by() != null && ! myContactDetailsFormBean.getTicketed_by().equalsIgnoreCase("NONE")
					&& ( myContactDetailsFormBean.getStatus_history().indexOf("TICKET ISSUED") != -1 ||  myContactDetailsFormBean.getStatus_history().indexOf("FEDEX SENT") != -1)
					) {

				totalNumofTickets++;
		}


			if (myContactDetailsFormBean.getStatus_history() !=null && myContactDetailsFormBean.getStatus_history().length() >0){
				totalNumofCutomersResponded++;
			}

				if (myContactDetailsFormBean.getStatus_history().indexOf("ITINERARY GIVEN") != -1){
					totalNumofItinGiven++;
				}

				if (myContactDetailsFormBean.getStatus_history().indexOf("FARE QUOTE GIVEN") != -1){
					totalNumofQuotesGiven++;
				}

				if (myContactDetailsFormBean.getStatus_history().indexOf("LOST") != -1){
					totalNumofCutomersLost++;
				}

		}
		aGenerateReportFormBean.setTotalNumofTickets(Integer.toString(totalNumofTickets));
		aGenerateReportFormBean.setTotalNumofCutomersResponded(Integer.toString(totalNumofCutomersResponded));
		aGenerateReportFormBean.setTotalNumofItinGiven(Integer.toString(totalNumofItinGiven));
		aGenerateReportFormBean.setTotalNumofQuotesGiven(Integer.toString(totalNumofQuotesGiven));
		aGenerateReportFormBean.setTotalNumofCutomersLost(Integer.toString(totalNumofCutomersLost));

	}


	//TODO dont cram all shit into one method ...
	private void findTotalNumofTicketsForAgents(List contactList,
			GenerateReportFormBean aGenerateReportFormBean) throws Exception {

		Iterator mycontactListIT = null;
		int totalNumOfTicketfromAMT = 0;
		int totalNumOfTicketfromHYD = 0;


		List agentStatList = new ArrayList();

		AgentUpdateDAO agentDAO = new AgentUpdateDAO();
		List agentList = agentDAO.getActiveAgentsList();
		Iterator myAgentDetailsFormBeanIT = agentList.iterator();

		//run thru all agents
		while (myAgentDetailsFormBeanIT.hasNext()) {
			int numOfTicketsByAgent = 0;
			int numofCustomersByAgent =0;
			int numofItinariesByAgent=0;
			int numofQuotesByAgent=0;
			int numofCustomerLostByAgent=0;


			AgentDetailsFormBean myAgentDetailsFormBean = (AgentDetailsFormBean) myAgentDetailsFormBeanIT.next();

			AgentStatFormBean myAgentStatFormBean = new AgentStatFormBean();
			myAgentStatFormBean.setAgentName(myAgentDetailsFormBean.getAgent_name());


			mycontactListIT = contactList.iterator();
			//run thru the customer list for each agent
			while (mycontactListIT.hasNext()) {
				ContactDetailsFormBean myContactDetailsFormBean = (ContactDetailsFormBean) mycontactListIT.next();

				//for all the ticketed customer only
				if (myContactDetailsFormBean.getTicketed_by() != null && ! myContactDetailsFormBean.getTicketed_by().equalsIgnoreCase("NONE")
						&& ( myContactDetailsFormBean.getStatus_history().indexOf("TICKET ISSUED") != -1 ||  myContactDetailsFormBean.getStatus_history().indexOf("FEDEX SENT") != -1)
						&& myContactDetailsFormBean.getTicketed_by().equalsIgnoreCase(myAgentDetailsFormBean.getAgent_name())) {
					//add to ticket by that agent
					numOfTicketsByAgent++;

					if (myAgentDetailsFormBean.getOffice_location().equalsIgnoreCase("AMT")) {
						//add to AMT OFFICE ticket COUNT
						totalNumOfTicketfromAMT++;
					} else if (myAgentDetailsFormBean.getOffice_location().equalsIgnoreCase("HYD")) {
						//use fuc'n constant add to HYD OFFICE ticket COUNT
						totalNumOfTicketfromHYD++;
					}

				}

				if(myContactDetailsFormBean.getAgent_assigned().equalsIgnoreCase(myAgentDetailsFormBean.getAgent_name())){

					numofCustomersByAgent++;


					if (myContactDetailsFormBean.getStatus_history().indexOf("ITINERARY GIVEN") != -1){
						numofItinariesByAgent++;
					}

					if (myContactDetailsFormBean.getStatus_history().indexOf("FARE QUOTE GIVEN") != -1){
						numofQuotesByAgent++;
					}

					if (myContactDetailsFormBean.getStatus_history().indexOf("LOST") != -1){
						numofCustomerLostByAgent++;
					}
				}
			}
			myAgentStatFormBean.setNumofTickets(Integer.toString(numOfTicketsByAgent));
			myAgentStatFormBean.setNumofCustomer(Integer.toString(numofCustomersByAgent));
			myAgentStatFormBean.setNumofItinaries(Integer.toString(numofItinariesByAgent));
			myAgentStatFormBean.setNumofQuotes(Integer.toString(numofQuotesByAgent));
			myAgentStatFormBean.setNumofCustomerLost(Integer.toString(numofCustomerLostByAgent));
			agentStatList.add(myAgentStatFormBean);

		}



		aGenerateReportFormBean.setAgentStatList(agentStatList);
		aGenerateReportFormBean.setTotalNumOfTicketfromAMT(Integer.toString(totalNumOfTicketfromAMT));
		aGenerateReportFormBean.setTotalNumOfTicketfromHYD(Integer.toString(totalNumOfTicketfromHYD));
	}



}
