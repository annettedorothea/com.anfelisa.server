package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduleCategoryModel.class)
public interface IScheduleCategoryModel {

	String getUserId();
	String getBoxId();
	String getCategoryId();
	java.util.List<com.anfelisa.box.models.IScheduledCardModel> getScheduledCards();

}

/*       S.D.G.       */
