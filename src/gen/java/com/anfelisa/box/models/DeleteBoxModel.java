package com.anfelisa.box.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class DeleteBoxModel implements IDeleteBoxModel {

	@NotNull
	private String userId;
	
	@NotNull
	private String boxId;
	

	public DeleteBoxModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId
	) {
		this.userId = userId;
		this.boxId = boxId;
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
	

}

/*       S.D.G.       */
