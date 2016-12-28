package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardOfBoxModel.class)
public interface ICardOfBoxModel {

	Integer getCardOfBoxId();
	Integer getCardId();
	Float getEf();
	Integer getInterval();
	Integer getN();
	Integer getCount();
	org.joda.time.DateTime getDate();
	Integer getBoxId();
	Integer getQuality();
	org.joda.time.DateTime getTimestamp();
	Integer getPoints();


}

/*       S.D.G.       */
