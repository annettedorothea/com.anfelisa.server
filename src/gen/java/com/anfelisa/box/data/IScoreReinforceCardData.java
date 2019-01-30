package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScoreReinforceCardModel;

@JsonDeserialize(as=ScoreReinforceCardData.class)
public interface IScoreReinforceCardData extends IScoreReinforceCardModel, IDataContainer {
	
	IScoreReinforceCardData withReinforceCardId(String reinforceCardId);
	
	IScoreReinforceCardData withQuality(Integer quality);
	
	IScoreReinforceCardData withChangeDate(org.joda.time.DateTime changeDate);
	
	IScoreReinforceCardData withUserId(String userId);
	
	
}

/*       S.D.G.       */
