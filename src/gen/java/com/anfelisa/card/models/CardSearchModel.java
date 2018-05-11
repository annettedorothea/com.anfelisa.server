package com.anfelisa.card.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class CardSearchModel implements ICardSearchModel {

	@NotNull
	private String searchString;
	
	private String categoryId;
	
	private java.util.List<com.anfelisa.card.models.ICardModel> cardList;
	

	public CardSearchModel(
		@JsonProperty("searchString") String searchString,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardModel> cardList
	) {
		this.searchString = searchString;
		this.categoryId = categoryId;
		this.cardList = cardList;
	}

	@JsonProperty
	public String getSearchString() {
		return this.searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardModel> getCardList() {
		return this.cardList;
	}
	public void setCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList) {
		this.cardList = cardList;
	}
	

}

/*       S.D.G.       */
