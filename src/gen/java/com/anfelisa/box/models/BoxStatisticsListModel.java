/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class BoxStatisticsListModel implements IBoxStatisticsListModel {

	private java.util.List<com.anfelisa.box.models.IBoxStatisticsModel> boxStatisticsList;

	private String userId;

	private java.time.LocalDateTime todayAtMidnightInUTC;


	public BoxStatisticsListModel() {
	}

	public BoxStatisticsListModel(
		@JsonProperty("boxStatisticsList") java.util.List<com.anfelisa.box.models.IBoxStatisticsModel> boxStatisticsList,
		@JsonProperty("userId") String userId,
		@JsonProperty("todayAtMidnightInUTC") java.time.LocalDateTime todayAtMidnightInUTC
	) {
		this.boxStatisticsList = boxStatisticsList;
		this.userId = userId;
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
	}

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IBoxStatisticsModel> getBoxStatisticsList() {
		return this.boxStatisticsList;
	}
	public void setBoxStatisticsList(java.util.List<com.anfelisa.box.models.IBoxStatisticsModel> boxStatisticsList) {
		this.boxStatisticsList = boxStatisticsList;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getTodayAtMidnightInUTC() {
		return this.todayAtMidnightInUTC;
	}
	public void setTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC) {
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
	}
	

	public IBoxStatisticsListModel deepCopy() {
		IBoxStatisticsListModel copy = new BoxStatisticsListModel();
		List<com.anfelisa.box.models.IBoxStatisticsModel> boxStatisticsListCopy = new ArrayList<com.anfelisa.box.models.IBoxStatisticsModel>();
		for(com.anfelisa.box.models.IBoxStatisticsModel item: this.getBoxStatisticsList()) {
			boxStatisticsListCopy.add(item.deepCopy());
		}
		copy.setBoxStatisticsList(boxStatisticsListCopy);
		copy.setUserId(this.getUserId());
		copy.setTodayAtMidnightInUTC(this.getTodayAtMidnightInUTC());
		return copy;
	}

}



/******* S.D.G. *******/



