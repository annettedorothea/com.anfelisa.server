package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;


@JsonDeserialize(as=ScoreCardData.class)
public interface IScoreCardData extends  IDataContainer {

}

/*       S.D.G.       */
