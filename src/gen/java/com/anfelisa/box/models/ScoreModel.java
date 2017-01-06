package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ScoreModel implements IScoreModel {

	private Integer cards;
	
	private Integer cardsForToday;
	
	private Integer cardsForTomorrow;
	
	private Integer zero;
	
	private Integer one;
	
	private Integer two;
	
	private Integer three;
	
	private Integer four;
	
	private Integer five;
	
	private Integer noQuality;
	
	private org.joda.time.DateTime now;
	


	public ScoreModel(
		@JsonProperty("cards") Integer cards,
		@JsonProperty("cardsForToday") Integer cardsForToday,
		@JsonProperty("cardsForTomorrow") Integer cardsForTomorrow,
		@JsonProperty("zero") Integer zero,
		@JsonProperty("one") Integer one,
		@JsonProperty("two") Integer two,
		@JsonProperty("three") Integer three,
		@JsonProperty("four") Integer four,
		@JsonProperty("five") Integer five,
		@JsonProperty("noQuality") Integer noQuality,
		@JsonProperty("now") org.joda.time.DateTime now
	) {
		this.cards = cards;
		this.cardsForToday = cardsForToday;
		this.cardsForTomorrow = cardsForTomorrow;
		this.zero = zero;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.noQuality = noQuality;
		this.now = now;
	}

	@JsonProperty
	public Integer getCards() {
		return this.cards;
	}
	public void setCards(Integer cards) {
		this.cards = cards;
	}
	
	@JsonProperty
	public Integer getCardsForToday() {
		return this.cardsForToday;
	}
	public void setCardsForToday(Integer cardsForToday) {
		this.cardsForToday = cardsForToday;
	}
	
	@JsonProperty
	public Integer getCardsForTomorrow() {
		return this.cardsForTomorrow;
	}
	public void setCardsForTomorrow(Integer cardsForTomorrow) {
		this.cardsForTomorrow = cardsForTomorrow;
	}
	
	@JsonProperty
	public Integer getZero() {
		return this.zero;
	}
	public void setZero(Integer zero) {
		this.zero = zero;
	}
	
	@JsonProperty
	public Integer getOne() {
		return this.one;
	}
	public void setOne(Integer one) {
		this.one = one;
	}
	
	@JsonProperty
	public Integer getTwo() {
		return this.two;
	}
	public void setTwo(Integer two) {
		this.two = two;
	}
	
	@JsonProperty
	public Integer getThree() {
		return this.three;
	}
	public void setThree(Integer three) {
		this.three = three;
	}
	
	@JsonProperty
	public Integer getFour() {
		return this.four;
	}
	public void setFour(Integer four) {
		this.four = four;
	}
	
	@JsonProperty
	public Integer getFive() {
		return this.five;
	}
	public void setFive(Integer five) {
		this.five = five;
	}
	
	@JsonProperty
	public Integer getNoQuality() {
		return this.noQuality;
	}
	public void setNoQuality(Integer noQuality) {
		this.noQuality = noQuality;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getNow() {
		return this.now;
	}
	public void setNow(org.joda.time.DateTime now) {
		this.now = now;
	}
	


}

/*       S.D.G.       */
