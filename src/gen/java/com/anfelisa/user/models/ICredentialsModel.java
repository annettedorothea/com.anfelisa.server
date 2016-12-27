package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CredentialsModel.class)
public interface ICredentialsModel {

	String getUsername();
	String getRole();


}

/*       S.D.G.       */
