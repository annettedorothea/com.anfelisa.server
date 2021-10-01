/********************************************************************************
 * generated by de.acegen
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
public class MoveCardsModel implements IMoveCardsModel {

	private java.util.List<String> cardIdList;

	private String categoryId;

	private String userId;

	private java.util.List<com.anfelisa.card.models.ICardModel> movedCards;

	private java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices;


	public MoveCardsModel() {
	}

	public MoveCardsModel(
		@JsonProperty("cardIdList") java.util.List<String> cardIdList,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId,
		@JsonProperty("movedCards") java.util.List<com.anfelisa.card.models.ICardModel> movedCards,
		@JsonProperty("updatedIndices") java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices
	) {
		this.cardIdList = cardIdList;
		this.categoryId = categoryId;
		this.userId = userId;
		this.movedCards = movedCards;
		this.updatedIndices = updatedIndices;
	}

	@JsonProperty
	public java.util.List<String> getCardIdList() {
		return this.cardIdList;
	}
	public void setCardIdList(java.util.List<String> cardIdList) {
		this.cardIdList = cardIdList;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardModel> getMovedCards() {
		return this.movedCards;
	}
	public void setMovedCards(java.util.List<com.anfelisa.card.models.ICardModel> movedCards) {
		this.movedCards = movedCards;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardModel> getUpdatedIndices() {
		return this.updatedIndices;
	}
	public void setUpdatedIndices(java.util.List<com.anfelisa.card.models.ICardModel> updatedIndices) {
		this.updatedIndices = updatedIndices;
	}
	

	public IMoveCardsModel deepCopy() {
		IMoveCardsModel copy = new MoveCardsModel();
		List<String> cardIdListCopy = new ArrayList<String>();
		for(String item: this.getCardIdList()) {
			cardIdListCopy.add(item);
		}
		copy.setCardIdList(cardIdListCopy);
		copy.setCategoryId(this.getCategoryId());
		copy.setUserId(this.getUserId());
		List<com.anfelisa.card.models.ICardModel> movedCardsCopy = new ArrayList<com.anfelisa.card.models.ICardModel>();
		for(com.anfelisa.card.models.ICardModel item: this.getMovedCards()) {
			movedCardsCopy.add(item.deepCopy());
		}
		copy.setMovedCards(movedCardsCopy);
		List<com.anfelisa.card.models.ICardModel> updatedIndicesCopy = new ArrayList<com.anfelisa.card.models.ICardModel>();
		for(com.anfelisa.card.models.ICardModel item: this.getUpdatedIndices()) {
			updatedIndicesCopy.add(item.deepCopy());
		}
		copy.setUpdatedIndices(updatedIndicesCopy);
		return copy;
	}

}



/******* S.D.G. *******/



