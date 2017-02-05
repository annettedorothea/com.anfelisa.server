package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduledCardIdModel;

@SuppressWarnings("unused")
public class ScheduledCardIdData implements IScheduledCardIdData {
	
	private String uuid;
	
	private String schema;
	
	private String createdId;
	
	private Integer scheduledCardId;
	

	

	public ScheduledCardIdData(
		@JsonProperty("scheduledCardId") Integer scheduledCardId
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.scheduledCardId = scheduledCardId;
		this.uuid = uuid;
		this.schema = schema;
	}

	public ScheduledCardIdData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(Integer scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public ScheduledCardIdData withScheduledCardId(Integer scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
		return this;
	}
	
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

	@JsonIgnore
	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

}

/*       S.D.G.       */
