/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;
import java.util.ArrayList;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class ActiveCardListModel implements IActiveCardListModel {

	private String userId;

	private String boxId;

	private java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> cardList;

	private Boolean editable = false;


	public ActiveCardListModel() {
	}

	public ActiveCardListModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("cardList") java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> cardList,
		@JsonProperty("editable") Boolean editable
	) {
		this.userId = userId;
		this.boxId = boxId;
		this.cardList = cardList;
		this.editable = editable;
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> getCardList() {
		return this.cardList;
	}
	public void setCardList(java.util.List<com.anfelisa.box.models.ICardWithStatisticsModel> cardList) {
		this.cardList = cardList;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	

	public IActiveCardListModel deepCopy() {
		IActiveCardListModel copy = new ActiveCardListModel();
		copy.setUserId(this.getUserId());
		copy.setBoxId(this.getBoxId());
		List<com.anfelisa.box.models.ICardWithStatisticsModel> cardListCopy = new ArrayList<com.anfelisa.box.models.ICardWithStatisticsModel>();
		for(com.anfelisa.box.models.ICardWithStatisticsModel item: this.getCardList()) {
			cardListCopy.add(item.deepCopy());
		}
		copy.setCardList(cardListCopy);
		copy.setEditable(this.getEditable());
		return copy;
	}

}



/******* S.D.G. *******/



