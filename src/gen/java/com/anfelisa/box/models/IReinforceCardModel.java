package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ReinforceCardModel.class)
public interface IReinforceCardModel {

	String getReinforceCardId();
	void setReinforceCardId(String reinforceCardId);
	
	String getScheduledCardId();
	void setScheduledCardId(String scheduledCardId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	org.joda.time.DateTime getChangeDate();
	void setChangeDate(org.joda.time.DateTime changeDate);
	
	
}

/*       S.D.G.       */
