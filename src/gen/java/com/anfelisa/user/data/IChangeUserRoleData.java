package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.models.IRoleModel;
import com.anfelisa.user.models.IUserIdModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ChangeUserRoleData.class)
public interface IChangeUserRoleData extends IUserIdModel, IRoleModel, IDataContainer {

}

/*       S.D.G.       */
