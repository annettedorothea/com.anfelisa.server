package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxUpdateModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxUpdateData.class)
public interface IBoxUpdateData extends IBoxUpdateModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
