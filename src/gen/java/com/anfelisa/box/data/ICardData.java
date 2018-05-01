package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.ICardContentModel;
import com.anfelisa.box.models.ICardInfoModel;
import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.IDaysBehindModel;
import com.anfelisa.box.models.IScoreModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardData.class)
public interface ICardData extends ICardModel, IBoxModel, IScoreModel, ICardInfoModel, ICardContentModel, ICredentialsModel, IDaysBehindModel, IDataContainer {

}

/*       S.D.G.       */
