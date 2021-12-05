/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IScoreReinforceCardModel;

@JsonDeserialize(as=ScoreReinforceCardData.class)
public interface IScoreReinforceCardData extends IScoreReinforceCardModel, IDataContainer {
	
	IScoreReinforceCardData withReinforceCardId(String reinforceCardId);
	
	IScoreReinforceCardData withKeep(Boolean keep);
	
	IScoreReinforceCardData withChangeDate(java.time.LocalDateTime changeDate);
	
	IScoreReinforceCardData withUserId(String userId);
	
	
	IScoreReinforceCardData deepCopy();
}



/******* S.D.G. *******/



