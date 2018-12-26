package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxIdModel;
import com.anfelisa.user.models.IUserIdModel;
import com.anfelisa.box.models.IPostponeCardsModel;
import com.anfelisa.box.models.ITodayModel;

@JsonDeserialize(as=PostponeCardsData.class)
public interface IPostponeCardsData extends IBoxIdModel, IUserIdModel, IPostponeCardsModel, ITodayModel, IDataContainer {

}

/*       S.D.G.       */
