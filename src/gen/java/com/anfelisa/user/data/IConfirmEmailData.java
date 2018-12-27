package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IConfirmEmailModel;

@JsonDeserialize(as=ConfirmEmailData.class)
public interface IConfirmEmailData extends IConfirmEmailModel, IDataContainer {

}

/*       S.D.G.       */
