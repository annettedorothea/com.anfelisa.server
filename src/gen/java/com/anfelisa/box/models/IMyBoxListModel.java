package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=MyBoxListModel.class)
public interface IMyBoxListModel {


	java.util.List<com.anfelisa.box.models.IBoxModel> getBoxList();

}

/*       S.D.G.       */
