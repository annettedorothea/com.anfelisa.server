package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.INextCardViewModel;

@JsonDeserialize(as=NextCardViewData.class)
public interface INextCardViewData extends INextCardViewModel, IDataContainer {
	
	INextCardViewData withScheduledCardId(String scheduledCardId);
	
	INextCardViewData withCardId(String cardId);
	
	INextCardViewData withScheduledDate(org.joda.time.DateTime scheduledDate);
	
	INextCardViewData withLastQuality(Integer lastQuality);
	
	INextCardViewData withGiven(String given);
	
	INextCardViewData withWanted(String wanted);
	
	INextCardViewData withImage(String image);
	
	INextCardViewData withCategoryId(String categoryId);
	
	INextCardViewData withRootCategoryId(String rootCategoryId);
	
	INextCardViewData withCount(Integer count);
	
	INextCardViewData withScoredDate(org.joda.time.DateTime scoredDate);
	
	INextCardViewData withBoxId(String boxId);
	
	
}

/*       S.D.G.       */
