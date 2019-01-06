package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.IUserWithAccessListModel;

@JsonDeserialize(as=UserWithAccessListData.class)
public interface IUserWithAccessListData extends IUserWithAccessListModel, IDataContainer {
}

/*       S.D.G.       */
