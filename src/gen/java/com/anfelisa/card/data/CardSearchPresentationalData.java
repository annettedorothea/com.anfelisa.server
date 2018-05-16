package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardSearchModel;

@SuppressWarnings("all")
public class CardSearchPresentationalData implements ICardSearchPresentationalData {
	
	@NotNull
	private String searchString;
	
	private String categoryId;
	
	private java.util.List<com.anfelisa.card.models.ICardModel> cardList;
	
	private Boolean naturalInputOrder = false;
	
	
	public CardSearchPresentationalData(
		@JsonProperty("searchString") String searchString,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardModel> cardList,
		@JsonProperty("naturalInputOrder") Boolean naturalInputOrder
	) {
		this.searchString = searchString;
		this.categoryId = categoryId;
		this.cardList = cardList;
		this.naturalInputOrder = naturalInputOrder;
		
	}

	@JsonProperty
	public String getSearchString() {
		return this.searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public CardSearchPresentationalData withSearchString(String searchString) {
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
	public CardSearchPresentationalData withCategoryId(String categoryId) {
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
	public CardSearchPresentationalData withCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList) {
		this.cardList = cardList;
		return this;
	}
	
	@JsonProperty
	public Boolean getNaturalInputOrder() {
		return this.naturalInputOrder;
	}
	public void setNaturalInputOrder(Boolean naturalInputOrder) {
		this.naturalInputOrder = naturalInputOrder;
	}
	public CardSearchPresentationalData withNaturalInputOrder(Boolean naturalInputOrder) {
		this.naturalInputOrder = naturalInputOrder;
		return this;
	}
	
}

/*       S.D.G.       */
