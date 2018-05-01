package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.models.IUserModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserData.class)
public interface IUserData extends IUserModel, IDataContainer {

}

/*       S.D.G.       */
