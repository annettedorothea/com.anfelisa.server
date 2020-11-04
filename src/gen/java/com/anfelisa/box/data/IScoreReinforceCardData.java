/********************************************************************************
 * generated by de.acegen 1.0.2
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IScoreReinforceCardModel;

@JsonDeserialize(as=ScoreReinforceCardData.class)
public interface IScoreReinforceCardData extends IScoreReinforceCardModel, IDataContainer {
	
	IScoreReinforceCardData withReinforceCardId(String reinforceCardId);
	
	IScoreReinforceCardData withScoredCardQuality(Integer scoredCardQuality);
	
	IScoreReinforceCardData withChangeDate(java.time.LocalDateTime changeDate);
	
	IScoreReinforceCardData withUserId(String userId);
	
	
}



/******* S.D.G. *******/



