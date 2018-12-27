package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryTreeRootItemModel;

@JsonDeserialize(as=CategoryTreeRootItemData.class)
public interface ICategoryTreeRootItemData extends ICategoryTreeRootItemModel, IDataContainer {

}

/*       S.D.G.       */
