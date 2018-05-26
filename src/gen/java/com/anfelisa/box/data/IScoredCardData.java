package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScoredCardModel;

@JsonDeserialize(as=ScoredCardData.class)
public interface IScoredCardData extends IScoredCardModel, IDataContainer {

}

/*       S.D.G.       */
