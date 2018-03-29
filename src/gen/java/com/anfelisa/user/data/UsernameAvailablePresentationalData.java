package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUsernameModel;
import com.anfelisa.user.models.IAvailableModel;

@SuppressWarnings("all")
public class UsernameAvailablePresentationalData implements IUsernameAvailablePresentationalData {
	
	@NotNull
	private String username;
	
	private Boolean available;
	
	
	public UsernameAvailablePresentationalData(
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
	public UsernameAvailablePresentationalData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Boolean getAvailable() {
		return this.available;
	}
	public void setAvailable(Boolean available) {
		this.available = available;
	}
	public UsernameAvailablePresentationalData withAvailable(Boolean available) {
		this.available = available;
		return this;
	}
	
}

/*       S.D.G.       */
