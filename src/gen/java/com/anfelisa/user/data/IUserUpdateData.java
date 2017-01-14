package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserUpdateModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=UserUpdateData.class)
public interface IUserUpdateData extends IUserUpdateModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
