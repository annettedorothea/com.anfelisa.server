/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CardUpdatePriorityModel.class)
public interface ICardUpdatePriorityModel {

	String getCardId();
	void setCardId(String cardId);
	
	Integer getPriority();
	void setPriority(Integer priority);
	
	String getUserId();
	void setUserId(String userId);
	
	
	ICardUpdatePriorityModel deepCopy();
}




/******* S.D.G. *******/



