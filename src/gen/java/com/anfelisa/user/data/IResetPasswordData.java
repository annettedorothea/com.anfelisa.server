package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.models.IPasswordModel;
import com.anfelisa.user.models.IResetPasswordModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ResetPasswordData.class)
public interface IResetPasswordData extends IResetPasswordModel, IPasswordModel, IDataContainer {

}

/*       S.D.G.       */
