/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IDeleteBoxModel;

@JsonDeserialize(as=DeleteBoxData.class)
public interface IDeleteBoxData extends IDeleteBoxModel, IDataContainer {
	
	IDeleteBoxData withUserId(String userId);
	
	IDeleteBoxData withBoxId(String boxId);
	
	IDeleteBoxData withReverseBoxId(String reverseBoxId);
	
	IDeleteBoxData withRootCategoryId(String rootCategoryId);
	
	
	IDeleteBoxData deepCopy();
}



/******* S.D.G. *******/



