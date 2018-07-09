package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxInfoModel;
import com.anfelisa.box.models.ITodayModel;
import com.anfelisa.user.models.IUserIdModel;

@JsonDeserialize(as=BoxInfoData.class)
public interface IBoxInfoData extends IBoxInfoModel, ITodayModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
