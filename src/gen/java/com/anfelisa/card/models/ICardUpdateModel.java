/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CardUpdateModel.class)
public interface ICardUpdateModel {

	String getCardId();
	void setCardId(String cardId);
	
	String getGiven();
	void setGiven(String given);
	
	String getWanted();
	void setWanted(String wanted);
	
	String getUserId();
	void setUserId(String userId);
	
	
	ICardUpdateModel deepCopy();
}




/******* S.D.G. *******/



