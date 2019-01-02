package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryDeleteModel;

@JsonDeserialize(as=CategoryDeleteData.class)
public interface ICategoryDeleteData extends ICategoryDeleteModel, IDataContainer {
}

/*       S.D.G.       */
