package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class GetTranslationResponse implements IGetTranslationResponse {
	
	public GetTranslationResponse(com.anfelisa.card.models.ICardTranslationModel data) {
	}
	
}

/*       S.D.G.       */
