/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IBoxSettingsWrapperModel;

@JsonDeserialize(as=BoxSettingsWrapperData.class)
public interface IBoxSettingsWrapperData extends IBoxSettingsWrapperModel, IDataContainer {
	
	IBoxSettingsWrapperData withUserId(String userId);
	
	IBoxSettingsWrapperData withBoxId(String boxId);
	
	IBoxSettingsWrapperData withBoxSettings(com.anfelisa.box.models.IBoxSettingsModel boxSettings);
	
	
	IBoxSettingsWrapperData deepCopy();
}



/******* S.D.G. *******/



