package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardWithCategoryNameModel;

@JsonDeserialize(as=CardWithCategoryNameData.class)
public interface ICardWithCategoryNameData extends ICardWithCategoryNameModel, IDataContainer {
	void mapFrom(com.anfelisa.card.models.ICardModel model);
	
	ICardWithCategoryNameData withCategoryName(String categoryName);
	
	ICardWithCategoryNameData withCardId(String cardId);
	
	ICardWithCategoryNameData withGiven(String given);
	
	ICardWithCategoryNameData withWanted(String wanted);
	
	ICardWithCategoryNameData withImage(String image);
	
	ICardWithCategoryNameData withCardAuthor(String cardAuthor);
	
	ICardWithCategoryNameData withCardIndex(Integer cardIndex);
	
	ICardWithCategoryNameData withCategoryId(String categoryId);
	
	ICardWithCategoryNameData withRootCategoryId(String rootCategoryId);
	
	
}

/*       S.D.G.       */
