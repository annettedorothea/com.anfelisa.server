package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryTreeModel;

@JsonDeserialize(as=CategoryTreeData.class)
public interface ICategoryTreeData extends ICategoryTreeModel, IDataContainer {
}

/*       S.D.G.       */
