package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.category.models.IRevokeUserModel;
import com.anfelisa.user.models.IUserIdModel;

@JsonDeserialize(as=RevokeUserData.class)
public interface IRevokeUserData extends IRevokeUserModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
