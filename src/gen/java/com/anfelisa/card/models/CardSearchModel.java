package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CardSearchModel implements ICardSearchModel {

	@NotNull
	private String searchString;
	
	private String categoryId;
	
	private java.util.List<com.anfelisa.card.models.ICardModel> cardList;
	
	private Boolean naturalInputOrder = false;
	

	public CardSearchModel(
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
	
	@JsonProperty
	public Boolean getNaturalInputOrder() {
		return this.naturalInputOrder;
	}
	public void setNaturalInputOrder(Boolean naturalInputOrder) {
		this.naturalInputOrder = naturalInputOrder;
	}
	

}

/*       S.D.G.       */
