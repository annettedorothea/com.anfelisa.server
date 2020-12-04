/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.INextCardViewModel;

@JsonDeserialize(as=NextCardViewData.class)
public interface INextCardViewData extends INextCardViewModel, IDataContainer {
	
	INextCardViewData withScheduledCardId(String scheduledCardId);
	
	INextCardViewData withReinforceCardId(String reinforceCardId);
	
	INextCardViewData withCardId(String cardId);
	
	INextCardViewData withScheduledDate(java.time.LocalDateTime scheduledDate);
	
	INextCardViewData withLastQuality(Integer lastQuality);
	
	INextCardViewData withGiven(String given);
	
	INextCardViewData withWanted(String wanted);
	
	INextCardViewData withImage(String image);
	
	INextCardViewData withCategoryId(String categoryId);
	
	INextCardViewData withRootCategoryId(String rootCategoryId);
	
	INextCardViewData withCount(Integer count);
	
	INextCardViewData withScoredDate(java.time.LocalDateTime scoredDate);
	
	
}



/******* S.D.G. *******/



