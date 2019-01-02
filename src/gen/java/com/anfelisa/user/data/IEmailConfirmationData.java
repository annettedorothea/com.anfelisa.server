package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IEmailConfirmationModel;

@JsonDeserialize(as=EmailConfirmationData.class)
public interface IEmailConfirmationData extends IEmailConfirmationModel, IDataContainer {
}

/*       S.D.G.       */
