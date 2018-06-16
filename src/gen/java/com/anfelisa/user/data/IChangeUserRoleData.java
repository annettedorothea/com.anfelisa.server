package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserIdModel;
import com.anfelisa.user.models.IRoleModel;

@JsonDeserialize(as=ChangeUserRoleData.class)
public interface IChangeUserRoleData extends IUserIdModel, IRoleModel, IDataContainer {

}

/*       S.D.G.       */
