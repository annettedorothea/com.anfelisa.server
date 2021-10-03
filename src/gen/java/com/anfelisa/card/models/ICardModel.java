/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CardModel.class)
public interface ICardModel {

	String getCardId();
	void setCardId(String cardId);
	
	String getGiven();
	void setGiven(String given);
	
	String getWanted();
	void setWanted(String wanted);
	
	String getCardAuthor();
	void setCardAuthor(String cardAuthor);
	
	Integer getCardIndex();
	void setCardIndex(Integer cardIndex);
	
	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getRootCategoryId();
	void setRootCategoryId(String rootCategoryId);
	
	Integer getPriority();
	void setPriority(Integer priority);
	
	
	ICardModel deepCopy();
}




/******* S.D.G. *******/



