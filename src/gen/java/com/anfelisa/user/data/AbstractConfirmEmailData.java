package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.user.models.IConfirmEmailModel;
import com.anfelisa.user.models.IEmailConfirmationModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractConfirmEmailData extends AbstractData implements IConfirmEmailData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractConfirmEmailData.class);
	
	private String username;
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	

	public AbstractConfirmEmailData(
		@JsonProperty("username") String username,
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.username = username;
		this.token = token;
		this.userId = userId;
	}

	public AbstractConfirmEmailData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public IConfirmEmailData withUsername(String username) {
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
	public IConfirmEmailData withToken(String token) {
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
	public IConfirmEmailData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.user.models.IEmailConfirmationModel model) {
		this.token = model.getToken();
		this.userId = model.getUserId();
	}
	
	public List<String> equalsPrimitiveTypes(IConfirmEmailModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUsername() == null && other.getUsername() == null) && !this.getUsername().equals(other.getUsername())) {
			differingAttributes.add("username: " + this.getUsername() + " " + other.getUsername());
		}
		return differingAttributes;
	}
	
	public List<String> equalsPrimitiveTypes(IEmailConfirmationModel other) {
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
