package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxListModel;
import com.anfelisa.user.models.IUserIdModel;
import com.anfelisa.box.models.ITodayModel;

@JsonDeserialize(as=BoxListData.class)
public interface IBoxListData extends IBoxListModel, IUserIdModel, ITodayModel, IDataContainer {

}

/*       S.D.G.       */
