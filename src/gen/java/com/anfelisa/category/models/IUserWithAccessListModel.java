/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=UserWithAccessListModel.class)
public interface IUserWithAccessListModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	java.util.List<com.anfelisa.category.models.IUserWithAccessModel> getUserList();
	void setUserList(java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList);
	
	
}




/******* S.D.G. *******/



