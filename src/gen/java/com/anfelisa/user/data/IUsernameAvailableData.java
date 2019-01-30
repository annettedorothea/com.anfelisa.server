package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUsernameAvailableModel;

@JsonDeserialize(as=UsernameAvailableData.class)
public interface IUsernameAvailableData extends IUsernameAvailableModel, IDataContainer {
	
	IUsernameAvailableData withUsername(String username);
	
	IUsernameAvailableData withAvailable(Boolean available);
	
	
}

/*       S.D.G.       */
