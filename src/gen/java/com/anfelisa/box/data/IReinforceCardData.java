/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IReinforceCardModel;

@JsonDeserialize(as=ReinforceCardData.class)
public interface IReinforceCardData extends IReinforceCardModel, IDataContainer {
	
	IReinforceCardData withReinforceCardId(String reinforceCardId);
	
	IReinforceCardData withScheduledCardId(String scheduledCardId);
	
	IReinforceCardData withBoxId(String boxId);
	
	IReinforceCardData withChangeDate(java.time.LocalDateTime changeDate);
	
	
}



/******* S.D.G. *******/



