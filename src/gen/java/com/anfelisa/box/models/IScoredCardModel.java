package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScoredCardModel.class)
public interface IScoredCardModel {

	Integer getScoredCardId();
	Integer getCardId();
	org.joda.time.DateTime getScheduledDateOfScored();
	Integer getBoxId();
	Integer getQuality();
	org.joda.time.DateTime getTimestamp();
	Integer getPoints();
	Integer getScheduledCardId();


}

/*       S.D.G.       */
