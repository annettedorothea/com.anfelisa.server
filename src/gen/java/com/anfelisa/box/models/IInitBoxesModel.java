/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=InitBoxesModel.class)
public interface IInitBoxesModel {

	java.time.LocalDateTime getMinScheduledDate();
	void setMinScheduledDate(java.time.LocalDateTime minScheduledDate);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	
	IInitBoxesModel deepCopy();
}




/******* S.D.G. *******/



