package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardOfBoxModel;

@SuppressWarnings("unused")
public class CardOfBoxCreationData implements ICardOfBoxCreationData {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer cardOfBoxId;
	
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
	

	

	public CardOfBoxCreationData(
		@JsonProperty("cardOfBoxId") Integer cardOfBoxId,
		@JsonProperty("cardId") Integer cardId,
		@JsonProperty("ef") Float ef,
		@JsonProperty("interval") Integer interval,
		@JsonProperty("count") Integer count,
		@JsonProperty("date") org.joda.time.DateTime date,
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("timestamp") org.joda.time.DateTime timestamp,
		@JsonProperty("points") Integer points
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.cardOfBoxId = cardOfBoxId;
		this.cardId = cardId;
		this.ef = ef;
		this.interval = interval;
		this.count = count;
		this.date = date;
		this.boxId = boxId;
		this.quality = quality;
		this.timestamp = timestamp;
		this.points = points;
		this.uuid = uuid;
		this.schema = schema;
	}

	public CardOfBoxCreationData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getCardOfBoxId() {
		return this.cardOfBoxId;
	}
	public void setCardOfBoxId(Integer cardOfBoxId) {
		this.cardOfBoxId = cardOfBoxId;
	}
	public CardOfBoxCreationData withCardOfBoxId(Integer cardOfBoxId) {
		this.cardOfBoxId = cardOfBoxId;
		return this;
	}
	
	@JsonProperty
	public Integer getCardId() {
		return this.cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public CardOfBoxCreationData withCardId(Integer cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public Float getEf() {
		return this.ef;
	}
	public void setEf(Float ef) {
		this.ef = ef;
	}
	public CardOfBoxCreationData withEf(Float ef) {
		this.ef = ef;
		return this;
	}
	
	@JsonProperty
	public Integer getInterval() {
		return this.interval;
	}
	public void setInterval(Integer interval) {
		this.interval = interval;
	}
	public CardOfBoxCreationData withInterval(Integer interval) {
		this.interval = interval;
		return this;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public CardOfBoxCreationData withCount(Integer count) {
		this.count = count;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getDate() {
		return this.date;
	}
	public void setDate(org.joda.time.DateTime date) {
		this.date = date;
	}
	public CardOfBoxCreationData withDate(org.joda.time.DateTime date) {
		this.date = date;
		return this;
	}
	
	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public CardOfBoxCreationData withBoxId(Integer boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public CardOfBoxCreationData withQuality(Integer quality) {
		this.quality = quality;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getTimestamp() {
		return this.timestamp;
	}
	public void setTimestamp(org.joda.time.DateTime timestamp) {
		this.timestamp = timestamp;
	}
	public CardOfBoxCreationData withTimestamp(org.joda.time.DateTime timestamp) {
		this.timestamp = timestamp;
		return this;
	}
	
	@JsonProperty
	public Integer getPoints() {
		return this.points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	public CardOfBoxCreationData withPoints(Integer points) {
		this.points = points;
		return this;
	}
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

}

/*       S.D.G.       */
