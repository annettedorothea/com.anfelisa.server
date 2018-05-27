package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class DeleteBoxPresentationalData implements IDeleteBoxPresentationalData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String boxId;
	
	
	public DeleteBoxPresentationalData(
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
	public DeleteBoxPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public DeleteBoxPresentationalData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
}

/*       S.D.G.       */
