package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IFillBoxModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=FillBoxData.class)
public interface IFillBoxData extends IFillBoxModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
