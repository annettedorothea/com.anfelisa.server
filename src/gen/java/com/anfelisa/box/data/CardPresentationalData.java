package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardModel;
import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IScoreModel;
import com.anfelisa.box.models.ICardInfoModel;
import com.anfelisa.box.models.ICardContentModel;
import com.anfelisa.user.models.ICredentialsModel;
import com.anfelisa.box.models.IDaysBehindModel;

@SuppressWarnings("all")
public class CardPresentationalData implements ICardPresentationalData {
	
	@NotNull
	private String cardId;
	
	@NotEmpty
	private String given;
	
	@NotEmpty
	private String wanted;
	
	@NotNull
	private Integer maxPoints;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	
	private Integer cards;
	
	private Integer cardsForToday;
	
	private Integer cardsForTomorrow;
	
	private Integer cardsToBeReinforced;
	
	private Integer zero;
	
	private Integer one;
	
	private Integer two;
	
	private Integer three;
	
	private Integer four;
	
	private Integer five;
	
	private Integer noQuality;
	
	private String cardOfBoxId;
	
	private String content;
	
	private String boxName;
	
	private Integer count;
	
	private org.joda.time.DateTime last;
	
	private org.joda.time.DateTime next;
	
	private Integer quality;
	
	private Boolean complex = false;
	
	private Boolean large = false;
	
	private String header;
	
	private java.util.List<com.anfelisa.box.models.ILineModel> lines;
	
	private String credentialsUsername;
	
	private String credentialsRole;
	
