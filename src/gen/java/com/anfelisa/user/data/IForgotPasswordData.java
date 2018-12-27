package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IForgotPasswordModel;

@JsonDeserialize(as=ForgotPasswordData.class)
public interface IForgotPasswordData extends IForgotPasswordModel, IDataContainer {

}

/*       S.D.G.       */
