/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IPostponeCardsModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractPostponeCardsData extends AbstractData implements IPostponeCardsData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractPostponeCardsData.class);
	
	private Integer days;
	
	private String boxId;
	

	public AbstractPostponeCardsData(
		@JsonProperty("days") Integer days,
		@JsonProperty("boxId") String boxId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.days = days;
		this.boxId = boxId;
	}

	public AbstractPostponeCardsData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public Integer getDays() {
		return this.days;
	}
	public void setDays(Integer days) {
		this.days = days;
	}
	public IPostponeCardsData withDays(Integer days) {
		this.days = days;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IPostponeCardsData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	
	
}



/******* S.D.G. *******/



