package com.anfelisa.category.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CategoryTreeModel.class)
public interface ICategoryTreeModel {

	java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> getCategoryList();
	void setCategoryList(java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList);
	
	String getUserId();
	void setUserId(String userId);
	
	
	List<String> equalsPrimitiveTypes(ICategoryTreeModel other);
	
}

/*       S.D.G.       */
