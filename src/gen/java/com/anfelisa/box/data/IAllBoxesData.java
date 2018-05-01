package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IAllBoxesModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=AllBoxesData.class)
public interface IAllBoxesData extends IAllBoxesModel, IDataContainer {

}

/*       S.D.G.       */
