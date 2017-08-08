package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUsernameModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=ChangeUserRoleData.class)
public interface IChangeUserRoleData extends IUsernameModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
