/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=RoleModel.class)
public interface IRoleModel {

	String getUsername();
	void setUsername(String username);
	
	String getRole();
	void setRole(String role);
	
	
	IRoleModel deepCopy();
}




/******* S.D.G. *******/



