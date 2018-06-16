package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.INextCardModel;
import com.anfelisa.box.models.ITodayModel;
import com.anfelisa.box.models.IUserIdModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=NextCardData.class)
public interface INextCardData extends INextCardModel, ITodayModel, IUserIdModel, IDataContainer {

}

/*       S.D.G.       */
