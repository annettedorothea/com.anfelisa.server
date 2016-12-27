package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxListModel.class)
public interface IBoxListModel {


	java.util.List<com.anfelisa.box.models.IBoxInfoModel> getBoxList();

}

/*       S.D.G.       */
