package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IScoreModel;
import com.anfelisa.box.models.ICardInfoModel;
import com.anfelisa.box.models.ICardContentModel;
import com.anfelisa.user.models.ICredentialsModel;

@JsonDeserialize(as=CardData.class)
public interface ICardData extends ICardModel, IBoxModel, IScoreModel, ICardInfoModel, ICardContentModel, ICredentialsModel, IDataContainer {

}

/*       S.D.G.       */
