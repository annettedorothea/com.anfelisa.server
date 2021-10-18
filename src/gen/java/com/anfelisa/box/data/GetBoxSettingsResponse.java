/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.box.data;

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
public class GetBoxSettingsResponse implements IGetBoxSettingsResponse {
	
	private com.anfelisa.box.models.IBoxSettingsModel boxSettings;
	
	public GetBoxSettingsResponse() {
	}
	
	public GetBoxSettingsResponse(com.anfelisa.box.models.IBoxSettingsWrapperModel data) {
		boxSettings = data.getBoxSettings();
	}
	
	@JsonProperty
	public com.anfelisa.box.models.IBoxSettingsModel getBoxSettings() {
		return this.boxSettings;
	}
	
}



/******* S.D.G. *******/



