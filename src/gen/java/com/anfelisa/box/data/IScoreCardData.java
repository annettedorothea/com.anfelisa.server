package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IScoreCardModel;
import com.anfelisa.box.models.IUserIdModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScoreCardData.class)
public interface IScoreCardData extends IUserIdModel, IScoreCardModel, IDataContainer {

}

/*       S.D.G.       */
