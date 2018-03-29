package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UsernameModel.class)
public interface IUsernameModel {

	String getUsername();

}

/*       S.D.G.       */
