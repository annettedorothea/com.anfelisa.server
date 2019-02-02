package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ResetPasswordWithNewPasswordModel implements IResetPasswordWithNewPasswordModel {

	@NotNull
	private String password;
	
	@NotNull
	private String token;
	
	@NotNull
	private String userId;
	

	public ResetPasswordWithNewPasswordModel() {
	}

	public ResetPasswordWithNewPasswordModel(
		@JsonProperty("password") String password,
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
	) {
		this.password = password;
		this.token = token;
		this.userId = userId;
	}

	@JsonProperty
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	
	
	public List<String> equalsPrimitiveTypes(IResetPasswordWithNewPasswordModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getPassword() == null && other.getPassword() == null) && !this.getPassword().equals(other.getPassword())) {
			differingAttributes.add("password: " + this.getPassword() + " " + other.getPassword());
		}
		return differingAttributes;
	}
	
}

/*       S.D.G.       */
