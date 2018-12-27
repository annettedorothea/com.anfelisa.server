package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScoreReinforceCardModel.class)
public interface IScoreReinforceCardModel {

	String getReinforceCardId();
	Integer getQuality();
	org.joda.time.DateTime getChangeDate();
	String getUserId();

}

/*       S.D.G.       */
