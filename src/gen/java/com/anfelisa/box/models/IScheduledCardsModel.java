package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduledCardsModel.class)
public interface IScheduledCardsModel {

	java.util.List<com.anfelisa.box.models.IScheduledCardModel> getNewScheduledCards();
	java.util.List<String> getExistingScheduledCardIds();
	java.util.List<String> getCardIds();
	org.joda.time.DateTime getScheduledDate();

}

/*       S.D.G.       */
