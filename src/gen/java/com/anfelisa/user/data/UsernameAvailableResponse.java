package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class UsernameAvailableResponse implements IUsernameAvailableResponse {
	
	private Boolean available = false;
	
	public UsernameAvailableResponse() {
	}
	
	public UsernameAvailableResponse(com.anfelisa.user.models.IUsernameAvailableModel data) {
		available = data.getAvailable();
	}
	
	@JsonProperty
	public Boolean getAvailable() {
		return this.available;
	}
	
}

/*       S.D.G.       */
