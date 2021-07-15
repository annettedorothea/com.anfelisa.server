/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class CardSearchModel implements ICardSearchModel {

	private String userId;

	private String given;

	private String wanted;

	private String categoryId;

	private java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardList;

	private Boolean naturalInputOrder = false;


	public CardSearchModel() {
	}

	public CardSearchModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardList,
		@JsonProperty("naturalInputOrder") Boolean naturalInputOrder
	) {
		this.userId = userId;
		this.given = given;
		this.wanted = wanted;
		this.categoryId = categoryId;
		this.cardList = cardList;
		this.naturalInputOrder = naturalInputOrder;
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> getCardList() {
		return this.cardList;
	}
	public void setCardList(java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardList) {
		this.cardList = cardList;
	}
	
	@JsonProperty
	public Boolean getNaturalInputOrder() {
		return this.naturalInputOrder;
	}
	public void setNaturalInputOrder(Boolean naturalInputOrder) {
		this.naturalInputOrder = naturalInputOrder;
	}
	

	public ICardSearchModel deepCopy() {
		ICardSearchModel copy = new CardSearchModel();
		copy.setUserId(this.getUserId());
		copy.setGiven(this.getGiven());
		copy.setWanted(this.getWanted());
		copy.setCategoryId(this.getCategoryId());
		List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardListCopy = new ArrayList<com.anfelisa.card.models.ICardWithCategoryNameModel>();
		for(com.anfelisa.card.models.ICardWithCategoryNameModel item: this.getCardList()) {
			cardListCopy.add(item.deepCopy());
		}
		copy.setCardList(cardListCopy);
		copy.setNaturalInputOrder(this.getNaturalInputOrder());
		return copy;
	}

}



/******* S.D.G. *******/



