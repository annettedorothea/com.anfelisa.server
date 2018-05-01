package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CardModel implements ICardModel {

	@NotNull
	private String cardId;
	
	@NotEmpty
	private String given;
	
	@NotEmpty
	private String wanted;
	
	@NotNull
	private Boolean complex = false;
	
	@NotNull
	private String cardAuthor;
	
	@NotNull
	private Integer cardIndex;
	
	private String categoryId;
	

	public CardModel(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("complex") Boolean complex,
		@JsonProperty("cardAuthor") String cardAuthor,
		@JsonProperty("cardIndex") Integer cardIndex,
		@JsonProperty("categoryId") String categoryId
	) {
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.complex = complex;
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
	public Boolean getComplex() {
		return this.complex;
	}
	public void setComplex(Boolean complex) {
		this.complex = complex;
	}
	
	@JsonProperty
	public String getCardAuthor() {
		return this.cardAuthor;
	}
	public void setCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
	}
	
	@JsonProperty
	public Integer getCardIndex() {
		return this.cardIndex;
	}
	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	

}

/*       S.D.G.       */
