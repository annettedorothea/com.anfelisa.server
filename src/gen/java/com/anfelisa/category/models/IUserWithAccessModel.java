package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=UserWithAccessModel.class)
public interface IUserWithAccessModel {

	String getUserId();
	void setUserId(String userId);
	
	String getUsername();
	void setUsername(String username);
	
	
	List<String> equalsPrimitiveTypes(IUserWithAccessModel other);
	
}

/*       S.D.G.       */
