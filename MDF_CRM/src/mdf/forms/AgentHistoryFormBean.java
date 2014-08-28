package mdf.forms;

import org.apache.struts.action.ActionForm;

public class AgentHistoryFormBean extends ActionForm {
	//ui fields
	private String actionn;

	private int item_id = 0;
	private int contact_id = 0;
	private int agent_id = 0;
	private String agent_name = "";
	private String old_status = "";
	private String new_status = "";
	private String old_agent = "";
	private String new_agent = "";

	private String add_dttm = "";

	public String toString() {
		String str =
			"";
		return str;
	}

	public String getActionn() {
		return actionn;
	}

	public void setActionn(String actionn) {
		this.actionn = actionn;
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
		this.agent_name = agent_name;
	}

	public int getContact_id() {
		return contact_id;
	}

	public void setContact_id(int contact_id) {
		this.contact_id = contact_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getNew_agent() {
		return new_agent;
	}

	public void setNew_agent(String new_agent) {
		this.new_agent = new_agent;
	}

	public String getNew_status() {
		return new_status;
	}

	public void setNew_status(String new_status) {
		this.new_status = new_status;
	}

	public String getOld_agent() {
		return old_agent;
	}

	public void setOld_agent(String old_agent) {
		this.old_agent = old_agent;
	}

	public String getOld_status() {
		return old_status;
	}

	public void setOld_status(String old_status) {
		this.old_status = old_status;
	}
}
