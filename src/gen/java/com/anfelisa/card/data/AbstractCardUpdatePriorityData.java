/********************************************************************************
 * generated by de.acegen 1.2.1
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.card.models.ICardUpdatePriorityModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractCardUpdatePriorityData extends AbstractData implements ICardUpdatePriorityData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCardUpdatePriorityData.class);
	
	private String cardId;
	
	private Integer priority;
	
	private String userId;
	

	public AbstractCardUpdatePriorityData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("priority") Integer priority,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.cardId = cardId;
		this.priority = priority;
		this.userId = userId;
	}

	public AbstractCardUpdatePriorityData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public ICardUpdatePriorityData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public Integer getPriority() {
		return this.priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public ICardUpdatePriorityData withPriority(Integer priority) {
		this.priority = priority;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ICardUpdatePriorityData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	
	public ICardUpdatePriorityData deepCopy() {
		ICardUpdatePriorityData copy = new CardUpdatePriorityData(this.getUuid());
		copy.setCardId(this.getCardId());
		copy.setPriority(this.getPriority());
		copy.setUserId(this.getUserId());
		return copy;
	}

}



/******* S.D.G. *******/



