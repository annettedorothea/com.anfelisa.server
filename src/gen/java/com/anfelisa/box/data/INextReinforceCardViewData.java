package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.INextReinforceCardViewModel;

@JsonDeserialize(as=NextReinforceCardViewData.class)
public interface INextReinforceCardViewData extends INextReinforceCardViewModel, IDataContainer {
	
	INextReinforceCardViewData withReinforceCardId(String reinforceCardId);
	
	INextReinforceCardViewData withChangeDate(org.joda.time.DateTime changeDate);
	
	INextReinforceCardViewData withLastQuality(Integer lastQuality);
	
	INextReinforceCardViewData withGiven(String given);
	
	INextReinforceCardViewData withWanted(String wanted);
	
	INextReinforceCardViewData withImage(String image);
	
	INextReinforceCardViewData withCategoryId(String categoryId);
	
	
}

/*       S.D.G.       */
