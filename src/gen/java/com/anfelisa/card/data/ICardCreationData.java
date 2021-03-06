/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.ICardCreationModel;

@JsonDeserialize(as=CardCreationData.class)
public interface ICardCreationData extends ICardCreationModel, IDataContainer {
	void mapFrom(com.anfelisa.card.models.ICardModel model);
	
	ICardCreationData withUserId(String userId);
	
	ICardCreationData withUsername(String username);
	
	ICardCreationData withCardId(String cardId);
	
	ICardCreationData withGiven(String given);
	
	ICardCreationData withWanted(String wanted);
	
	ICardCreationData withImage(String image);
	
	ICardCreationData withCardAuthor(String cardAuthor);
	
	ICardCreationData withCardIndex(Integer cardIndex);
	
	ICardCreationData withCategoryId(String categoryId);
	
	ICardCreationData withRootCategoryId(String rootCategoryId);
	
	ICardCreationData withPriority(Integer priority);
	
	
}



/******* S.D.G. *******/



