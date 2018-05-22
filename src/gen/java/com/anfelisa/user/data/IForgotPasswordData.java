package com.anfelisa.user.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IResetPasswordModel;
import com.anfelisa.user.models.ILanguageModel;
import com.anfelisa.user.models.IEmailModel;
import com.anfelisa.user.models.IUsernameModel;

@JsonDeserialize(as=ForgotPasswordData.class)
public interface IForgotPasswordData extends IResetPasswordModel, ILanguageModel, IEmailModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
