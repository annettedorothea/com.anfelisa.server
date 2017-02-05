package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ReinforceCardListModel.class)
public interface IReinforceCardListModel {

	Integer getBoxId();
	String getBoxName();

	java.util.List<com.anfelisa.box.models.IReinforceCardModel> getList();

}

/*       S.D.G.       */
