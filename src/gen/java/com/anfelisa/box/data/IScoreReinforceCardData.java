package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserIdModel;
import com.anfelisa.box.models.IScoreReinforceCardModel;

@JsonDeserialize(as=ScoreReinforceCardData.class)
public interface IScoreReinforceCardData extends IUserIdModel, IScoreReinforceCardModel, IDataContainer {

}

/*       S.D.G.       */
