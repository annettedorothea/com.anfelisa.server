package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.ICardQualityModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.IScoredCardModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ScoreCardData.class)
public interface IScoreCardData extends ICardModel, IScheduledCardModel, IScoredCardModel, ICardQualityModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
