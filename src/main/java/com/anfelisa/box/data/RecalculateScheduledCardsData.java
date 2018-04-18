package com.anfelisa.box.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RecalculateScheduledCardsData extends AbstractData implements IRecalculateScheduledCardsData {
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String username;
	
	private Integer daysBehind;
	

	public RecalculateScheduledCardsData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("name") String name,
		@JsonProperty("username") String username,
		@JsonProperty("daysBehind") Integer daysBehind
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxId = boxId;
		this.name = name;
		this.username = username;
		this.daysBehind = daysBehind;
	}

	public RecalculateScheduledCardsData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public RecalculateScheduledCardsData withBoxId(String boxId) {
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
	

	@Override
	public Object toPresentationalData() {
		return new RecalculateScheduledCardsPresentationalData(
			this.boxId,
			this.name,
			this.username,
			this.daysBehind
		);
	}

}

/*       S.D.G.       */
