package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IEmailModel;

@JsonDeserialize(as=EmailData.class)
public interface IEmailData extends IEmailModel, IDataContainer {

}

/*       S.D.G.       */
