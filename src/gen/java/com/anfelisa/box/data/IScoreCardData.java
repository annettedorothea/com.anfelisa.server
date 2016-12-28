package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ICardOfBoxModel;
import com.anfelisa.box.models.ICardQualityModel;

@JsonDeserialize(as=ScoreCardData.class)
public interface IScoreCardData extends ICardModel, ICardOfBoxModel, ICardQualityModel, IDataContainer {

}

/*       S.D.G.       */
