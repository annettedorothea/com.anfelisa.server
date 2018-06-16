package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxIdModel;
import com.anfelisa.box.models.INextReinforceCardModel;
import com.anfelisa.box.models.IUserIdModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=NextReinforceCardData.class)
public interface INextReinforceCardData extends IUserIdModel, INextReinforceCardModel, IBoxIdModel, IDataContainer {

}

/*       S.D.G.       */
