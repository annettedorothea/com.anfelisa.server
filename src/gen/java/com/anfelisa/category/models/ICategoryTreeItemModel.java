package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryTreeItemModel.class)
public interface ICategoryTreeItemModel {

	String getCategoryId();
	String getCategoryName();
	Integer getCategoryIndex();
	Boolean getEmpty();
	Boolean getEditable();
	java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> getChildCategories();

}

/*       S.D.G.       */
