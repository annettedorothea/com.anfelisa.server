package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=BoxUpdateModel.class)
public interface IBoxUpdateModel {

	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	Integer getMaxInterval();
	void setMaxInterval(Integer maxInterval);
	
	Integer getMaxCardsPerDay();
	void setMaxCardsPerDay(Integer maxCardsPerDay);
	
	
	List<String> equalsPrimitiveTypes(IBoxUpdateModel other);
	
}

/*       S.D.G.       */
