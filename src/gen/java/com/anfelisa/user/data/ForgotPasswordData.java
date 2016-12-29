package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IForgotPasswordModel;

@SuppressWarnings("unused")
public class ForgotPasswordData implements IForgotPasswordData {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private String username;
	
	@NotNull
	private String email;
	
	@NotNull
	private String name;
	
	@NotNull
	private String prename;
	
	@NotNull
	private String language;
	
	@NotNull
	private String password;
	

	

	public ForgotPasswordData(
		@JsonProperty("username") String username,
		@JsonProperty("email") String email,
		@JsonProperty("name") String name,
		@JsonProperty("prename") String prename,
		@JsonProperty("language") String language,
		@JsonProperty("password") String password
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.username = username;
		this.email = email;
		this.name = name;
		this.prename = prename;
		this.language = language;
		this.password = password;
		this.uuid = uuid;
		this.schema = schema;
	}

	public ForgotPasswordData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ForgotPasswordData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ForgotPasswordData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ForgotPasswordData withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty
	public String getPrename() {
		return this.prename;
	}
	public void setPrename(String prename) {
		this.prename = prename;
	}
	public ForgotPasswordData withPrename(String prename) {
		this.prename = prename;
		return this;
	}
	
	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public ForgotPasswordData withLanguage(String language) {
		this.language = language;
		return this;
	}
	
	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public ForgotPasswordData withPassword(String password) {
		this.password = password;
		return this;
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
