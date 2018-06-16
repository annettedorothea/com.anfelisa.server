package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class ScheduleCategoryPresentationalData implements IScheduleCategoryPresentationalData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String categoryId;
	
	private java.util.List<com.anfelisa.box.models.IScheduledCardModel> scheduledCards;
	
	@NotNull
	private org.joda.time.DateTime today;
	
	
	public ScheduleCategoryPresentationalData(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("scheduledCards") java.util.List<com.anfelisa.box.models.IScheduledCardModel> scheduledCards,
		@JsonProperty("today") org.joda.time.DateTime today
	) {
		this.userId = userId;
		this.boxId = boxId;
		this.categoryId = categoryId;
		this.scheduledCards = scheduledCards;
		this.today = today;
		
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ScheduleCategoryPresentationalData withUserId(String userId) {
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
	public ScheduleCategoryPresentationalData withBoxId(String boxId) {
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
	public ScheduleCategoryPresentationalData withCategoryId(String categoryId) {
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
	public ScheduleCategoryPresentationalData withScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> scheduledCards) {
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
	public ScheduleCategoryPresentationalData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	
}

/*       S.D.G.       */
