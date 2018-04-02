package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ReinforceCardModel.class)
public interface IReinforceCardModel {

	String getScheduledCardId();
	org.joda.time.DateTime getScheduledDate();
	Integer getLastQuality();
	org.joda.time.DateTime getTimestamp();
	com.anfelisa.box.models.ICardContentModel getCardContent();

}

/*       S.D.G.       */
