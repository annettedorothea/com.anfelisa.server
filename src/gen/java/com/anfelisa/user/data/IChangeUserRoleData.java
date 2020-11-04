/********************************************************************************
 * generated by de.acegen 1.0.1
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.user.models.IChangeUserRoleModel;

@JsonDeserialize(as=ChangeUserRoleData.class)
public interface IChangeUserRoleData extends IChangeUserRoleModel, IDataContainer {
	
	IChangeUserRoleData withEditedUserId(String editedUserId);
	
	IChangeUserRoleData withNewRole(String newRole);
	
	IChangeUserRoleData withUserId(String userId);
	
	IChangeUserRoleData withRole(String role);
	
	
}



/******* S.D.G. *******/



