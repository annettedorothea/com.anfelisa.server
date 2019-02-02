package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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

/*       S.D.G.       */
