/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=BoxCreationModel.class)
public interface IBoxCreationModel extends com.anfelisa.category.models.ICategoryModel,com.anfelisa.category.models.IUserAccessToCategoryModel,com.anfelisa.box.models.IBoxModel{

	String getUsername();
	void setUsername(String username);
	
	
	IBoxCreationModel deepCopy();
}




/******* S.D.G. *******/



