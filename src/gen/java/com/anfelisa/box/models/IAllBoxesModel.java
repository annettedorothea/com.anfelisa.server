package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=AllBoxesModel.class)
public interface IAllBoxesModel {


	java.util.List<com.anfelisa.box.models.IBoxModel> getBoxList();

}

/*       S.D.G.       */
