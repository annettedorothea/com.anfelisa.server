package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardUpdateModel.class)
public interface ICardUpdateModel {

	String getCardId();
	void setCardId(String cardId);
	
	String getGiven();
	void setGiven(String given);
	
	String getWanted();
	void setWanted(String wanted);
	
	String getImage();
	void setImage(String image);
	
	String getUserId();
	void setUserId(String userId);
	
	
}

/*       S.D.G.       */
