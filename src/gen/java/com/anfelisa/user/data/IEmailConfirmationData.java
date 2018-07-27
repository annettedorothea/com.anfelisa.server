package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IEmailConfirmationModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=EmailConfirmationData.class)
public interface IEmailConfirmationData extends IEmailConfirmationModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
