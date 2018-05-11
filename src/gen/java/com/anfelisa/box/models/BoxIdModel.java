package com.anfelisa.box.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class BoxIdModel implements IBoxIdModel {

	@NotNull
	private String boxId;
	

	public BoxIdModel(
		@JsonProperty("boxId") String boxId
	) {
		this.boxId = boxId;
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
