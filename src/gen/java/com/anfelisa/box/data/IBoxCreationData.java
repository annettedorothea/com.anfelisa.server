package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxCreationData.class)
public interface IBoxCreationData extends IBoxModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
