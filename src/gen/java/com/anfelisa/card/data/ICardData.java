package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardModel;

@JsonDeserialize(as=CardData.class)
public interface ICardData extends ICardModel, IDataContainer {
	
	ICardData withCardId(String cardId);
	
	ICardData withGiven(String given);
	
	ICardData withWanted(String wanted);
	
	ICardData withImage(String image);
	
	ICardData withCardAuthor(String cardAuthor);
	
	ICardData withCardIndex(Integer cardIndex);
	
	ICardData withCategoryId(String categoryId);
	
	ICardData withRootCategoryId(String rootCategoryId);
	
	
}

/*       S.D.G.       */
