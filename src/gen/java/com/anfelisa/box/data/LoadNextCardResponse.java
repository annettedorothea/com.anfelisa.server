package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class LoadNextCardResponse implements ILoadNextCardResponse {
	
	@NotNull
	private String cardId;
	
	private String categoryId;
	
	@NotNull
	private Integer count;
	
	private String given;
	
	private String image;
	
	private Integer lastQuality;
	
	private String rootCategoryId;
	
	@NotNull
	private String scheduledCardId;
	
	@NotNull
	private org.joda.time.DateTime scheduledDate;
	
	private org.joda.time.DateTime scoredDate;
	
	private String wanted;
	
	public LoadNextCardResponse() {
	}
	
	public LoadNextCardResponse(com.anfelisa.box.models.INextCardModel data) {
		cardId = data.getCardId();
		categoryId = data.getCategoryId();
		count = data.getCount();
		given = data.getGiven();
		image = data.getImage();
		lastQuality = data.getLastQuality();
		rootCategoryId = data.getRootCategoryId();
		scheduledCardId = data.getScheduledCardId();
		scheduledDate = data.getScheduledDate();
		scoredDate = data.getScoredDate();
		wanted = data.getWanted();
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	
	@JsonProperty
	public String getImage() {
		return this.image;
	}
	
	@JsonProperty
	public Integer getLastQuality() {
		return this.lastQuality;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	
	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScheduledDate() {
		return this.scheduledDate;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getScoredDate() {
		return this.scoredDate;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	
}

/*       S.D.G.       */
