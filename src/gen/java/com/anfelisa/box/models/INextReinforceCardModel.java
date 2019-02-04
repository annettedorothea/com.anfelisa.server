package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=NextReinforceCardModel.class)
public interface INextReinforceCardModel extends com.anfelisa.box.models.INextReinforceCardViewModel{

	String getBoxId();
	void setBoxId(String boxId);
	
	String getUserId();
	void setUserId(String userId);
	
	
	List<String> equalsPrimitiveTypes(INextReinforceCardModel other);
	
}

/*       S.D.G.       */
