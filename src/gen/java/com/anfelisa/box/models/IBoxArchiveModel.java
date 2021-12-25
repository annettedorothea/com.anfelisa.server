/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=BoxArchiveModel.class)
public interface IBoxArchiveModel {

	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	Boolean getArchived();
	void setArchived(Boolean archived);
	
	
	IBoxArchiveModel deepCopy();
}




/******* S.D.G. *******/


