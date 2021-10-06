/********************************************************************************
 * generated by de.acegen 1.6.0
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
public class CreateReverseBoxPayload implements ICreateReverseBoxPayload {
	
	private String rootCategoryId;
	
	public CreateReverseBoxPayload() {
	}
	
	public CreateReverseBoxPayload(com.anfelisa.box.models.IBoxCreationModel data) {
		rootCategoryId = data.getRootCategoryId();
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	
}



/******* S.D.G. *******/



