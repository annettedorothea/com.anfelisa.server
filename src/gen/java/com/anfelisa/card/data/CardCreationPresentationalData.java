package com.anfelisa.card.data;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CardCreationPresentationalData implements ICardCreationPresentationalData {
	
	@NotNull
	private String cardId;
	
	@NotEmpty
	private String given;
	
	@NotEmpty
	private String wanted;
	
	@NotNull
	private String cardAuthor;
	
	@NotNull
	private Integer cardIndex;
	
	private String categoryId;
	
	
	public CardCreationPresentationalData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("cardAuthor") String cardAuthor,
		@JsonProperty("cardIndex") Integer cardIndex,
		@JsonProperty("categoryId") String categoryId
	) {
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.cardAuthor = cardAuthor;
		this.cardIndex = cardIndex;
		this.categoryId = categoryId;
		
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardCreationPresentationalData withCardId(String cardId) {
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
	public CardCreationPresentationalData withGiven(String given) {
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
	public CardCreationPresentationalData withWanted(String wanted) {
		this.wanted = wanted;
		return this;
	}
	
	@JsonProperty
	public String getCardAuthor() {
		return this.cardAuthor;
	}
	public void setCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
	}
	public CardCreationPresentationalData withCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
		return this;
	}
	
	@JsonProperty
	public Integer getCardIndex() {
		return this.cardIndex;
	}
	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}
	public CardCreationPresentationalData withCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CardCreationPresentationalData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
}

/*       S.D.G.       */
