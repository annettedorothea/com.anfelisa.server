/********************************************************************************
 * generated by de.acegen
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
public class BoxArchiveModel implements IBoxArchiveModel {

	private String userId;

	private String boxId;

	private Boolean archived = false;


	public BoxArchiveModel() {
	}

	public BoxArchiveModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("archived") Boolean archived
	) {
		this.userId = userId;
		this.boxId = boxId;
		this.archived = archived;
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
	public Boolean getArchived() {
		return this.archived;
	}
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
	

	public IBoxArchiveModel deepCopy() {
		IBoxArchiveModel copy = new BoxArchiveModel();
		copy.setUserId(this.getUserId());
		copy.setBoxId(this.getBoxId());
		copy.setArchived(this.getArchived());
		return copy;
	}

}



/******* S.D.G. *******/


