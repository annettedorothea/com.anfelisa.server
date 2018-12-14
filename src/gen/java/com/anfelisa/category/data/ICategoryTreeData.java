package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryTreeModel;
import com.anfelisa.user.models.IUserIdModel;

@JsonDeserialize(as=CategoryTreeData.class)
public interface ICategoryTreeData extends ICategoryTreeModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
