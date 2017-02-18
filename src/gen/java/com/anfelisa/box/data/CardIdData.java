package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardIdModel;

@SuppressWarnings("unused")
public class CardIdData implements ICardIdData {
	
	private String uuid;
	
	private String createdId;
	
	@NotNull
	private Integer cardId;
	
	@NotNull
	private Integer testId;
	
	@NotNull
	private String contentHash;
	

	
	private org.joda.time.DateTime systemTime;
	
	public CardIdData(
		@JsonProperty("cardId") Integer cardId,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("contentHash") String contentHash
,		@JsonProperty("uuid") String uuid
	) {
		this.cardId = cardId;
		this.testId = testId;
		this.contentHash = contentHash;
		this.uuid = uuid;
	}

	public CardIdData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public Integer getCardId() {
		return this.cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public CardIdData withCardId(Integer cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public CardIdData withTestId(Integer testId) {
		this.testId = testId;
		return this;
	}
	
	@JsonProperty
	public String getContentHash() {
		return this.contentHash;
	}
	public void setContentHash(String contentHash) {
		this.contentHash = contentHash;
	}
	public CardIdData withContentHash(String contentHash) {
		this.contentHash = contentHash;
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

}

/*       S.D.G.       */
