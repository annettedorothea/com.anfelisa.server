package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=NextReinforceCardModel.class)
public interface INextReinforceCardModel extends com.anfelisa.box.models.INextReinforceCardViewModel{

	String getBoxId();
	void setBoxId(String boxId);
	
	String getUserId();
	void setUserId(String userId);
	
	
}

/*       S.D.G.       */
