package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class BoxIdModel implements IBoxIdModel {

	@NotNull
	private Integer boxId;
	


	public BoxIdModel(
		@JsonProperty("boxId") Integer boxId
	) {
		this.boxId = boxId;
	}

	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	


}

/*       S.D.G.       */
