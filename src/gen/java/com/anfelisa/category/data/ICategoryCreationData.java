package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryCreationModel;

@JsonDeserialize(as=CategoryCreationData.class)
public interface ICategoryCreationData extends ICategoryCreationModel, IDataContainer {
	void mapFrom(com.anfelisa.category.models.ICategoryModel model);
	void mapFrom(com.anfelisa.category.models.IUserAccessToCategoryModel model);
}

/*       S.D.G.       */
