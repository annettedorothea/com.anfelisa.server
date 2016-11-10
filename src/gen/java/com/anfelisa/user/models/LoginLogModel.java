package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

@SuppressWarnings("unused")
public class LoginLogModel implements ILoginLogModel {

	@NotNull
	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private DateTime date;
	

	public LoginLogModel(
		@JsonProperty("id") Integer id,
		@JsonProperty("username") String username,
		@JsonProperty("date") DateTime date
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
	public DateTime getDate() {
		return this.date;
	}
	public void setDate(DateTime date) {
		this.date = date;
	}
	

}

/*       S.D.G.       */
