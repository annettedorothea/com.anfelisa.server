package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxInfoModel;
import com.anfelisa.box.models.ITodayModel;
import com.anfelisa.box.models.IUserIdModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxInfoData.class)
public interface IBoxInfoData extends IBoxInfoModel, ITodayModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
