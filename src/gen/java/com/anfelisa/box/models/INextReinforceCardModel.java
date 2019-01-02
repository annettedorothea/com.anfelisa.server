package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=NextReinforceCardModel.class)
public interface INextReinforceCardModel extends com.anfelisa.box.models.INextReinforceCardViewModel{

	String getBoxId();
	String getUserId();

}

/*       S.D.G.       */
