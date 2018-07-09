package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryUpdateModel;
import com.anfelisa.user.models.IUserIdModel;

@JsonDeserialize(as=CategoryUpdateData.class)
public interface ICategoryUpdateData extends ICategoryUpdateModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
