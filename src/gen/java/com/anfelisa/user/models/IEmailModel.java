package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=EmailModel.class)
public interface IEmailModel {

	String getEmail();

}

/*       S.D.G.       */
