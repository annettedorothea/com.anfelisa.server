/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class InitMyBoxesForDayPayload implements IInitMyBoxesForDayPayload {
	
	private java.time.LocalDateTime todayAtMidnightInUTC;
	
	public InitMyBoxesForDayPayload() {
	}
	
	public InitMyBoxesForDayPayload(com.anfelisa.box.models.IInitMyBoxesDataModel data) {
		todayAtMidnightInUTC = data.getTodayAtMidnightInUTC();
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getTodayAtMidnightInUTC() {
		return this.todayAtMidnightInUTC;
	}
	
}



/******* S.D.G. *******/



