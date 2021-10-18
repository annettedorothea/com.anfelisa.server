/********************************************************************************
 * generated by de.acegen 1.6.4
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
public class CardListModel implements ICardListModel {

	private String userId;

	private java.util.List<com.anfelisa.card.models.ICardWithInfoModel> cardList;

	private String categoryId;

	private Boolean filterNonScheduled = false;

	private Integer priority;

	private Boolean reverse = false;


	public CardListModel() {
	}

	public CardListModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardWithInfoModel> cardList,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("filterNonScheduled") Boolean filterNonScheduled,
		@JsonProperty("priority") Integer priority,
		@JsonProperty("reverse") Boolean reverse
	) {
		this.userId = userId;
		this.cardList = cardList;
		this.categoryId = categoryId;
		this.filterNonScheduled = filterNonScheduled;
		this.priority = priority;
		this.reverse = reverse;
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardWithInfoModel> getCardList() {
		return this.cardList;
	}
	public void setCardList(java.util.List<com.anfelisa.card.models.ICardWithInfoModel> cardList) {
		this.cardList = cardList;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public Boolean getFilterNonScheduled() {
		return this.filterNonScheduled;
	}
	public void setFilterNonScheduled(Boolean filterNonScheduled) {
		this.filterNonScheduled = filterNonScheduled;
	}
	
	@JsonProperty
	public Integer getPriority() {
		return this.priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}
	

	public ICardListModel deepCopy() {
		ICardListModel copy = new CardListModel();
		copy.setUserId(this.getUserId());
		List<com.anfelisa.card.models.ICardWithInfoModel> cardListCopy = new ArrayList<com.anfelisa.card.models.ICardWithInfoModel>();
		for(com.anfelisa.card.models.ICardWithInfoModel item: this.getCardList()) {
			cardListCopy.add(item.deepCopy());
		}
		copy.setCardList(cardListCopy);
		copy.setCategoryId(this.getCategoryId());
		copy.setFilterNonScheduled(this.getFilterNonScheduled());
		copy.setPriority(this.getPriority());
		copy.setReverse(this.getReverse());
		return copy;
	}

}



/******* S.D.G. *******/



