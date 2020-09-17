/********************************************************************************
 * generated by de.acegen 0.9.10
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IInitMyBoxesDataModel;

@JsonDeserialize(as=InitMyBoxesDataData.class)
public interface IInitMyBoxesDataData extends IInitMyBoxesDataModel, IDataContainer {
	
	IInitMyBoxesDataData withUserId(String userId);
	
	IInitMyBoxesDataData withTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC);
	
	IInitMyBoxesDataData withPostponeCards(java.util.List<com.anfelisa.box.models.IPostponeCardsModel> postponeCards);
	
	IInitMyBoxesDataData withOutdatedReinforceCardsIds(java.util.List<String> outdatedReinforceCardsIds);
	
	
}



/******* S.D.G. *******/



