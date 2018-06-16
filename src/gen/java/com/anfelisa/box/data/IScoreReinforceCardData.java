package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IScoreReinforceCardModel;
import com.anfelisa.box.models.IUserIdModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScoreReinforceCardData.class)
public interface IScoreReinforceCardData extends IUserIdModel, IScoreReinforceCardModel, IDataContainer {

}

/*       S.D.G.       */
