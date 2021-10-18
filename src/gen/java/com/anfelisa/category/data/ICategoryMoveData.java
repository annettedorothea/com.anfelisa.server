/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.ICategoryMoveModel;

@JsonDeserialize(as=CategoryMoveData.class)
public interface ICategoryMoveData extends ICategoryMoveModel, IDataContainer {
	
	ICategoryMoveData withMovedCategoryId(String movedCategoryId);
	
	ICategoryMoveData withTargetCategoryId(String targetCategoryId);
	
	ICategoryMoveData withMovedCategory(com.anfelisa.category.models.ICategoryModel movedCategory);
	
	ICategoryMoveData withCategoryIndexWhereRemoved(Integer categoryIndexWhereRemoved);
	
	ICategoryMoveData withParentCategoryIdWhereRemoved(String parentCategoryIdWhereRemoved);
	
	ICategoryMoveData withUserId(String userId);
	
	
	ICategoryMoveData deepCopy();
}



/******* S.D.G. *******/



