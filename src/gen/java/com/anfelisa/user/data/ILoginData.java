package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ILoginLogModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=LoginData.class)
public interface ILoginData extends ILoginLogModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
