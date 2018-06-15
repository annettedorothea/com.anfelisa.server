package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ReinforceCardModel.class)
public interface IReinforceCardModel {

	String getReinforceCardId();
	String getScheduledCardId();
	String getBoxId();
	org.joda.time.DateTime getChangeDate();

}

/*       S.D.G.       */
