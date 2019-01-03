package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardCreationModel.class)
public interface ICardCreationModel extends com.anfelisa.card.models.ICardModel{

	String getUserId();
	void setUserId(String userId);
	
	String getUsername();
	void setUsername(String username);
	

}

/*       S.D.G.       */
