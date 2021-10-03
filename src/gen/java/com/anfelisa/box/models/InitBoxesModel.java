/********************************************************************************
 * generated by de.acegen 1.5.6
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
public class InitBoxesModel implements IInitBoxesModel {

	private java.time.LocalDateTime minScheduledDate;

	private String boxId;


	public InitBoxesModel() {
	}

	public InitBoxesModel(
		@JsonProperty("minScheduledDate") java.time.LocalDateTime minScheduledDate,
		@JsonProperty("boxId") String boxId
	) {
		this.minScheduledDate = minScheduledDate;
		this.boxId = boxId;
	}

	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getMinScheduledDate() {
		return this.minScheduledDate;
	}
	public void setMinScheduledDate(java.time.LocalDateTime minScheduledDate) {
		this.minScheduledDate = minScheduledDate;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	

	public IInitBoxesModel deepCopy() {
		IInitBoxesModel copy = new InitBoxesModel();
		copy.setMinScheduledDate(this.getMinScheduledDate());
		copy.setBoxId(this.getBoxId());
		return copy;
	}

}



/******* S.D.G. *******/



