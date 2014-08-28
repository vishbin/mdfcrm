package mdf.forms;

public class AirlineInfoFormBean {
	String ui_name;
	String ui_code;
	String ui_phone;
	
	int airline_id;
	String airlineCode;
	String airlineName;
	String airlineConfirmCode;
	String airlinePhone;
	
	public String toString() {
		String str = 
			"airline_id:" + airline_id+
			"airlineCode:" + airlineCode+
			"airlineName:" + airlineName+
			"airlineConfirmCode:" + airlineConfirmCode+
			"airlinePhone:" + airlinePhone
			;
		return str;
	}

	public String getAirlineCode() {
		return airlineCode;
	}

	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}

	public String getAirlineConfirmCode() {
		return airlineConfirmCode;
	}

	public void setAirlineConfirmCode(String airlineConfirmCode) {
		this.airlineConfirmCode = airlineConfirmCode;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getAirlinePhone() {
		return airlinePhone;
	}

	public void setAirlinePhone(String airlinePhone) {
		this.airlinePhone = airlinePhone;
	}

	public int getAirline_id() {
		return airline_id;
	}

	public void setAirline_id(int airline_id) {
		this.airline_id = airline_id;
	}

	public String getUi_code() {
		return ui_code;
	}

	public void setUi_code(String ui_code) {
		this.ui_code = ui_code;
	}

	public String getUi_name() {
		return ui_name;
	}

	public void setUi_name(String ui_name) {
		this.ui_name = ui_name;
	}

	public String getUi_phone() {
		return ui_phone;
	}

	public void setUi_phone(String ui_phone) {
		this.ui_phone = ui_phone;
	}
	
	public boolean equals (Object obj) {
		if (!(obj instanceof AirlineInfoFormBean)) {
			return false;
		}
		if (this.airline_id == ((AirlineInfoFormBean)obj).airline_id
				&& this.airlineCode.equals(((AirlineInfoFormBean)obj).airlineCode)
				&& this.airlineName.equals(((AirlineInfoFormBean)obj).airlineName)
				&& this.airlineConfirmCode.equals(((AirlineInfoFormBean)obj).airlineConfirmCode))
			return true;
		else return false;
	}

	public int hashCode () {
		return 1;
	}
}
