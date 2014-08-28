package mdf.forms;

import org.apache.struts.action.ActionForm;

public class TestFormBean extends ActionForm {
	//ui fields
	private String test_name = "kaushik0";

	public String getTest_name() {
		return test_name;
	}

	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
}