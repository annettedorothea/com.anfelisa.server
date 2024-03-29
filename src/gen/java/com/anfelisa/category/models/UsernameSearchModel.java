/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;
import de.acegen.AbstractModel;

@SuppressWarnings("unused")
public class UsernameSearchModel extends AbstractModel {

	private String usernameSearchString;

	private String userId;

	private String categoryId;

	private java.util.List<String> usernames;

	
	private Boolean frozen = false;

	public UsernameSearchModel() {
	}

	public UsernameSearchModel(
		@JsonProperty("usernameSearchString") String usernameSearchString,
		@JsonProperty("userId") String userId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("usernames") java.util.List<String> usernames
	) {
		this.usernameSearchString = usernameSearchString;
		this.userId = userId;
		this.categoryId = categoryId;
		this.usernames = usernames;
	}

	@JsonProperty
	public String getUsernameSearchString() {
		return this.usernameSearchString;
	}
	
	@JsonProperty
	public void setUsernameSearchString(String usernameSearchString) {
		if (this.frozen) {
			throw new RuntimeException("usernameSearchString is frozen");
		}
		this.usernameSearchString = usernameSearchString;
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
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	
	@JsonProperty
	public void setCategoryId(String categoryId) {
		if (this.frozen) {
			throw new RuntimeException("categoryId is frozen");
		}
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public java.util.List<String> getUsernames() {
		return this.usernames;
	}
	
	@JsonProperty
	public void setUsernames(java.util.List<String> usernames) {
		if (this.frozen) {
			throw new RuntimeException("usernames is frozen");
		}
		this.usernames = usernames;
	}
	
	
	
	@Override
	public void freeze() {
		this.frozen = true;
	}

	public static UsernameSearchModel generateTestData() {
		java.util.Random random = new java.util.Random();
		int n;
		UsernameSearchModel testData = new UsernameSearchModel();
		testData.setUsernameSearchString(randomString(random));
		testData.setUserId(randomString(random));
		testData.setCategoryId(randomString(random));
		java.util.List<String> usernamesList = new java.util.ArrayList<String>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			usernamesList.add(randomString(random));
		}
		testData.setUsernames(usernamesList);
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



