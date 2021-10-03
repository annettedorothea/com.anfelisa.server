/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.ICategoryDeleteModel;

@JsonDeserialize(as=CategoryDeleteData.class)
public interface ICategoryDeleteData extends ICategoryDeleteModel, IDataContainer {
	
	ICategoryDeleteData withCategoryId(String categoryId);
	
	ICategoryDeleteData withCategoryIndex(Integer categoryIndex);
	
	ICategoryDeleteData withParentCategoryId(String parentCategoryId);
	
	ICategoryDeleteData withUserId(String userId);
	
	
	ICategoryDeleteData deepCopy();
}



/******* S.D.G. *******/



