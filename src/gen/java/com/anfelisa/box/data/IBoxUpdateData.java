package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxUpdateModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxUpdateData.class)
public interface IBoxUpdateData extends IBoxUpdateModel, IDataContainer {

}

/*       S.D.G.       */
