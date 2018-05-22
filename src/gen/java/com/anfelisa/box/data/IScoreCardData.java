package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.IScheduledCardModel;
import com.anfelisa.box.models.IScoredCardModel;
import com.anfelisa.box.models.ICardQualityModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=ScoreCardData.class)
public interface IScoreCardData extends ICardModel, IScheduledCardModel, IScoredCardModel, ICardQualityModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
