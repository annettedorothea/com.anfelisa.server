package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IReinforceCardListModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ReinforceCardListData.class)
public interface IReinforceCardListData extends IReinforceCardListModel, ICredentialsModel, IBoxModel, IDataContainer {

}

/*       S.D.G.       */
