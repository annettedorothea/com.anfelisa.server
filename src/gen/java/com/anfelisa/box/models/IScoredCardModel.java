package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScoredCardModel.class)
public interface IScoredCardModel {

	String getScoredCardId();
	String getCardId();
	org.joda.time.DateTime getScheduledDateOfScored();
	String getBoxId();
	Integer getQuality();
	org.joda.time.DateTime getTimestamp();
	Integer getPoints();
	String getScheduledCardId();

}

/*       S.D.G.       */
