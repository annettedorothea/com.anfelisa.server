package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=CardCreationModel.class)
public interface ICardCreationModel extends com.anfelisa.card.models.ICardModel{

	String getUserId();
	void setUserId(String userId);
	
	String getUsername();
	void setUsername(String username);
	
	
	List<String> equalsPrimitiveTypes(ICardCreationModel other);
	
}

/*       S.D.G.       */
