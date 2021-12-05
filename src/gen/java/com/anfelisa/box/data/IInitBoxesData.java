/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IInitBoxesModel;

@JsonDeserialize(as=InitBoxesData.class)
public interface IInitBoxesData extends IInitBoxesModel, IDataContainer {
	
	IInitBoxesData withMinScheduledDate(java.time.LocalDateTime minScheduledDate);
	
	IInitBoxesData withBoxId(String boxId);
	
	
	IInitBoxesData deepCopy();
}



/******* S.D.G. *******/



