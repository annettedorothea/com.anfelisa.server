package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.user.models.IUserRoleUpdateModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserUpdateData.class)
public interface IUserUpdateData extends IUserRoleUpdateModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
