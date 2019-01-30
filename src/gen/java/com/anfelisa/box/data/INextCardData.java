package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.INextCardModel;

@JsonDeserialize(as=NextCardData.class)
public interface INextCardData extends INextCardModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.INextCardViewModel model);
	
	INextCardData withUserId(String userId);
	
	INextCardData withToday(org.joda.time.DateTime today);
	
	INextCardData withScheduledCardId(String scheduledCardId);
	
	INextCardData withCardId(String cardId);
	
	INextCardData withScheduledDate(org.joda.time.DateTime scheduledDate);
	
	INextCardData withLastQuality(Integer lastQuality);
	
	INextCardData withGiven(String given);
	
	INextCardData withWanted(String wanted);
	
	INextCardData withImage(String image);
	
	INextCardData withCategoryId(String categoryId);
	
	INextCardData withRootCategoryId(String rootCategoryId);
	
	INextCardData withCount(Integer count);
	
	INextCardData withScoredDate(org.joda.time.DateTime scoredDate);
	
	INextCardData withBoxId(String boxId);
	
	
}

/*       S.D.G.       */
