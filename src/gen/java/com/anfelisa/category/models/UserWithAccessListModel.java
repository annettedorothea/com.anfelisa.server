package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

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
	
	
	public List<String> equalsPrimitiveTypes(IUserWithAccessListModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		return differingAttributes;
	}
	
}

/*       S.D.G.       */
