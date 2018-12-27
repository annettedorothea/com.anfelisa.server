package com.anfelisa.user.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class UserListModel implements IUserListModel {

	private java.util.List<com.anfelisa.user.models.IUserModel> userList;
	
	private String role;
	

	public UserListModel(
		@JsonProperty("userList") java.util.List<com.anfelisa.user.models.IUserModel> userList,
		@JsonProperty("role") String role
	) {
		this.userList = userList;
		this.role = role;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.user.models.IUserModel> getUserList() {
		return this.userList;
	}
	public void setUserList(java.util.List<com.anfelisa.user.models.IUserModel> userList) {
		this.userList = userList;
	}
	
	@JsonProperty
	public String getRole() {
		return this.role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

}

/*       S.D.G.       */
