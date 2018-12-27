package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class DeleteBoxModel implements IDeleteBoxModel {

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
