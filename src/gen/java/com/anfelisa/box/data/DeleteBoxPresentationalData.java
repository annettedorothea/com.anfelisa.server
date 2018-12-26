package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.user.models.IUserIdModel;
import com.anfelisa.box.models.IBoxIdModel;

@SuppressWarnings("all")
public class DeleteBoxPresentationalData implements IDeleteBoxPresentationalData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String boxId;
	
	
	public DeleteBoxPresentationalData(
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
	public DeleteBoxPresentationalData withUserId(String userId) {
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
	public DeleteBoxPresentationalData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
}

/*       S.D.G.       */
