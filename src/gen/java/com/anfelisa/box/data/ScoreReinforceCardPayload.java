/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public class ScoreReinforceCardPayload {
	
	private String reinforceCardId;
	
	private Boolean keep;
	
	public ScoreReinforceCardPayload() {
	}
	
	
	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	
	@JsonProperty
	public Boolean getKeep() {
		return this.keep;
	}
	
}



/******* S.D.G. *******/



