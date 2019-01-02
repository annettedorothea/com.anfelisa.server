package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IReinforceCardModel;

@JsonDeserialize(as=ReinforceCardData.class)
public interface IReinforceCardData extends IReinforceCardModel, IDataContainer {
}

/*       S.D.G.       */
