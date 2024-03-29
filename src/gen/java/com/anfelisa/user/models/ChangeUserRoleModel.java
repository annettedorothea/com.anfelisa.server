/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;
import de.acegen.AbstractModel;

@SuppressWarnings("unused")
public class ChangeUserRoleModel extends AbstractModel {

	private String editedUserId;

	private String newRole;

	private String userId;

	private String role;

	
	private Boolean frozen = false;

	public ChangeUserRoleModel() {
	}

	public ChangeUserRoleModel(
		@JsonProperty("editedUserId") String editedUserId,
		@JsonProperty("newRole") String newRole,
		@JsonProperty("userId") String userId,
		@JsonProperty("role") String role
	) {
		this.editedUserId = editedUserId;
		this.newRole = newRole;
		this.userId = userId;
		this.role = role;
	}

	@JsonProperty
	public String getEditedUserId() {
		return this.editedUserId;
	}
	
	@JsonProperty
	public void setEditedUserId(String editedUserId) {
		if (this.frozen) {
			throw new RuntimeException("editedUserId is frozen");
		}
		this.editedUserId = editedUserId;
	}
	
	@JsonProperty
	public String getNewRole() {
		return this.newRole;
	}
	
	@JsonProperty
	public void setNewRole(String newRole) {
		if (this.frozen) {
			throw new RuntimeException("newRole is frozen");
		}
		this.newRole = newRole;
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
	public String getRole() {
		return this.role;
	}
	
	@JsonProperty
	public void setRole(String role) {
		if (this.frozen) {
			throw new RuntimeException("role is frozen");
		}
		this.role = role;
	}
	
	
	
	@Override
	public void freeze() {
		this.frozen = true;
	}

	public static ChangeUserRoleModel generateTestData() {
		java.util.Random random = new java.util.Random();
		ChangeUserRoleModel testData = new ChangeUserRoleModel();
		testData.setEditedUserId(randomString(random));
		testData.setNewRole(randomString(random));
		testData.setUserId(randomString(random));
		testData.setRole(randomString(random));
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



