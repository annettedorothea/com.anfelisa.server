package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class PostponeCardsModel implements IPostponeCardsModel {

	@NotNull
	private String boxId;
	
	@NotNull
	private String userId;
	

	public PostponeCardsModel(
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
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}

/*       S.D.G.       */
