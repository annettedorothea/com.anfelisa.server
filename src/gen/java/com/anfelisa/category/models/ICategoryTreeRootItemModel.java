package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryTreeRootItemModel.class)
public interface ICategoryTreeRootItemModel {

	String getCategoryId();
	String getCategoryName();
	Integer getCategoryIndex();
	Boolean getEmpty();
	Boolean getEditable();
	Boolean getHasBox();
	java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> getChildCategories();

}

/*       S.D.G.       */
