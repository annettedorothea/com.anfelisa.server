package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryItemModel;

@JsonDeserialize(as=CategoryItemData.class)
public interface ICategoryItemData extends ICategoryItemModel, IDataContainer {
}

/*       S.D.G.       */
