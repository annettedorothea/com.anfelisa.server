/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CategoryTreeModel.class)
public interface ICategoryTreeModel {

	com.anfelisa.category.models.ICategoryTreeItemModel getRootCategory();
	void setRootCategory(com.anfelisa.category.models.ICategoryTreeItemModel rootCategory);
	
	String getUserId();
	void setUserId(String userId);
	
	String getRootCategoryId();
	void setRootCategoryId(String rootCategoryId);
	
	Boolean getFilterNonScheduled();
	void setFilterNonScheduled(Boolean filterNonScheduled);
	
	Integer getPriority();
	void setPriority(Integer priority);
	
	Boolean getEditable();
	void setEditable(Boolean editable);
	
	Boolean getReverse();
	void setReverse(Boolean reverse);
	
	Boolean getReverseBoxExists();
	void setReverseBoxExists(Boolean reverseBoxExists);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	
	ICategoryTreeModel deepCopy();
}




/******* S.D.G. *******/



