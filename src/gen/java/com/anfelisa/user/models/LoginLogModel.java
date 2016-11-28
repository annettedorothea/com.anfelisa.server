package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class LoginLogModel implements ILoginLogModel {

	@NotNull
	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private org.joda.time.DateTime date;
	


	public LoginLogModel(
		@JsonProperty("id") Integer id,
		@JsonProperty("username") String username,
		@JsonProperty("date") org.joda.time.DateTime date
	) {
		this.id = id;
		this.username = username;
		this.date = date;
	}

	@JsonProperty
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getDate() {
		return this.date;
	}
	public void setDate(org.joda.time.DateTime date) {
		this.date = date;
	}
	


}

/*       S.D.G.       */
