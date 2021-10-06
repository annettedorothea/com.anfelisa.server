/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IBoxModel;

@JsonDeserialize(as=BoxData.class)
public interface IBoxData extends IBoxModel, IDataContainer {
	
	IBoxData withBoxId(String boxId);
	
	IBoxData withUserId(String userId);
	
	IBoxData withCategoryId(String categoryId);
	
	IBoxData withMaxInterval(Integer maxInterval);
	
	IBoxData withMaxCardsPerDay(Integer maxCardsPerDay);
	
	IBoxData withReverse(Boolean reverse);
	
	IBoxData withArchived(Boolean archived);
	
	
	IBoxData deepCopy();
}



/******* S.D.G. *******/



