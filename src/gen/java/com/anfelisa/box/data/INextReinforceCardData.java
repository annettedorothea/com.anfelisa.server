package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.INextReinforceCardModel;

@JsonDeserialize(as=NextReinforceCardData.class)
public interface INextReinforceCardData extends INextReinforceCardModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.INextReinforceCardViewModel model);
	
	INextReinforceCardData withBoxId(String boxId);
	
	INextReinforceCardData withUserId(String userId);
	
	INextReinforceCardData withReinforceCardId(String reinforceCardId);
	
	INextReinforceCardData withChangeDate(org.joda.time.DateTime changeDate);
	
	INextReinforceCardData withLastQuality(Integer lastQuality);
	
	INextReinforceCardData withGiven(String given);
	
	INextReinforceCardData withWanted(String wanted);
	
	INextReinforceCardData withImage(String image);
	
	INextReinforceCardData withCategoryId(String categoryId);
	
	
}

/*       S.D.G.       */
