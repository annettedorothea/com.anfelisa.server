package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserModel;
import com.anfelisa.box.models.IMyBoxListModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=UserInfoData.class)
public interface IUserInfoData extends IUserModel, IMyBoxListModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
