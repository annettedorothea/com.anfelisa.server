/********************************************************************************
 * generated by de.acegen 0.9.13
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
public class DeleteBoxModel implements IDeleteBoxModel {

	private String userId;

	private String boxId;

	private String rootCategoryId;


	public DeleteBoxModel() {
	}

	public DeleteBoxModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("rootCategoryId") String rootCategoryId
	) {
		this.userId = userId;
		this.boxId = boxId;
		this.rootCategoryId = rootCategoryId;
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
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	

}



/******* S.D.G. *******/



