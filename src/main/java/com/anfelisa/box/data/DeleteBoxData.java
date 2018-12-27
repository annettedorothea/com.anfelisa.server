package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteBoxData extends AbstractData implements IDeleteBoxData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String boxId;
	

	public DeleteBoxData(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.boxId = boxId;
	}

	public DeleteBoxData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public DeleteBoxData withUserId(String userId) {
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
	public DeleteBoxData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	

}

/*       S.D.G.       */
