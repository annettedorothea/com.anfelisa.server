package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractBoxUpdateData extends AbstractData implements IBoxUpdateData {
	
	@NotNull
	private String userId;
	
	@NotNull
	private String boxId;
	
	private Integer maxInterval;
	

	public AbstractBoxUpdateData(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("maxInterval") Integer maxInterval
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.boxId = boxId;
		this.maxInterval = maxInterval;
	}

	public AbstractBoxUpdateData( String uuid ) {
		super(uuid);
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
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	
}

/*       S.D.G.       */
