package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.models.IUserListModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserListData.class)
public interface IUserListData extends IUserListModel, IDataContainer {

}

/*       S.D.G.       */
