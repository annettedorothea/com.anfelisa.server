/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CategoryMoveModel.class)
public interface ICategoryMoveModel {

	String getMovedCategoryId();
	void setMovedCategoryId(String movedCategoryId);
	
	String getTargetCategoryId();
	void setTargetCategoryId(String targetCategoryId);
	
	com.anfelisa.category.models.ICategoryModel getMovedCategory();
	void setMovedCategory(com.anfelisa.category.models.ICategoryModel movedCategory);
	
	Integer getCategoryIndexWhereRemoved();
	void setCategoryIndexWhereRemoved(Integer categoryIndexWhereRemoved);
	
	String getParentCategoryIdWhereRemoved();
	void setParentCategoryIdWhereRemoved(String parentCategoryIdWhereRemoved);
	
	String getUserId();
	void setUserId(String userId);
	
	
	ICategoryMoveModel deepCopy();
}




/******* S.D.G. *******/



