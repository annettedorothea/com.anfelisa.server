package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryModel;

@JsonDeserialize(as=CategoryData.class)
public interface ICategoryData extends ICategoryModel, IDataContainer {

}

/*       S.D.G.       */