/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=BoxStatisticsListModel.class)
public interface IBoxStatisticsListModel {

	java.util.List<com.anfelisa.box.models.IBoxStatisticsModel> getBoxStatisticsList();
	void setBoxStatisticsList(java.util.List<com.anfelisa.box.models.IBoxStatisticsModel> boxStatisticsList);
	
	String getUserId();
	void setUserId(String userId);
	
	java.time.LocalDateTime getTodayAtMidnightInUTC();
	void setTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC);
	
	
}




/******* S.D.G. *******/



