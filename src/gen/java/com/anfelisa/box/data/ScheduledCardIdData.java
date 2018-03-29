package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IScheduledCardIdModel;

@SuppressWarnings("all")
public class ScheduledCardIdData implements IScheduledCardIdData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	private String[] notifiedListeners;
	
	private Integer scheduledCardId;
	

	private org.joda.time.DateTime systemTime;
	
	public ScheduledCardIdData(
		@JsonProperty("scheduledCardId") Integer scheduledCardId
,		@JsonProperty("uuid") String uuid
	) {
		this.scheduledCardId = scheduledCardId;
		this.uuid = uuid;
		
	}

	public ScheduledCardIdData( String uuid ) {
		this.uuid = uuid;
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

	@JsonIgnore
	public String getCreatedId() {
		return createdId;
	}

	public void setCreatedId(String createdId) {
		this.createdId = createdId;
	}

	@JsonProperty
	public org.joda.time.DateTime getSystemTime() {
		return systemTime;
	}

	@JsonProperty
	public void setSystemTime(org.joda.time.DateTime systemTime) {
		this.systemTime = systemTime;
	}

	@JsonProperty
	public String getOutcome() {
		return outcome;
	}

	@JsonProperty
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Override
	@JsonProperty
	public String[] getNotifiedListeners() {
		return notifiedListeners;
	}

	@Override
	@JsonProperty
	public void setNotifiedListeners(String[] listeners) {
		this.notifiedListeners = listeners;
	}

	@Override
	public Object toPresentationalData() {
		return new ScheduledCardIdPresentationalData(
			this.scheduledCardId
		);
	}

}

/*       S.D.G.       */
