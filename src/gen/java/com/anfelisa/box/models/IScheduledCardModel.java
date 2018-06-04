package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScheduledCardModel.class)
public interface IScheduledCardModel {

	String getScheduledCardId();
	String getCardId();
	String getBoxId();
	org.joda.time.DateTime getCreatedDate();
	Float getEf();
	Integer getInterval();
	Integer getN();
	Integer getCount();
	org.joda.time.DateTime getScheduledDate();
	Integer getLastQuality();
	Integer getQuality();
	org.joda.time.DateTime getScoredDate();
	Boolean getRemoved();

}

/*       S.D.G.       */
