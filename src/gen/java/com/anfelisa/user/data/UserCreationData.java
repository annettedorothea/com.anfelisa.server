package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserModel;

@SuppressWarnings("unused")
public class UserCreationData implements IUserModel, IDataContainer {
	
	private String uuid;
	
	@NotEmpty
	private Long id;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String prename;
	
	private String email;
	
	@NotEmpty
	private String role;
	

	public UserCreationData(
		@JsonProperty("id") Long id,
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("name") String name,
		@JsonProperty("prename") String prename,
		@JsonProperty("email") String email,
		@JsonProperty("role") String role
,		@JsonProperty("uuid") String uuid
	) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.prename = prename;
		this.email = email;
		this.role = role;
		this.uuid = uuid;
	}

	@JsonProperty
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
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
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public String getPrename() {
		return this.prename;
	}
	public void setPrename(String prename) {
		this.prename = prename;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
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

}

/*       S.D.G.       */
