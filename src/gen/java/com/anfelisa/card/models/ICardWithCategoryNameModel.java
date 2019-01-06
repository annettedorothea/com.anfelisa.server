package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardWithCategoryNameModel.class)
public interface ICardWithCategoryNameModel extends com.anfelisa.card.models.ICardModel{

	String getCategoryName();
	void setCategoryName(String categoryName);
	

}

/*       S.D.G.       */
