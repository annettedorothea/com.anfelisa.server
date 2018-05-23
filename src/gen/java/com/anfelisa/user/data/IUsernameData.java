package com.anfelisa.user.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.user.models.IUsernameModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UsernameData.class)
public interface IUsernameData extends IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
