package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CardOfBoxModel implements ICardOfBoxModel {

	@NotNull
	private Integer carOfBoxId;
	
	@NotNull
	private Integer cardId;
	
	private Float ef;
	
	private Integer interval;
	
	@NotNull
	private Integer count;
	
	private org.joda.time.DateTime date;
	
	@NotNull
	private Integer boxId;
	
	private Integer quality;
	
	private org.joda.time.DateTime timestamp;
	
	private Integer points;
	


	public CardOfBoxModel(
		@JsonProperty("carOfBoxId") Integer carOfBoxId,
		@JsonProperty("cardId") Integer cardId,
		@JsonProperty("ef") Float ef,
		@JsonProperty("interval") Integer interval,
		@JsonProperty("count") Integer count,
		@JsonProperty("date") org.joda.time.DateTime date,
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("timestamp") org.joda.time.DateTime timestamp,
		@JsonProperty("points") Integer points
	) {
		this.carOfBoxId = carOfBoxId;
		this.cardId = cardId;
		this.ef = ef;
		this.interval = interval;
		this.count = count;
		this.date = date;
		this.boxId = boxId;
		this.quality = quality;
		this.timestamp = timestamp;
		this.points = points;
	}

	@JsonProperty
	public Integer getCarOfBoxId() {
		return this.carOfBoxId;
	}
	public void setCarOfBoxId(Integer carOfBoxId) {
		this.carOfBoxId = carOfBoxId;
	}
	
	@JsonProperty
	public Integer getCardId() {
		return this.cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	
	@JsonProperty
	public Float getEf() {
		return this.ef;
	}
	public void setEf(Float ef) {
		this.ef = ef;
	}
	
	@JsonProperty
	public Integer getInterval() {
		return this.interval;
	}
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getDate() {
		return this.date;
	}
	public void setDate(org.joda.time.DateTime date) {
		this.date = date;
	}
	
	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getTimestamp() {
		return this.timestamp;
	}
	public void setTimestamp(org.joda.time.DateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	


}

/*       S.D.G.       */
