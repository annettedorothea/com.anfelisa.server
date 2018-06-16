package com.anfelisa.box.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class ScheduleCategoryModel implements IScheduleCategoryModel {

	@NotNull
	private String userId;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String categoryId;
	
	private java.util.List<com.anfelisa.box.models.IScheduledCardModel> scheduledCards;
	

	public ScheduleCategoryModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("scheduledCards") java.util.List<com.anfelisa.box.models.IScheduledCardModel> scheduledCards
	) {
		this.userId = userId;
		this.boxId = boxId;
		this.categoryId = categoryId;
		this.scheduledCards = scheduledCards;
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IScheduledCardModel> getScheduledCards() {
		return this.scheduledCards;
	}
	public void setScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> scheduledCards) {
		this.scheduledCards = scheduledCards;
	}
	

}

/*       S.D.G.       */
