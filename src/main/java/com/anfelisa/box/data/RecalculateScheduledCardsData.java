package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RecalculateScheduledCardsData extends AbstractData implements IRecalculateScheduledCardsData {
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String categoryId;
	
	private Integer maxInterval;
	
	private Integer daysBehind;
	

	public RecalculateScheduledCardsData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("maxInterval") Integer maxInterval,
		@JsonProperty("daysBehind") Integer daysBehind
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxId = boxId;
		this.userId = userId;
		this.categoryId = categoryId;
		this.maxInterval = maxInterval;
		this.daysBehind = daysBehind;
	}

	public RecalculateScheduledCardsData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public RecalculateScheduledCardsData withBoxId(String boxId) {
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
	public RecalculateScheduledCardsData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public RecalculateScheduledCardsData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	public RecalculateScheduledCardsData withMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
		return this;
	}
	
	@JsonProperty
	public Integer getDaysBehind() {
		return this.daysBehind;
	}
	public void setDaysBehind(Integer daysBehind) {
		this.daysBehind = daysBehind;
	}
	public RecalculateScheduledCardsData withDaysBehind(Integer daysBehind) {
		this.daysBehind = daysBehind;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new RecalculateScheduledCardsPresentationalData(
			this.boxId,
			this.userId,
			this.categoryId,
			this.maxInterval,
			this.daysBehind
		);
	}

}

/*       S.D.G.       */
