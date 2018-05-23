package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxIdModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=DeleteBoxData.class)
public interface IDeleteBoxData extends IBoxIdModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
