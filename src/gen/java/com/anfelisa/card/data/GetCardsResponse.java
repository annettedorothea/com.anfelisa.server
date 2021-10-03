/********************************************************************************
 * generated by de.acegen 1.5.4
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
public class GetCardsResponse implements IGetCardsResponse {
	
	private java.util.List<com.anfelisa.card.models.ICardWithInfoModel> cardList;
	
	public GetCardsResponse() {
	}
	
	public GetCardsResponse(com.anfelisa.card.models.ICardListModel data) {
		cardList = data.getCardList();
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardWithInfoModel> getCardList() {
		return this.cardList;
	}
	
}



/******* S.D.G. *******/



