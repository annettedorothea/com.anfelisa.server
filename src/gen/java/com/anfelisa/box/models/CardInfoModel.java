package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CardInfoModel implements ICardInfoModel {

	private String cardId;
	
	private String cardOfBoxId;
	
	private String content;
	
	private String boxName;
	
	private Integer count;
	
	private org.joda.time.DateTime last;
	
	private org.joda.time.DateTime next;
	
	private Integer quality;
	

	public CardInfoModel(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("cardOfBoxId") String cardOfBoxId,
		@JsonProperty("content") String content,
		@JsonProperty("boxName") String boxName,
		@JsonProperty("count") Integer count,
		@JsonProperty("last") org.joda.time.DateTime last,
		@JsonProperty("next") org.joda.time.DateTime next,
		@JsonProperty("quality") Integer quality
	) {
		this.cardId = cardId;
		this.cardOfBoxId = cardOfBoxId;
		this.content = content;
		this.boxName = boxName;
		this.count = count;
		this.last = last;
		this.next = next;
		this.quality = quality;
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	@JsonProperty
	public String getCardOfBoxId() {
		return this.cardOfBoxId;
	}
	public void setCardOfBoxId(String cardOfBoxId) {
		this.cardOfBoxId = cardOfBoxId;
	}
	
	@JsonProperty
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@JsonProperty
	public String getBoxName() {
		return this.boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getLast() {
		return this.last;
	}
	public void setLast(org.joda.time.DateTime last) {
		this.last = last;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getNext() {
		return this.next;
	}
	public void setNext(org.joda.time.DateTime next) {
		this.next = next;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	

}

/*       S.D.G.       */
