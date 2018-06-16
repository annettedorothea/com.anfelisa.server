package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IPostponeCardsModel;
import com.anfelisa.box.models.ITodayModel;

@SuppressWarnings("all")
public class PostponeCardsPresentationalData implements IPostponeCardsPresentationalData {
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String userId;
	
	@NotNull
	private Integer days;
	
	@NotNull
	private org.joda.time.DateTime today;
	
	
	public PostponeCardsPresentationalData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("days") Integer days,
		@JsonProperty("today") org.joda.time.DateTime today
	) {
		this.boxId = boxId;
		this.userId = userId;
		this.days = days;
		this.today = today;
		
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public PostponeCardsPresentationalData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public PostponeCardsPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public Integer getDays() {
		return this.days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public PostponeCardsPresentationalData withDays(Integer days) {
		this.days = days;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	public PostponeCardsPresentationalData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	
}

/*       S.D.G.       */
