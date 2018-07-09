package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryDeleteModel;
import com.anfelisa.user.models.IUserIdModel;

@JsonDeserialize(as=CategoryDeleteData.class)
public interface ICategoryDeleteData extends ICategoryDeleteModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
