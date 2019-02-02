package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class UsernameAvailableModel implements IUsernameAvailableModel {

	@NotNull
	private String username;
	
	private Boolean available = false;
	

	public UsernameAvailableModel() {
	}

	public UsernameAvailableModel(
		@JsonProperty("username") String username,
		@JsonProperty("available") Boolean available
	) {
		this.username = username;
		this.available = available;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	
	
	public List<String> equalsPrimitiveTypes(IUsernameAvailableModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUsername() == null && other.getUsername() == null) && !this.getUsername().equals(other.getUsername())) {
			differingAttributes.add("username: " + this.getUsername() + " " + other.getUsername());
		}
		if (!(this.getAvailable() == null && other.getAvailable() == null) && !this.getAvailable().equals(other.getAvailable())) {
			differingAttributes.add("available: " + this.getAvailable() + " " + other.getAvailable());
		}
		return differingAttributes;
	}
	
}

/*       S.D.G.       */
