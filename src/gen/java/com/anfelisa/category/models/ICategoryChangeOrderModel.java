/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CategoryChangeOrderModel.class)
public interface ICategoryChangeOrderModel {

	String getMovedCategoryId();
	void setMovedCategoryId(String movedCategoryId);
	
	String getTargetCategoryId();
	void setTargetCategoryId(String targetCategoryId);
	
	String getUserId();
	void setUserId(String userId);
	
	java.util.List<com.anfelisa.category.models.ICategoryModel> getUpdatedIndices();
	void setUpdatedIndices(java.util.List<com.anfelisa.category.models.ICategoryModel> updatedIndices);
	
	
	ICategoryChangeOrderModel deepCopy();
}




/******* S.D.G. *******/



