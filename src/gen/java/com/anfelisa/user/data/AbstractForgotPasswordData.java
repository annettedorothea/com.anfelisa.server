package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractForgotPasswordData extends AbstractData implements IForgotPasswordData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractForgotPasswordData.class);
	
	@NotNull
	private String language;
	
	@NotNull
	private String email;
	
	@NotNull
	private String username;
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	

	public AbstractForgotPasswordData(
		@JsonProperty("language") String language,
		@JsonProperty("email") String email,
		@JsonProperty("username") String username,
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.language = language;
		this.email = email;
		this.username = username;
		this.token = token;
		this.userId = userId;
	}

	public AbstractForgotPasswordData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public void mapFrom(com.anfelisa.user.models.IResetPasswordModel model) {
		this.token = model.getToken();
		this.userId = model.getUserId();
	}
}

/*       S.D.G.       */