	private Integer daysBehind;
	
	
	public CardPresentationalData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("maxPoints") Integer maxPoints,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username,
		@JsonProperty("cards") Integer cards,
		@JsonProperty("cardsForToday") Integer cardsForToday,
		@JsonProperty("cardsForTomorrow") Integer cardsForTomorrow,
		@JsonProperty("cardsToBeReinforced") Integer cardsToBeReinforced,
		@JsonProperty("zero") Integer zero,
		@JsonProperty("one") Integer one,
		@JsonProperty("two") Integer two,
		@JsonProperty("three") Integer three,
		@JsonProperty("four") Integer four,
		@JsonProperty("five") Integer five,
		@JsonProperty("noQuality") Integer noQuality,
		@JsonProperty("cardOfBoxId") String cardOfBoxId,
		@JsonProperty("content") String content,
		@JsonProperty("boxName") String boxName,
		@JsonProperty("count") Integer count,
		@JsonProperty("last") org.joda.time.DateTime last,
		@JsonProperty("next") org.joda.time.DateTime next,
		@JsonProperty("quality") Integer quality,
		@JsonProperty("complex") Boolean complex,
		@JsonProperty("large") Boolean large,
		@JsonProperty("header") String header,
		@JsonProperty("lines") java.util.List<com.anfelisa.box.models.ILineModel> lines,
		@JsonProperty("credentialsUsername") String credentialsUsername,
		@JsonProperty("credentialsRole") String credentialsRole,
		@JsonProperty("daysBehind") Integer daysBehind
	) {
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.maxPoints = maxPoints;
		this.boxId = boxId;
		this.name = name;
		this.username = username;
		this.cards = cards;
		this.cardsForToday = cardsForToday;
		this.cardsForTomorrow = cardsForTomorrow;
		this.cardsToBeReinforced = cardsToBeReinforced;
		this.zero = zero;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.noQuality = noQuality;
		this.cardOfBoxId = cardOfBoxId;
		this.content = content;
		this.boxName = boxName;
		this.count = count;
		this.last = last;
		this.next = next;
		this.quality = quality;
		this.complex = complex;
		this.large = large;
		this.header = header;
		this.lines = lines;
		this.credentialsUsername = credentialsUsername;
		this.credentialsRole = credentialsRole;
		this.daysBehind = daysBehind;
		
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardPresentationalData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	public CardPresentationalData withGiven(String given) {
		this.given = given;
		return this;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	public CardPresentationalData withWanted(String wanted) {
		this.wanted = wanted;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxPoints() {
		return this.maxPoints;
	}
	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}
	public CardPresentationalData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public CardPresentationalData withBoxId(String boxId) {
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
	public CardPresentationalData withName(String name) {
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
	public CardPresentationalData withUsername(String username) {
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
	public CardPresentationalData withCards(Integer cards) {
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
	public CardPresentationalData withCardsForToday(Integer cardsForToday) {
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
	public CardPresentationalData withCardsForTomorrow(Integer cardsForTomorrow) {
		this.cardsForTomorrow = cardsForTomorrow;
		return this;
	}
	
	@JsonProperty
	public Integer getCardsToBeReinforced() {
		return this.cardsToBeReinforced;
	}
	public void setCardsToBeReinforced(Integer cardsToBeReinforced) {
		this.cardsToBeReinforced = cardsToBeReinforced;
	}
	public CardPresentationalData withCardsToBeReinforced(Integer cardsToBeReinforced) {
		this.cardsToBeReinforced = cardsToBeReinforced;
		return this;
	}
	
	@JsonProperty
	public Integer getZero() {
		return this.zero;
	}
	public void setZero(Integer zero) {
		this.zero = zero;
	}
	public CardPresentationalData withZero(Integer zero) {
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
	public CardPresentationalData withOne(Integer one) {
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
	public CardPresentationalData withTwo(Integer two) {
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
	public CardPresentationalData withThree(Integer three) {
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
	public CardPresentationalData withFour(Integer four) {
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
	public CardPresentationalData withFive(Integer five) {
		this.five = five;
		return this;
	}
	
	@JsonProperty
	public Integer getNoQuality() {
		return this.noQuality;
	}
	public void setNoQuality(Integer noQuality) {
		this.noQuality = noQuality;
	}
	public CardPresentationalData withNoQuality(Integer noQuality) {
		this.noQuality = noQuality;
		return this;
	}
	
	@JsonProperty
	public String getCardOfBoxId() {
		return this.cardOfBoxId;
	}
	public void setCardOfBoxId(String cardOfBoxId) {
		this.cardOfBoxId = cardOfBoxId;
	}
	public CardPresentationalData withCardOfBoxId(String cardOfBoxId) {
		this.cardOfBoxId = cardOfBoxId;
		return this;
	}
	
	@JsonProperty
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CardPresentationalData withContent(String content) {
		this.content = content;
		return this;
	}
	
	@JsonProperty
	public String getBoxName() {
		return this.boxName;
	}
	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}
	public CardPresentationalData withBoxName(String boxName) {
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
	public CardPresentationalData withCount(Integer count) {
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
	public CardPresentationalData withLast(org.joda.time.DateTime last) {
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
	public CardPresentationalData withNext(org.joda.time.DateTime next) {
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
	public CardPresentationalData withQuality(Integer quality) {
		this.quality = quality;
		return this;
	}
	
	@JsonProperty
	public Boolean getComplex() {
		return this.complex;
	}
	public void setComplex(Boolean complex) {
		this.complex = complex;
	}
	public CardPresentationalData withComplex(Boolean complex) {
		this.complex = complex;
		return this;
	}
	
	@JsonProperty
	public Boolean getLarge() {
		return this.large;
	}
	public void setLarge(Boolean large) {
		this.large = large;
	}
	public CardPresentationalData withLarge(Boolean large) {
		this.large = large;
		return this;
	}
	
	@JsonProperty
	public String getHeader() {
		return this.header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public CardPresentationalData withHeader(String header) {
		this.header = header;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.ILineModel> getLines() {
		return this.lines;
	}
	public void setLines(java.util.List<com.anfelisa.box.models.ILineModel> lines) {
		this.lines = lines;
	}
	public CardPresentationalData withLines(java.util.List<com.anfelisa.box.models.ILineModel> lines) {
		this.lines = lines;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsUsername() {
		return this.credentialsUsername;
	}
	public void setCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
	}
	public CardPresentationalData withCredentialsUsername(String credentialsUsername) {
		this.credentialsUsername = credentialsUsername;
		return this;
	}
	
	@JsonProperty
	public String getCredentialsRole() {
		return this.credentialsRole;
	}
	public void setCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
	}
	public CardPresentationalData withCredentialsRole(String credentialsRole) {
		this.credentialsRole = credentialsRole;
		return this;
	}
	
	@JsonProperty
	public Integer getDaysBehind() {
		return this.daysBehind;
	}
	public void setDaysBehind(Integer daysBehind) {
		this.daysBehind = daysBehind;
	}
	public CardPresentationalData withDaysBehind(Integer daysBehind) {
		this.daysBehind = daysBehind;
		return this;
	}
	
}

/*       S.D.G.       */
