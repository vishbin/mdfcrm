package mdf.forms;

import org.apache.struts.action.ActionForm;


public class AgentStatFormBean extends ActionForm {


	private String agentName;
	private String numofCustomer;
	private String numofItinaries;
	private String numofQuotes;
	private String numofTickets;
	private String numofCustomerLost;
	/**
	 * @return the agentName
	 */
	public String getAgentName() {
		return agentName;
	}
	/**
	 * @param agentName the agentName to set
	 */
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	/**
	 * @return the numofCustomer
	 */
	public String getNumofCustomer() {
		return numofCustomer;
	}
	/**
	 * @param numofCustomer the numofCustomer to set
	 */
	public void setNumofCustomer(String numofCustomer) {
		this.numofCustomer = numofCustomer;
	}
	/**
	 * @return the numofItinaries
	 */
	public String getNumofItinaries() {
		return numofItinaries;
	}
	/**
	 * @param numofItinaries the numofItinaries to set
	 */
	public void setNumofItinaries(String numofItinaries) {
		this.numofItinaries = numofItinaries;
	}
	/**
	 * @return the numofQuotes
	 */
	public String getNumofQuotes() {
		return numofQuotes;
	}
	/**
	 * @param numofQuotes the numofQuotes to set
	 */
	public void setNumofQuotes(String numofQuotes) {
		this.numofQuotes = numofQuotes;
	}
	/**
	 * @return the numofTickets
	 */
	public String getNumofTickets() {
		return numofTickets;
	}
	/**
	 * @param numofTickets the numofTickets to set
	 */
	public void setNumofTickets(String numofTickets) {
		this.numofTickets = numofTickets;
	}
	/**
	 * @return the numofCustomerLost
	 */
	public String getNumofCustomerLost() {
		return numofCustomerLost;
	}
	/**
	 * @param numofCustomerLost the numofCustomerLost to set
	 */
	public void setNumofCustomerLost(String numofCustomerLost) {
		this.numofCustomerLost = numofCustomerLost;
	}

}
