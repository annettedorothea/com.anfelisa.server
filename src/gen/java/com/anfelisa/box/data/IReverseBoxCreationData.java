/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IReverseBoxCreationModel;

@JsonDeserialize(as=ReverseBoxCreationData.class)
public interface IReverseBoxCreationData extends IReverseBoxCreationModel, IDataContainer {
	
	IReverseBoxCreationData withBoxId(String boxId);
	
	IReverseBoxCreationData withUsername(String username);
	
	
	IReverseBoxCreationData deepCopy();
}



/******* S.D.G. *******/



