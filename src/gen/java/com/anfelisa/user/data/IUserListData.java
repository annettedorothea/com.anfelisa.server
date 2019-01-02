package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserListModel;

@JsonDeserialize(as=UserListData.class)
public interface IUserListData extends IUserListModel, IDataContainer {
}

/*       S.D.G.       */
