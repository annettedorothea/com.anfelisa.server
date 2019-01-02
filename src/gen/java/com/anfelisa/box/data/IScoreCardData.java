package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScoreCardModel;

@JsonDeserialize(as=ScoreCardData.class)
public interface IScoreCardData extends IScoreCardModel, IDataContainer {
}

/*       S.D.G.       */
