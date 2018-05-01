package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserIdModel.class)
public interface IUserIdModel {

	String getUserId();

}

/*       S.D.G.       */
