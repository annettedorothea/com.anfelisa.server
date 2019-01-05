package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CardIdListModel implements ICardIdListModel {

	private java.util.List<String> cardIdList;
	
	private String categoryId;
	
	private String userId;
	
	private java.util.List<com.anfelisa.card.models.ICardModel> movedCards;
	

	public CardIdListModel(
		@JsonProperty("cardIdList") java.util.List<String> cardIdList,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId,
		@JsonProperty("movedCards") java.util.List<com.anfelisa.card.models.ICardModel> movedCards
	) {
		this.cardIdList = cardIdList;
		this.categoryId = categoryId;
		this.userId = userId;
		this.movedCards = movedCards;
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
	

}

/*       S.D.G.       */
