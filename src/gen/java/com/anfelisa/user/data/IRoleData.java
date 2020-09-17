/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.user.models.IRoleModel;

@JsonDeserialize(as=RoleData.class)
public interface IRoleData extends IRoleModel, IDataContainer {
	
	IRoleData withUsername(String username);
	
	IRoleData withRole(String role);
	
	
}



/******* S.D.G. *******/



