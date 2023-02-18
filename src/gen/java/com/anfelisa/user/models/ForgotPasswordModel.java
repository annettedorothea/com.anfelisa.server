/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;
import de.acegen.AbstractModel;

@SuppressWarnings("all")
public class ForgotPasswordModel extends AbstractModel {

	private String language;

	private String email;

	private String username;

	private String token;

	private String userId;

	
	private Boolean frozen = false;

	public ForgotPasswordModel() {
	}

	public ForgotPasswordModel(
		@JsonProperty("language") String language,
		@JsonProperty("email") String email,
		@JsonProperty("username") String username,
		@JsonProperty("token") String token,
		@JsonProperty("userId") String userId
	) {
		this.language = language;
		this.email = email;
		this.username = username;
		this.token = token;
		this.userId = userId;
	}

	@JsonProperty
	public String getLanguage() {
		return this.language;
	}
	
	@JsonProperty
	public void setLanguage(String language) {
		if (this.frozen) {
			throw new RuntimeException("language is frozen");
		}
		this.language = language;
	}
	
	@JsonProperty
	public String getEmail() {
		return this.email;
	}
	
	@JsonProperty
	public void setEmail(String email) {
		if (this.frozen) {
			throw new RuntimeException("email is frozen");
		}
		this.email = email;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	
	@JsonProperty
	public void setUsername(String username) {
		if (this.frozen) {
			throw new RuntimeException("username is frozen");
		}
		this.username = username;
	}
	
	@JsonProperty
	public String getToken() {
		return this.token;
	}
	
	@JsonProperty
	public void setToken(String token) {
		if (this.frozen) {
			throw new RuntimeException("token is frozen");
		}
		this.token = token;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	
	@JsonProperty
	public void setUserId(String userId) {
		if (this.frozen) {
			throw new RuntimeException("userId is frozen");
		}
		this.userId = userId;
	}
	
	
	
	@Override
	public void freeze() {
		this.frozen = true;
	}

	public com.anfelisa.user.models.ForgotPasswordModel deepCopy() {
		com.anfelisa.user.models.ForgotPasswordModel copy = new ForgotPasswordModel();
		copy.setLanguage(this.getLanguage());
		copy.setEmail(this.getEmail());
		copy.setUsername(this.getUsername());
		copy.setToken(this.getToken());
		copy.setUserId(this.getUserId());
		return copy;
	}
	
	public static ForgotPasswordModel generateTestData() {
		java.util.Random random = new java.util.Random();
		ForgotPasswordModel testData = new ForgotPasswordModel();
		testData.setLanguage(randomString(random));
		testData.setEmail(randomString(random));
		testData.setUsername(randomString(random));
		testData.setToken(randomString(random));
		testData.setUserId(randomString(random));
		return testData;
	}
	
	private static String randomString(java.util.Random random) {
		String chars = "aaaaaaabcdeeeeeeeffffghiiiiiiijkllllllmmmmnnnnnnnooooooooopqrstttuuuuuuuvxyz";
		int n = random.nextInt(20) + 5;
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		String string  = sb.toString(); 
		return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
	}

}



/******* S.D.G. *******/



