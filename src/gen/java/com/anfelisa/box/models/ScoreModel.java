package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class ScoreModel implements IScoreModel {

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
	

	public ScoreModel(
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
		@JsonProperty("noQuality") Integer noQuality
	) {
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
	public Integer getCardsToBeReinforced() {
		return this.cardsToBeReinforced;
	}
	public void setCardsToBeReinforced(Integer cardsToBeReinforced) {
		this.cardsToBeReinforced = cardsToBeReinforced;
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
	

}

/*       S.D.G.       */
