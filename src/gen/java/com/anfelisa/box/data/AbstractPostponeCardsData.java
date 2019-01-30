package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractPostponeCardsData extends AbstractData implements IPostponeCardsData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractPostponeCardsData.class);
	
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
	public IPostponeCardsData withDays(Integer days) {
		this.days = days;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IPostponeCardsData withBoxId(String boxId) {
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
	public IPostponeCardsData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	public IPostponeCardsData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	
	
}

/*       S.D.G.       */
