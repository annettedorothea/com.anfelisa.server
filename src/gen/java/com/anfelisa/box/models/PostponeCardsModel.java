/********************************************************************************
 * generated by de.acegen 1.2.1
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
public class PostponeCardsModel implements IPostponeCardsModel {

	private Integer days;

	private String boxId;


	public PostponeCardsModel() {
	}

	public PostponeCardsModel(
		@JsonProperty("days") Integer days,
		@JsonProperty("boxId") String boxId
	) {
		this.days = days;
		this.boxId = boxId;
	}

	@JsonProperty
	public Integer getDays() {
		return this.days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	

	public IPostponeCardsModel deepCopy() {
		IPostponeCardsModel copy = new PostponeCardsModel();
		copy.setDays(this.getDays());
		copy.setBoxId(this.getBoxId());
		return copy;
	}

}



/******* S.D.G. *******/



