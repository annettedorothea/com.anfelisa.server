package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryTreeItemModel;

@JsonDeserialize(as=CategoryTreeItemData.class)
public interface ICategoryTreeItemData extends ICategoryTreeItemModel, IDataContainer {

}

/*       S.D.G.       */
