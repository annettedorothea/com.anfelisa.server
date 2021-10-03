/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.ICategoryChangeOrderModel;

@JsonDeserialize(as=CategoryChangeOrderData.class)
public interface ICategoryChangeOrderData extends ICategoryChangeOrderModel, IDataContainer {
	
	ICategoryChangeOrderData withMovedCategoryId(String movedCategoryId);
	
	ICategoryChangeOrderData withTargetCategoryId(String targetCategoryId);
	
	ICategoryChangeOrderData withUserId(String userId);
	
	ICategoryChangeOrderData withUpdatedIndices(java.util.List<com.anfelisa.category.models.ICategoryModel> updatedIndices);
	
	
	ICategoryChangeOrderData deepCopy();
}



/******* S.D.G. *******/



