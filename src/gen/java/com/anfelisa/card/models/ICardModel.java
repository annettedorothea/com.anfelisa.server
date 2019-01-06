package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardModel.class)
public interface ICardModel {

	String getCardId();
	void setCardId(String cardId);
	
	String getGiven();
	void setGiven(String given);
	
	String getWanted();
	void setWanted(String wanted);
	
	String getImage();
	void setImage(String image);
	
	String getCardAuthor();
	void setCardAuthor(String cardAuthor);
	
	Integer getCardIndex();
	void setCardIndex(Integer cardIndex);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getRootCategoryId();
	void setRootCategoryId(String rootCategoryId);
	

}

/*       S.D.G.       */
