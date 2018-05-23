package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.models.ICredentialsModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=RoleData.class)
public interface IRoleData extends ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
