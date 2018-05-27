package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.user.models.IDeleteUserModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=DeleteUserData.class)
public interface IDeleteUserData extends ICredentialsModel, IDeleteUserModel, IDataContainer {

}

/*       S.D.G.       */
