/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class UserInfoModel implements IUserInfoModel {

	private String username;


	public UserInfoModel() {
	}

	public UserInfoModel(
		@JsonProperty("username") String username
	) {
		this.username = username;
	}

	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

	public IUserInfoModel deepCopy() {
		IUserInfoModel copy = new UserInfoModel();
		copy.setUsername(this.getUsername());
		return copy;
	}

}



/******* S.D.G. *******/



