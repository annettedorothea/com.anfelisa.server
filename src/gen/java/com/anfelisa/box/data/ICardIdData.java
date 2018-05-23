package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.ICardIdModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardIdData.class)
public interface ICardIdData extends ICardIdModel, IDataContainer {

}

/*       S.D.G.       */
