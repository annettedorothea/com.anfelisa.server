package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class NextCardModel implements INextCardModel {

	@NotNull
	private String scheduledCardId;
	
	@NotNull
	private String cardId;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private org.joda.time.DateTime scheduledDate;
	
	private Integer lastQuality;
	
	private String given;
	
	private String wanted;
	
	private String image;
	
	private String categoryId;
	
	private String rootCategoryId;
	
	@NotNull
	private Integer count;
	
	private org.joda.time.DateTime scoredDate;
	

	public NextCardModel(
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("scheduledDate") org.joda.time.DateTime scheduledDate,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("count") Integer count,
		@JsonProperty("scoredDate") org.joda.time.DateTime scoredDate
	) {
		this.scheduledCardId = scheduledCardId;
		this.cardId = cardId;
		this.boxId = boxId;
		this.scheduledDate = scheduledDate;
		this.lastQuality = lastQuality;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.count = count;
		this.scoredDate = scoredDate;
	}

	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScheduledDate() {
		return this.scheduledDate;
	}
	public void setScheduledDate(org.joda.time.DateTime scheduledDate) {
		this.scheduledDate = scheduledDate;
	}
	
	@JsonProperty
	public Integer getLastQuality() {
		return this.lastQuality;
	}
	public void setLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	
	@JsonProperty
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScoredDate() {
		return this.scoredDate;
	}
	public void setScoredDate(org.joda.time.DateTime scoredDate) {
		this.scoredDate = scoredDate;
	}
	

}

/*       S.D.G.       */
