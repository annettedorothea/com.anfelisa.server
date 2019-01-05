package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryMoveModel;

@JsonDeserialize(as=CategoryMoveData.class)
public interface ICategoryMoveData extends ICategoryMoveModel, IDataContainer {
}

/*       S.D.G.       */
