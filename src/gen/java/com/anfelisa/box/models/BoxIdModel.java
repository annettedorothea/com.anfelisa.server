package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

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
