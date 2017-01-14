package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.ILoginLogModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=LoginData.class)
public interface ILoginData extends ILoginLogModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
