package com.anfelisa.box.data;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.box.models.IBoxListModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxListData.class)
public interface IBoxListData extends IBoxListModel, IDataContainer {

}

/*       S.D.G.       */
