/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CardWithCategoryNameModel.class)
public interface ICardWithCategoryNameModel extends com.anfelisa.card.models.ICardModel{

	String getCategoryName();
	void setCategoryName(String categoryName);
	
	
	ICardWithCategoryNameModel deepCopy();
}




/******* S.D.G. *******/



