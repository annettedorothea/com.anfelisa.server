package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserWithAccessModel.class)
public interface IUserWithAccessModel {

	String getUserId();
	String getUsername();

}

/*       S.D.G.       */
