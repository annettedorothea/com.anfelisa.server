package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryMoveModel.class)
public interface ICategoryMoveModel {

	String getCategoryId();
	String getParentCategoryId();

}

/*       S.D.G.       */
