package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IScoreModel;
import com.anfelisa.box.models.ICardInfoModel;

@SuppressWarnings("unused")
public class CardData implements ICardModel, IBoxModel, IScoreModel, ICardInfoModel, IDataContainer {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer cardId;
	
	@NotEmpty
	private String content;
	
	@NotNull
	private Integer testId;
	
	@NotNull
	private String contentHash;
	
	@NotNull
	private Integer maxPoints;
	
	@NotNull
	private Integer boxId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	
	private Integer cards;
	
	private Integer cardsForToday;
	
	private Integer cardsForTomorrow;
	
	private Integer newCards;
	
	private Integer totalOfCardsWithQuality;
	
	private Integer zero;
	
	private Integer one;
	
	private Integer two;
	
	private Integer three;
	
	private Integer four;
	
	private Integer five;
	
	private String boxName;
	
	private Integer count;
	
	private org.joda.time.DateTime last;
	
	private org.joda.time.DateTime next;
	
	private Integer quality;
	


	
	
	
	

	public CardData(
		@JsonProperty("cardId") Integer cardId,
		@JsonProperty("content") String content,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("contentHash") String contentHash,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username,
		@JsonProperty("cards") Integer cards,
		@JsonProperty("cardsForToday") Integer cardsForToday,
		@JsonProperty("cardsForTomorrow") Integer cardsForTomorrow,
		@JsonProperty("newCards") Integer newCards,
		@JsonProperty("totalOfCardsWithQuality") Integer totalOfCardsWithQuality,
		@JsonProperty("zero") Integer zero,
		@JsonProperty("one") Integer one,
		@JsonProperty("two") Integer two,
		@JsonProperty("three") Integer three,
		@JsonProperty("four") Integer four,
		@JsonProperty("five") Integer five,
		@JsonProperty("boxName") String boxName,
		@JsonProperty("count") Integer count,
		@JsonProperty("last") org.joda.time.DateTime last,
		@JsonProperty("next") org.joda.time.DateTime next,
		@JsonProperty("quality") Integer quality
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.cardId = cardId;
		this.content = content;
		this.testId = testId;
		this.contentHash = contentHash;
		this.maxPoints = maxPoints;
		this.boxId = boxId;
		this.name = name;
		this.username = username;
		this.cards = cards;
		this.cardsForToday = cardsForToday;
		this.cardsForTomorrow = cardsForTomorrow;
		this.newCards = newCards;
		this.totalOfCardsWithQuality = totalOfCardsWithQuality;
		this.zero = zero;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.boxName = boxName;
		this.count = count;
		this.last = last;
		this.next = next;
		this.quality = quality;
		this.uuid = uuid;
		this.schema = schema;
	}

	public CardData(
		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getCardId() {
		return this.cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public CardData withCardId(Integer cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CardData withContent(String content) {
		this.content = content;
		return this;
	}
	
	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public CardData withTestId(Integer testId) {
		this.testId = testId;
		return this;
	}
	
	@JsonProperty
	public String getContentHash() {
		return this.contentHash;
	}
	public void setContentHash(String contentHash) {
		this.contentHash = contentHash;
	}
	public CardData withContentHash(String contentHash) {
		this.contentHash = contentHash;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxPoints() {
		return this.maxPoints;
	}
	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}
	public CardData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
		return this;
	}
	
	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public CardData withBoxId(Integer boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CardData withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public CardData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Integer getCards() {
		return this.cards;
	}
	public void setCards(Integer cards) {
		this.cards = cards;
	}
	public CardData withCards(Integer cards) {
		this.cards = cards;
		return this;
	}
	
	@JsonProperty
	public Integer getCardsForToday() {
		return this.cardsForToday;
	}
	public void setCardsForToday(Integer cardsForToday) {
		this.cardsForToday = cardsForToday;
	}
	public CardData withCardsForToday(Integer cardsForToday) {
		this.cardsForToday = cardsForToday;
		return this;
	}
	
	@JsonProperty
	public Integer getCardsForTomorrow() {
		return this.cardsForTomorrow;
	}
	public void setCardsForTomorrow(Integer cardsForTomorrow) {
		this.cardsForTomorrow = cardsForTomorrow;
	}
	public CardData withCardsForTomorrow(Integer cardsForTomorrow) {
		this.cardsForTomorrow = cardsForTomorrow;
		return this;
	}
	
	@JsonProperty
	public Integer getNewCards() {
		return this.newCards;
	}
	public void setNewCards(Integer newCards) {
		this.newCards = newCards;
	}
	public CardData withNewCards(Integer newCards) {
		this.newCards = newCards;
		return this;
	}
	
	@JsonProperty
	public Integer getTotalOfCardsWithQuality() {
		return this.totalOfCardsWithQuality;
	}
	public void setTotalOfCardsWithQuality(Integer totalOfCardsWithQuality) {
		this.totalOfCardsWithQuality = totalOfCardsWithQuality;
	}
	public CardData withTotalOfCardsWithQuality(Integer totalOfCardsWithQuality) {
		this.totalOfCardsWithQuality = totalOfCardsWithQuality;
		return this;
	}
	
	@JsonProperty
	public Integer getZero() {
		return this.zero;
	}
	public void setZero(Integer zero) {
		this.zero = zero;
	}
	public CardData withZero(Integer zero) {
		this.zero = zero;
		return this;
	}
	
	@JsonProperty
	public Integer getOne() {
		return this.one;
	}
	public void setOne(Integer one) {
		this.one = one;
	}
	public CardData withOne(Integer one) {
		this.one = one;
		return this;
	}
	
	@JsonProperty
	public Integer getTwo() {
		return this.two;
	}
	public void setTwo(Integer two) {
		this.two = two;
	}
	public CardData withTwo(Integer two) {
		this.two = two;
		return this;
	}
	
	@JsonProperty
	public Integer getThree() {
		return this.three;
	}
	public void setThree(Integer three) {
		this.three = three;
	}
	public CardData withThree(Integer three) {
		this.three = three;
		return this;
	}
	
	@JsonProperty
	public Integer getFour() {
		return this.four;
	}
	public void setFour(Integer four) {
		this.four = four;
	}
	public CardData withFour(Integer four) {
		this.four = four;
		return this;
	}
	
	@JsonProperty
	public Integer getFive() {
		return this.five;
	}
	public void setFive(Integer five) {
		this.five = five;
	}
	public CardData withFive(Integer five) {
		this.five = five;
		return this;
	}
	
	@JsonProperty
	public String getBoxName() {
		return this.boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	public CardData withBoxName(String boxName) {
		this.boxName = boxName;
		return this;
	}
	
	@JsonProperty
	public Integer getCount() {
		return this.count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public CardData withCount(Integer count) {
		this.count = count;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getLast() {
		return this.last;
	}
	public void setLast(org.joda.time.DateTime last) {
		this.last = last;
	}
	public CardData withLast(org.joda.time.DateTime last) {
		this.last = last;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getNext() {
		return this.next;
	}
	public void setNext(org.joda.time.DateTime next) {
		this.next = next;
	}
	public CardData withNext(org.joda.time.DateTime next) {
		this.next = next;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality() {
		return this.quality;
	}
	public void setQuality(Integer quality) {
		this.quality = quality;
	}
	public CardData withQuality(Integer quality) {
		this.quality = quality;
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
