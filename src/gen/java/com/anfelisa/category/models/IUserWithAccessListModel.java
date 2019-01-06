package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserWithAccessListModel.class)
public interface IUserWithAccessListModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	java.util.List<com.anfelisa.category.models.IUserWithAccessModel> getUserList();
	void setUserList(java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList);
	

}

/*       S.D.G.       */
