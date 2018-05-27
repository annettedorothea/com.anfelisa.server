package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=PasswordUpdateData.class)
public interface IPasswordUpdateData extends ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
