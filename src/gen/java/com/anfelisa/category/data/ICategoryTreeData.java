/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.ICategoryTreeModel;

@JsonDeserialize(as=CategoryTreeData.class)
public interface ICategoryTreeData extends ICategoryTreeModel, IDataContainer {
	
	ICategoryTreeData withRootCategory(com.anfelisa.category.models.ICategoryTreeItemModel rootCategory);
	
	ICategoryTreeData withUserId(String userId);
	
	ICategoryTreeData withRootCategoryId(String rootCategoryId);
	
	ICategoryTreeData withFilterNonScheduled(Boolean filterNonScheduled);
	
	ICategoryTreeData withPriority(Integer priority);
	
	ICategoryTreeData withEditable(Boolean editable);
	
	ICategoryTreeData withReverse(Boolean reverse);
	
	ICategoryTreeData withReverseBoxExists(Boolean reverseBoxExists);
	
	ICategoryTreeData withBoxId(String boxId);
	
	
}



/******* S.D.G. *******/



