package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryTreeModel;

@JsonDeserialize(as=CategoryTreeData.class)
public interface ICategoryTreeData extends ICategoryTreeModel, IDataContainer {
	
	ICategoryTreeData withCategoryList(java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList);
	
	ICategoryTreeData withUserId(String userId);
	
	
}

/*       S.D.G.       */
