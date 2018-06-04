package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserIdModel.class)
public interface IUserIdModel {

	String getUserId();

}

/*       S.D.G.       */
