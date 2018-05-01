package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryUpdateModel;

@JsonDeserialize(as=CategoryUpdateData.class)
public interface ICategoryUpdateData extends ICategoryUpdateModel, IDataContainer {

}

/*       S.D.G.       */
