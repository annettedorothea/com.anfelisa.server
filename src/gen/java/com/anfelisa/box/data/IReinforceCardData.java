package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IReinforceCardModel;

@JsonDeserialize(as=ReinforceCardData.class)
public interface IReinforceCardData extends IReinforceCardModel, IDataContainer {
	
	IReinforceCardData withReinforceCardId(String reinforceCardId);
	
	IReinforceCardData withScheduledCardId(String scheduledCardId);
	
	IReinforceCardData withBoxId(String boxId);
	
	IReinforceCardData withChangeDate(org.joda.time.DateTime changeDate);
	
	
}

/*       S.D.G.       */
