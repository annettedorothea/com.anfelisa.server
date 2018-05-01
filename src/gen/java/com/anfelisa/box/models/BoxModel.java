package com.anfelisa.box.models;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class BoxModel implements IBoxModel {

	@NotNull
	private String boxId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	

	public BoxModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username
	) {
		this.boxId = boxId;
		this.name = name;
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
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}

/*       S.D.G.       */
