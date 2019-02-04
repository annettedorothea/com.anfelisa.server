package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.user.models.IForgotPasswordModel;
import com.anfelisa.user.models.IResetPasswordModel;

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
	public IForgotPasswordData withLanguage(String language) {
		this.language = language;
		return this;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public IForgotPasswordData withEmail(String email) {
		this.email = email;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public IForgotPasswordData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public IForgotPasswordData withToken(String token) {
		this.token = token;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IForgotPasswordData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.user.models.IResetPasswordModel model) {
		this.token = model.getToken();
		this.userId = model.getUserId();
	}
	
	public List<String> equalsPrimitiveTypes(IForgotPasswordModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getLanguage() == null && other.getLanguage() == null) && !this.getLanguage().equals(other.getLanguage())) {
			differingAttributes.add("language: " + this.getLanguage() + " " + other.getLanguage());
		}
		if (!(this.getEmail() == null && other.getEmail() == null) && !this.getEmail().equals(other.getEmail())) {
			differingAttributes.add("email: " + this.getEmail() + " " + other.getEmail());
		}
		if (!(this.getUsername() == null && other.getUsername() == null) && !this.getUsername().equals(other.getUsername())) {
			differingAttributes.add("username: " + this.getUsername() + " " + other.getUsername());
		}
		return differingAttributes;
	}
	
	public List<String> equalsPrimitiveTypes(IResetPasswordModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getToken() == null && other.getToken() == null) && !this.getToken().equals(other.getToken())) {
			differingAttributes.add("token: " + this.getToken() + " " + other.getToken());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
