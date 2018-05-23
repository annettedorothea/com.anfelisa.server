package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryDeleteModel.class)
public interface ICategoryDeleteModel {

	String getCategoryId();
	Integer getCategoryIndex();
	String getParentCategoryId();

}

/*       S.D.G.       */
