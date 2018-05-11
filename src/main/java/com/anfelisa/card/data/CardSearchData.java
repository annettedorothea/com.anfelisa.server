package com.anfelisa.card.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardSearchData extends AbstractData implements ICardSearchData {
	
	@NotNull
	private String searchString;
	
	private String categoryId;
	
	private java.util.List<com.anfelisa.card.models.ICardModel> cardList;
	

	public CardSearchData(
		@JsonProperty("searchString") String searchString,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardModel> cardList
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.searchString = searchString;
		this.categoryId = categoryId;
		this.cardList = cardList;
	}

	public CardSearchData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getSearchString() {
		return this.searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public CardSearchData withSearchString(String searchString) {
		this.searchString = searchString;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public CardSearchData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardModel> getCardList() {
		return this.cardList;
	}
	public void setCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList) {
		this.cardList = cardList;
	}
	public CardSearchData withCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList) {
		this.cardList = cardList;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CardSearchPresentationalData(
			this.searchString,
			this.categoryId,
			this.cardList
		);
	}

}

/*       S.D.G.       */
