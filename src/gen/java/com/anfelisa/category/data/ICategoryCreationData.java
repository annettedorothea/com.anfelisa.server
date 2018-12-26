package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryModel;
import com.anfelisa.category.models.IUserAccessToCategoryModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=CategoryCreationData.class)
public interface ICategoryCreationData extends ICategoryModel, IUserAccessToCategoryModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
