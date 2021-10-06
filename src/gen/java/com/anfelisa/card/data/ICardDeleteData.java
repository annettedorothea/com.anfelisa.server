/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.ICardDeleteModel;

@JsonDeserialize(as=CardDeleteData.class)
public interface ICardDeleteData extends ICardDeleteModel, IDataContainer {
	
	ICardDeleteData withCardId(String cardId);
	
	ICardDeleteData withCardIndex(Integer cardIndex);
	
	ICardDeleteData withCategoryId(String categoryId);
	
	ICardDeleteData withUserId(String userId);
	
	
	ICardDeleteData deepCopy();
}



/******* S.D.G. *******/



