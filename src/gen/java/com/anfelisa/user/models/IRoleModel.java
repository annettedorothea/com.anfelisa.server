package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=RoleModel.class)
public interface IRoleModel {

	String getUsername();
	void setUsername(String username);
	
	String getRole();
	void setRole(String role);
	
	
}

/*       S.D.G.       */
