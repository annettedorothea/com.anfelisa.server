package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class PostponeCardsPresentationalData implements IPostponeCardsPresentationalData {
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String userId;
	
	
	public PostponeCardsPresentationalData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId
	) {
		this.boxId = boxId;
		this.userId = userId;
		
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public PostponeCardsPresentationalData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public PostponeCardsPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
}

/*       S.D.G.       */
