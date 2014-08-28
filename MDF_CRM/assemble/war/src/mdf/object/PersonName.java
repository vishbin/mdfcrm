package mdf.object;


public class PersonName {

	String firstName;
	String middleName;
	String lastName;
	String title;
	String suffix;
	
	public String toString() {
		String str = 
			"firstName:" + firstName +
			"middleName:" + middleName +
			"lastName:" + lastName +
			"title:" + title +
			"suffix:" + suffix;
		return str;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
}
