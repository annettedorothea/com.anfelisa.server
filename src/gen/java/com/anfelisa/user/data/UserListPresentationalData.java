package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserListModel;

@SuppressWarnings("all")
public class UserListPresentationalData implements IUserListPresentationalData {
	
	private java.util.List<com.anfelisa.user.models.IUserModel> userList;
	
	
	public UserListPresentationalData(
		@JsonProperty("userList") java.util.List<com.anfelisa.user.models.IUserModel> userList
	) {
		this.userList = userList;
		
	}

	@JsonProperty
	public java.util.List<com.anfelisa.user.models.IUserModel> getUserList() {
		return this.userList;
	}
	public void setUserList(java.util.List<com.anfelisa.user.models.IUserModel> userList) {
		this.userList = userList;
	}
	public UserListPresentationalData withUserList(java.util.List<com.anfelisa.user.models.IUserModel> userList) {
		this.userList = userList;
		return this;
	}
	
}

/*       S.D.G.       */
