package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUsernameAndPasswordModel;

@JsonDeserialize(as=PasswordUpdateData.class)
public interface IPasswordUpdateData extends IUsernameAndPasswordModel, IDataContainer {

}

/*       S.D.G.       */
