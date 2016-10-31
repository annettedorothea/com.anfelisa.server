package com.anfelisa.mandator.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.mandator.models.IMandatorModel;
import com.anfelisa.user.models.IEmailRegistrationModel;

@SuppressWarnings("unused")
public class MandatorCreationData implements IMandatorModel, IEmailRegistrationModel, IDataContainer {
	
	private String uuid;
	
	@NotEmpty
	private Long id;
	
	@NotEmpty
	private String mandatorId;
	
	@NotEmpty
	private String username;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String prename;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String role;
	
	@NotNull
	private Boolean emailConfirmed;
	
	private String emailConfirmationHash;
	
	private String host;
	
	private Integer port;
	
	private String locale;
	

	public MandatorCreationData(
		@JsonProperty("id") Long id,
		@JsonProperty("mandatorId") String mandatorId,
		@JsonProperty("username") String username,
		@JsonProperty("password") String password,
		@JsonProperty("name") String name,
		@JsonProperty("prename") String prename,
		@JsonProperty("email") String email,
		@JsonProperty("role") String role,
		@JsonProperty("emailConfirmed") Boolean emailConfirmed,
		@JsonProperty("emailConfirmationHash") String emailConfirmationHash,
		@JsonProperty("host") String host,
		@JsonProperty("port") Integer port,
		@JsonProperty("locale") String locale
,		@JsonProperty("uuid") String uuid
	) {
		this.id = id;
		this.mandatorId = mandatorId;
		this.username = username;
		this.password = password;
		this.name = name;
		this.prename = prename;
		this.email = email;
		this.role = role;
		this.emailConfirmed = emailConfirmed;
		this.emailConfirmationHash = emailConfirmationHash;
		this.host = host;
		this.port = port;
		this.locale = locale;
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
	public String getMandatorId() {
		return this.mandatorId;
	}
	public void setMandatorId(String mandatorId) {
		this.mandatorId = mandatorId;
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
	public Boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}
	public void setEmailConfirmed(Boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}
	
	@JsonProperty
	public String getEmailConfirmationHash() {
		return this.emailConfirmationHash;
	}
	public void setEmailConfirmationHash(String emailConfirmationHash) {
		this.emailConfirmationHash = emailConfirmationHash;
	}
	
	@JsonProperty
	public String getHost() {
		return this.host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	
	@JsonProperty
	public Integer getPort() {
		return this.port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	@JsonProperty
	public String getLocale() {
		return this.locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

}

/*       S.D.G.       */
