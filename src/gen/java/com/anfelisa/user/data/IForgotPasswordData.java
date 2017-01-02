package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IForgotPasswordModel;
import com.anfelisa.user.models.ILanguageModel;

@JsonDeserialize(as=ForgotPasswordData.class)
public interface IForgotPasswordData extends IForgotPasswordModel, ILanguageModel, IDataContainer {

}

/*       S.D.G.       */
