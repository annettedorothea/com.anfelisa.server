package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxListModel;
import com.anfelisa.user.models.IUsernameModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxListData.class)
public interface IBoxListData extends IBoxListModel, IUsernameModel, IDataContainer {

}

/*       S.D.G.       */
