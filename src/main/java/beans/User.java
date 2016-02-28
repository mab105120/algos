package beans;

import com.fasterxml.jackson.annotation.JsonProperty;


public class User {

	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;

	public User() {
		// default constructor for jackson
	}

	public User(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

}
