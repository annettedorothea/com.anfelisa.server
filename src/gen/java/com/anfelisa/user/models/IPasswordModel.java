package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=PasswordModel.class)
public interface IPasswordModel {

	String getPassword();

}

/*       S.D.G.       */
