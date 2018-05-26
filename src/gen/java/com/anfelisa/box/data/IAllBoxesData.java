package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IAllBoxesModel;

@JsonDeserialize(as=AllBoxesData.class)
public interface IAllBoxesData extends IAllBoxesModel, IDataContainer {

}

/*       S.D.G.       */
