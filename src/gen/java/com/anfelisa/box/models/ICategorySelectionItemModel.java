package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategorySelectionItemModel.class)
public interface ICategorySelectionItemModel {

	String getCategoryId();
	String getCategoryName();
	Integer getCategoryIndex();

}

/*       S.D.G.       */
