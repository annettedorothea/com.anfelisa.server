package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.ICategoryItemModel;
import com.anfelisa.user.models.IUserIdModel;

@JsonDeserialize(as=CategoryTreeItemData.class)
public interface ICategoryTreeItemData extends ICategoryItemModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
