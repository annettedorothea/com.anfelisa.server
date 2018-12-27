package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardCreationModel.class)
public interface ICardCreationModel extends com.anfelisa.card.models.ICardModel{

	String getUserId();
	String getUsername();

}

/*       S.D.G.       */
