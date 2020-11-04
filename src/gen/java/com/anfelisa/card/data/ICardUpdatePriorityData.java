/********************************************************************************
 * generated by de.acegen 1.0.2
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.ICardUpdatePriorityModel;

@JsonDeserialize(as=CardUpdatePriorityData.class)
public interface ICardUpdatePriorityData extends ICardUpdatePriorityModel, IDataContainer {
	
	ICardUpdatePriorityData withCardId(String cardId);
	
	ICardUpdatePriorityData withPriority(Integer priority);
	
	ICardUpdatePriorityData withUserId(String userId);
	
	
}



/******* S.D.G. *******/



