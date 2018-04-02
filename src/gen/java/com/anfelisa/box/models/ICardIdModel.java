package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardIdModel.class)
public interface ICardIdModel {

	String getCardId();
	String getTestId();
	String getContentHash();

}

/*       S.D.G.       */
