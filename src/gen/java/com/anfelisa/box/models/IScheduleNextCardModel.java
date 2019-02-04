package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ScheduleNextCardModel.class)
public interface IScheduleNextCardModel extends com.anfelisa.box.models.IScheduledCardModel{

	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	
	List<String> equalsPrimitiveTypes(IScheduleNextCardModel other);
	
}

/*       S.D.G.       */
