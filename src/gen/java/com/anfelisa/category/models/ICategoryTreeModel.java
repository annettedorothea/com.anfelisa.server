package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryTreeModel.class)
public interface ICategoryTreeModel {

	java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> getCategoryList();
	String getUserId();

}

/*       S.D.G.       */
