/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;

import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("all")
public class MoveCardsPayload implements IMoveCardsPayload {
	
	private java.util.List<String> cardIdList;
	
	private String categoryId;
	
	public MoveCardsPayload() {
	}
	
	public MoveCardsPayload(com.anfelisa.card.models.IMoveCardsModel data) {
		cardIdList = data.getCardIdList();
		categoryId = data.getCategoryId();
	}
	
	@JsonProperty
	public java.util.List<String> getCardIdList() {
		return this.cardIdList;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	
}



/******* S.D.G. *******/



