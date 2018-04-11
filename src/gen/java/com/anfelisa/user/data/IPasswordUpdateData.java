package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.user.models.IUserPasswordUpdateModel;

@JsonDeserialize(as=PasswordUpdateData.class)
public interface IPasswordUpdateData extends ICredentialsModel, IUserPasswordUpdateModel, IDataContainer {

}

/*       S.D.G.       */
