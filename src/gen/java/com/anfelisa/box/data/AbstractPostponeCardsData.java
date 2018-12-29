package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractPostponeCardsData extends AbstractData implements IPostponeCardsData {
	
	@NotNull
	private Integer days;
	
	@NotNull
	private String boxId;
	
	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	

	public AbstractPostponeCardsData(
		@JsonProperty("days") Integer days,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.days = days;
		this.boxId = boxId;
		this.userId = userId;
		this.today = today;
	}

	public AbstractPostponeCardsData( String uuid ) {
		super(uuid);
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
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	
}

/*       S.D.G.       */
