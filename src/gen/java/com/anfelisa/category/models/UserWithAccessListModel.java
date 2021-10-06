/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class UserWithAccessListModel implements IUserWithAccessListModel {

	private String categoryId;

	private java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList;


	public UserWithAccessListModel() {
	}

	public UserWithAccessListModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userList") java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList
	) {
		this.categoryId = categoryId;
		this.userList = userList;
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.IUserWithAccessModel> getUserList() {
		return this.userList;
	}
	public void setUserList(java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList) {
		this.userList = userList;
	}
	

	public IUserWithAccessListModel deepCopy() {
		IUserWithAccessListModel copy = new UserWithAccessListModel();
		copy.setCategoryId(this.getCategoryId());
		List<com.anfelisa.category.models.IUserWithAccessModel> userListCopy = new ArrayList<com.anfelisa.category.models.IUserWithAccessModel>();
		for(com.anfelisa.category.models.IUserWithAccessModel item: this.getUserList()) {
			userListCopy.add(item.deepCopy());
		}
		copy.setUserList(userListCopy);
		return copy;
	}

}



/******* S.D.G. *******/



