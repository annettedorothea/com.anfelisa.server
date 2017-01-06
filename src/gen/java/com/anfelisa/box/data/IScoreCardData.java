package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ICardOfBoxModel;
import com.anfelisa.box.models.ICardQualityModel;
import com.anfelisa.box.models.INowModel;

@JsonDeserialize(as=ScoreCardData.class)
public interface IScoreCardData extends ICardModel, ICardOfBoxModel, ICardQualityModel, INowModel, IDataContainer {

}

/*       S.D.G.       */
