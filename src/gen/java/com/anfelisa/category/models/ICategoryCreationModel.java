package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryCreationModel.class)
public interface ICategoryCreationModel extends com.anfelisa.category.models.ICategoryModel,com.anfelisa.category.models.IUserAccessToCategoryModel{

	String getUsername();

}

/*       S.D.G.       */
