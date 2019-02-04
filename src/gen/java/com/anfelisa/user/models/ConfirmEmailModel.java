package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ConfirmEmailModel implements IConfirmEmailModel {

	private String username;
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	

	public ConfirmEmailModel() {
	}

	public ConfirmEmailModel(
		@JsonProperty("username") String username,
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
	) {
		this.username = username;
		this.token = token;
		this.userId = userId;
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
