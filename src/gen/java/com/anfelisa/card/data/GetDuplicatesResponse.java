package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class GetDuplicatesResponse implements IGetDuplicatesResponse {
	
	private java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> cardList;
	
	public GetDuplicatesResponse() {
	}
	
	public GetDuplicatesResponse(com.anfelisa.card.models.ICardSearchModel data) {
		cardList = data.getCardList();
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardWithCategoryNameModel> getCardList() {
		return this.cardList;
	}
	
}

/*       S.D.G.       */
