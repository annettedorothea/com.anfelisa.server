package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxModel;

@JsonDeserialize(as=BoxData.class)
public interface IBoxData extends IBoxModel, IDataContainer {
}

/*       S.D.G.       */
