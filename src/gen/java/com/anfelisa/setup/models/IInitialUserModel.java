package com.anfelisa.setup.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=InitialUserModel.class)
public interface IInitialUserModel {

	String getUsername();
	String getPassword();
	String getName();
	String getPrename();
	String getEmail();
	String getRole();
	Boolean getEmailConfirmed();


}

/*       S.D.G.       */
