/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class GetAllUsersResponse implements IGetAllUsersResponse {
	
	private java.util.List<com.anfelisa.user.models.IUserModel> userList;
	
	public GetAllUsersResponse() {
	}
	
	public GetAllUsersResponse(com.anfelisa.user.models.IUserListModel data) {
		userList = data.getUserList();
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.user.models.IUserModel> getUserList() {
		return this.userList;
	}
	
}



/******* S.D.G. *******/



