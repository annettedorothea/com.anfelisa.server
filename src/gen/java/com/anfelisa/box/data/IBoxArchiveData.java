/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IBoxArchiveModel;

@JsonDeserialize(as=BoxArchiveData.class)
public interface IBoxArchiveData extends IBoxArchiveModel, IDataContainer {
	
	IBoxArchiveData withUserId(String userId);
	
	IBoxArchiveData withBoxId(String boxId);
	
	IBoxArchiveData withArchived(Boolean archived);
	
	
	IBoxArchiveData deepCopy();
}



/******* S.D.G. *******/



