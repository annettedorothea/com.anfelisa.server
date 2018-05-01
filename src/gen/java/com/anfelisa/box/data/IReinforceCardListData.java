package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IReinforceCardListModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.box.models.IBoxModel;

@JsonDeserialize(as=ReinforceCardListData.class)
public interface IReinforceCardListData extends IReinforceCardListModel, ICredentialsModel, IBoxModel, IDataContainer {

}

/*       S.D.G.       */
