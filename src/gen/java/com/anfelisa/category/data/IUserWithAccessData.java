/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.IUserWithAccessModel;

@JsonDeserialize(as=UserWithAccessData.class)
public interface IUserWithAccessData extends IUserWithAccessModel, IDataContainer {
	
	IUserWithAccessData withUserId(String userId);
	
	IUserWithAccessData withUsername(String username);
	
	IUserWithAccessData withEditable(Boolean editable);
	
	
}



/******* S.D.G. *******/



