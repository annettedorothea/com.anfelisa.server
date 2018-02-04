package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxModel;
import com.anfelisa.box.models.IDaysBehindModel;

@SuppressWarnings("all")
public class RecalculateScheduledCardsData implements IRecalculateScheduledCardsData {
	
	private String uuid;
	
	private String outcome;
	
	private String createdId;
	
	@NotNull
	private Integer boxId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	
	private Integer daysBehind;
	

	
	
	private org.joda.time.DateTime systemTime;
	
	public RecalculateScheduledCardsData(
		@JsonProperty("boxId") Integer boxId,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username,
		@JsonProperty("daysBehind") Integer daysBehind
,		@JsonProperty("uuid") String uuid
	) {
		this.boxId = boxId;
		this.name = name;
		this.username = username;
		this.daysBehind = daysBehind;
		this.uuid = uuid;
	}

	public RecalculateScheduledCardsData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public Integer getBoxId() {
		return this.boxId;
	}
	public void setBoxId(Integer boxId) {
		this.boxId = boxId;
	}
	public RecalculateScheduledCardsData withBoxId(Integer boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RecalculateScheduledCardsData withName(String name) {
		this.name = name;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public RecalculateScheduledCardsData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public Integer getDaysBehind() {
		return this.daysBehind;
	}
	public void setDaysBehind(Integer daysBehind) {
		this.daysBehind = daysBehind;
	}
	public RecalculateScheduledCardsData withDaysBehind(Integer daysBehind) {
		this.daysBehind = daysBehind;
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

}

/*       S.D.G.       */
