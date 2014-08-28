package mdf.object;



public class TicketingLine {

	String lineNumber;
	boolean voidLine;
	String airlineCode;
	String classOfService;
	String airlineName;
	String flightNumber;
	String departDate;
	String departDateOfMonth;
	String departMonth;
	String departDayOfWeek;
	String departAirport;
	String arriveAirport;
	String confirmStatus;
	int numPax;
	String departTime;
	String arriveTime;
	String arriveDate;
	String arriveDateOfMonth;
	String arriveMonth;
	String arriveDayOfWeek;
	String airlineConfirmCode;
	
	public String toString() {
		String str = 
			"lineNumber:" + lineNumber+
			"voidLine:" + voidLine+
			"airlineCode:" + airlineCode+
			"classOfService:" + classOfService+
			"airlineName:" + airlineName+
			"flightNumber:" + flightNumber+
			"departDateOfMonth:" + departDateOfMonth+
			"departMonth:" + departMonth+
			"departDayOfWeek:" + departDayOfWeek+
			"departAirport:" + departAirport+
			"arriveAirport:" + arriveAirport+
			"confirmStatus:" + confirmStatus+
			"numPax:" + numPax+
			"departTime:" + departTime+
			"arriveTime:" + arriveTime+
			"arriveDateOfMonth:" + arriveDateOfMonth+
			"arriveMonth:" + arriveMonth+
			"arriveDayOfWeek:" + arriveDayOfWeek+
			"airlineConfirmCode:" + airlineConfirmCode
			;
		return str;
	}
	
	public String getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	public boolean isVoidLine() {
		return voidLine;
	}
	public void setVoidLine(boolean voidLine) {
		this.voidLine = voidLine;
	}
	public String getAirlineCode() {
		return airlineCode;
	}
	public void setAirlineCode(String airlineCode) {
		this.airlineCode = airlineCode;
	}
	public String getAirlineName() {
		return airlineName;
	}
	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getDepartDateOfMonth() {
		return departDateOfMonth;
	}
	public void setDepartDateOfMonth(String departDateOfMonth) {
		this.departDateOfMonth = departDateOfMonth;
	}
	public String getDepartDayOfWeek() {
		return departDayOfWeek;
	}
	public void setDepartDayOfWeek(String departDayOfWeek) {
		this.departDayOfWeek = departDayOfWeek;
	}
	public String getDepartAirport() {
		return departAirport;
	}
	public void setDepartAirport(String departAirport) {
		this.departAirport = departAirport;
	}
	public String getArriveAirport() {
		return arriveAirport;
	}
	public void setArriveAirport(String arriveAirport) {
		this.arriveAirport = arriveAirport;
	}
	public String getConfirmStatus() {
		return confirmStatus;
	}
	public void setConfirmStatus(String confirmStatus) {
		this.confirmStatus = confirmStatus;
	}
	public int getNumPax() {
		return numPax;
	}
	public void setNumPax(int numPax) {
		this.numPax = numPax;
	}
	public String getDepartTime() {
		return departTime;
	}
	public void setDepartTime(String departTime) {
		this.departTime = departTime;
	}
	public String getArriveTime() {
		return arriveTime;
	}
	public void setArriveTime(String arriveTime) {
		this.arriveTime = arriveTime;
	}
	public String getArriveDateOfMonth() {
		return arriveDateOfMonth;
	}
	public void setArriveDateOfMonth(String arriveDateOfMonth) {
		this.arriveDateOfMonth = arriveDateOfMonth;
	}
	public String getArriveDayOfWeek() {
		return arriveDayOfWeek;
	}
	public void setArriveDayOfWeek(String arriveDayOfWeek) {
		this.arriveDayOfWeek = arriveDayOfWeek;
	}
	public String getAirlineConfirmCode() {
		return airlineConfirmCode;
	}
	public void setAirlineConfirmCode(String airlineConfirmCode) {
		this.airlineConfirmCode = airlineConfirmCode;
	}
	public String getClassOfService() {
		return classOfService;
	}
	public void setClassOfService(String classOfService) {
		this.classOfService = classOfService;
	}
	public String getArriveMonth() {
		return arriveMonth;
	}
	public void setArriveMonth(String arriveMonth) {
		this.arriveMonth = arriveMonth;
	}
	public String getDepartMonth() {
		return departMonth;
	}
	public void setDepartMonth(String departMonth) {
		this.departMonth = departMonth;
	}

	public String getArriveDate() {
		return arriveDate;
	}

	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}

	public String getDepartDate() {
		return departDate;
	}

}
