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
	
	@NotNull
	private Integer days;
	

	public PostponeCardsModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("days") Integer days
	) {
		this.boxId = boxId;
		this.userId = userId;
		this.days = days;
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
	
	@JsonProperty
	public Integer getDays() {
		return this.days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	

}

/*       S.D.G.       */
