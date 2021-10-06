/********************************************************************************
 * generated by de.acegen 1.6.0
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
	

	public IDeleteBoxModel deepCopy() {
		IDeleteBoxModel copy = new DeleteBoxModel();
		copy.setUserId(this.getUserId());
		copy.setBoxId(this.getBoxId());
		copy.setRootCategoryId(this.getRootCategoryId());
		return copy;
	}

}



/******* S.D.G. *******/



