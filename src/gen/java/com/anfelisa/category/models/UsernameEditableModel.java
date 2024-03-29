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
public class UsernameEditableModel extends AbstractModel {

	private String invitedUsername;

	private Boolean editable;

	
	private Boolean frozen = false;

	public UsernameEditableModel() {
	}

	public UsernameEditableModel(
		@JsonProperty("invitedUsername") String invitedUsername,
		@JsonProperty("editable") Boolean editable
	) {
		this.invitedUsername = invitedUsername;
		this.editable = editable;
	}

	@JsonProperty
	public String getInvitedUsername() {
		return this.invitedUsername;
	}
	
	@JsonProperty
	public void setInvitedUsername(String invitedUsername) {
		if (this.frozen) {
			throw new RuntimeException("invitedUsername is frozen");
		}
		this.invitedUsername = invitedUsername;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	
	@JsonProperty
	public void setEditable(Boolean editable) {
		if (this.frozen) {
			throw new RuntimeException("editable is frozen");
		}
		this.editable = editable;
	}
	
	
	
	@Override
	public void freeze() {
		this.frozen = true;
	}

	public static UsernameEditableModel generateTestData() {
		java.util.Random random = new java.util.Random();
		UsernameEditableModel testData = new UsernameEditableModel();
		testData.setInvitedUsername(randomString(random));
		testData.setEditable(random.nextBoolean());
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



