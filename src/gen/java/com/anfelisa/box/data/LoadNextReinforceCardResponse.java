package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class LoadNextReinforceCardResponse implements ILoadNextReinforceCardResponse {
	
	public LoadNextReinforceCardResponse(com.anfelisa.box.models.INextReinforceCardModel data) {
	}
	
}

/*       S.D.G.       */
