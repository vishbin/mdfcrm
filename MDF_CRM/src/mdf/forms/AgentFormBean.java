package mdf.forms;

import org.apache.struts.action.ActionForm;

public class AgentFormBean extends ActionForm {
	//ui fields
	private String actionn;

	private int agent_id = 0;
	private String agent_name = "";
	private String password = "";
	private String role = "";
	private boolean active = true;
	private String office_location = "";

	private int transferred_customers = 0;
	private int failed_customers = 0;
	private int lost_customers = 0;
	private int open_customers = 0;
	private int ticketed_customers = 0;
	private int pending_itinerary = 0;
	private int pending_followup = 0;
	private int pending_docs = 0;
	private int closed_customers = 0;
	private int total_customers = 0;
	private int total_updates = 0;
	private String insert_key = "";

	private boolean deleted = false;
	private String add_dttm = "";
	private String update_dttm = "";
	private String delete_dttm = "";
	private String created_by = "";
	private String updated_by = "";

	public String toString() {
		String str =
			"agent_id:" + agent_id +
			"agent_name:" + agent_name +
			"active:" + active +
			"transferred_customers:" + transferred_customers +
			"failed_customers:" + failed_customers +
			"lost_customers:" + lost_customers +
			"open_customers:" + open_customers +
			"ticketed_customers:" + ticketed_customers +
			"closed_customers:" + closed_customers +
			"total_customers:" + total_customers +
			"total_updates:" + total_updates +
			"insert_key:" + insert_key +
			"deleted:" + deleted +
			"add_dttm:" + add_dttm +
			"update_dttm:" + update_dttm +
			"delete_dttm:" + delete_dttm +
			"created_by:" + created_by +
			"updated_by:" + updated_by;
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
	public int getClosed_customers() {
		return closed_customers;
	}
	public void setClosed_customers(int closed_customers) {
		this.closed_customers = closed_customers;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by.toUpperCase().trim();
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
		this.insert_key = insert_key.toUpperCase().trim();
	}
	public int getLost_customers() {
		return lost_customers;
	}
	public void setLost_customers(int lost_customers) {
		this.lost_customers = lost_customers;
	}
	public int getOpen_customers() {
		return open_customers;
	}
	public void setOpen_customers(int open_customers) {
		this.open_customers = open_customers;
	}
	public int getTotal_customers() {
		return total_customers;
	}
	public void setTotal_customers(int total_customers) {
		this.total_customers = total_customers;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTransferred_customers() {
		return transferred_customers;
	}
	public void setTransferred_customers(int transferred_customers) {
		this.transferred_customers = transferred_customers;
	}
	public int getTicketed_customers() {
		return ticketed_customers;
	}
	public void setTicketed_customers(int ticketed_customers) {
		this.ticketed_customers = ticketed_customers;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role.toUpperCase().trim();
	}

	public int getPending_docs() {
		return pending_docs;
	}

	public void setPending_docs(int pending_docs) {
		this.pending_docs = pending_docs;
	}

	public int getPending_followup() {
		return pending_followup;
	}

	public void setPending_followup(int pending_followup) {
		this.pending_followup = pending_followup;
	}

	public int getPending_itinerary() {
		return pending_itinerary;
	}

	public void setPending_itinerary(int pending_itinerary) {
		this.pending_itinerary = pending_itinerary;
	}

	/**
	 * @return the office_location
	 */
	public String getOffice_location() {
		return office_location;
	}

	/**
	 * @param office_location the office_location to set
	 */
	public void setOffice_location(String office_location) {
		this.office_location = office_location;
	}

	public int getFailed_customers() {
		return failed_customers;
	}

	public void setFailed_customers(int failed_customers) {
		this.failed_customers = failed_customers;
	}

	public int getTotal_updates() {
		return total_updates;
	}

	public void setTotal_updates(int total_updates) {
		this.total_updates = total_updates;
	}

}
