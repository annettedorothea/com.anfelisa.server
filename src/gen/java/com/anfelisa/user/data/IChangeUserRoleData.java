package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IChangeUserRoleModel;

@JsonDeserialize(as=ChangeUserRoleData.class)
public interface IChangeUserRoleData extends IChangeUserRoleModel, IDataContainer {

}

/*       S.D.G.       */
