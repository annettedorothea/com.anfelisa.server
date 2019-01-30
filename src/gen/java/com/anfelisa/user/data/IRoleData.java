package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IRoleModel;

@JsonDeserialize(as=RoleData.class)
public interface IRoleData extends IRoleModel, IDataContainer {
	
	IRoleData withUsername(String username);
	
	IRoleData withRole(String role);
	
	
}

/*       S.D.G.       */
