/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=DeleteBoxModel.class)
public interface IDeleteBoxModel {

	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	String getRootCategoryId();
	void setRootCategoryId(String rootCategoryId);
	
	
	IDeleteBoxModel deepCopy();
}




/******* S.D.G. *******/



