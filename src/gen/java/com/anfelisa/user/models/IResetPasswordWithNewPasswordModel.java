package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ResetPasswordWithNewPasswordModel.class)
public interface IResetPasswordWithNewPasswordModel extends com.anfelisa.user.models.IResetPasswordModel{

	String getPassword();

}

/*       S.D.G.       */
