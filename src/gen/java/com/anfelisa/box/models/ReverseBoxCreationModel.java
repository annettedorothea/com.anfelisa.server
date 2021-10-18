/********************************************************************************
 * generated by de.acegen 1.6.4
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
public class ReverseBoxCreationModel implements IReverseBoxCreationModel {

	private String boxId;

	private String username;


	public ReverseBoxCreationModel() {
	}

	public ReverseBoxCreationModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("username") String username
	) {
		this.boxId = boxId;
		this.username = username;
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

	public IReverseBoxCreationModel deepCopy() {
		IReverseBoxCreationModel copy = new ReverseBoxCreationModel();
		copy.setBoxId(this.getBoxId());
		copy.setUsername(this.getUsername());
		return copy;
	}

}



/******* S.D.G. *******/



