/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ChangeUserRoleModel.class)
public interface IChangeUserRoleModel {

	String getEditedUserId();
	void setEditedUserId(String editedUserId);
	
	String getNewRole();
	void setNewRole(String newRole);
	
	String getUserId();
	void setUserId(String userId);
	
	String getRole();
	void setRole(String role);
	
	
}




/******* S.D.G. *******/



