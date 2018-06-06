package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IUserIdModel;

@SuppressWarnings("all")
public class ScoreCardPresentationalData implements IScoreCardPresentationalData {
	
	@NotNull
	private String userId;
	
	
	public ScoreCardPresentationalData(
		@JsonProperty("userId") String userId
	) {
		this.userId = userId;
		
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ScoreCardPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
}

/*       S.D.G.       */
