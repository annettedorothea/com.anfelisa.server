package com.anfelisa.box.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class BoxUpdateModel implements IBoxUpdateModel {

	@NotNull
	private String boxId;
	
	@NotNull
	private String name;
	
	private Integer maxInterval;
	

	public BoxUpdateModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("name") String name,
		@JsonProperty("maxInterval") Integer maxInterval
	) {
		this.boxId = boxId;
		this.name = name;
		this.maxInterval = maxInterval;
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	

}

/*       S.D.G.       */
