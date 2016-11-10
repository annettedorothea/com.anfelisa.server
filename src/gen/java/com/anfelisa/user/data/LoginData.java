package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ILoginLogModel;
import com.anfelisa.user.models.ICredentialsModel;

@SuppressWarnings("unused")
public class LoginData implements ILoginLogModel, ICredentialsModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer id;
	
	@NotNull
	private String username;
	
	@NotNull
	private DateTime date;
	
	@NotNull
	private String role;
	


	public LoginData(
		@JsonProperty("id") Integer id,
		@JsonProperty("username") String username,
		@JsonProperty("date") DateTime date,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.id = id;
		this.username = username;
		this.date = date;
		this.role = role;
		this.uuid = uuid;
		this.schema = schema;
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
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

}

/*       S.D.G.       */
