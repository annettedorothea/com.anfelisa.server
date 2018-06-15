package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.models.IAvailableModel;
import com.anfelisa.user.models.IUsernameModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UsernameAvailableData.class)
public interface IUsernameAvailableData extends IUsernameModel, IAvailableModel, IDataContainer {

}

/*       S.D.G.       */
