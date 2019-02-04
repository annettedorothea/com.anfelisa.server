package com.anfelisa.user.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=UsernameAvailableModel.class)
public interface IUsernameAvailableModel {

	String getUsername();
	void setUsername(String username);
	
	Boolean getAvailable();
	void setAvailable(Boolean available);
	
	
	List<String> equalsPrimitiveTypes(IUsernameAvailableModel other);
	
}

/*       S.D.G.       */
