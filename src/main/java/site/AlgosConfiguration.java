package site;

import io.dropwizard.Configuration;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import beans.User;

public class AlgosConfiguration extends Configuration {

	@NotNull
	private User user = new User();

	@JsonProperty("user")
	public User getUser() {
		return user;
	}

}
