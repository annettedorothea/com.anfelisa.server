package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ScheduleCategoryData extends AbstractData implements IScheduleCategoryData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String categoryId;
	
	private java.util.List<com.anfelisa.box.models.IScheduledCardModel> scheduledCards;
	
	@NotNull
	private org.joda.time.DateTime today;
	

	public ScheduleCategoryData(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("scheduledCards") java.util.List<com.anfelisa.box.models.IScheduledCardModel> scheduledCards,
		@JsonProperty("today") org.joda.time.DateTime today
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.boxId = boxId;
		this.categoryId = categoryId;
		this.scheduledCards = scheduledCards;
		this.today = today;
	}

	public ScheduleCategoryData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ScheduleCategoryData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public ScheduleCategoryData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ScheduleCategoryData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IScheduledCardModel> getScheduledCards() {
		return this.scheduledCards;
	}
	public void setScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> scheduledCards) {
		this.scheduledCards = scheduledCards;
	}
	public ScheduleCategoryData withScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> scheduledCards) {
		this.scheduledCards = scheduledCards;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	public ScheduleCategoryData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new ScheduleCategoryPresentationalData(
			this.userId,
			this.boxId,
			this.categoryId,
			this.scheduledCards,
			this.today
		);
	}

}

/*       S.D.G.       */
