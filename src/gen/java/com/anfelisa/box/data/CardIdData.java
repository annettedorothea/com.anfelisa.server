package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardIdModel;

@SuppressWarnings("all")
public class CardIdData implements ICardIdData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String cardId;
	
	@NotNull
	private String testId;
	
	@NotNull
	private String contentHash;
	

	private org.joda.time.DateTime systemTime;
	
	public CardIdData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("testId") String testId,
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
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardIdData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getTestId() {
		return this.testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public CardIdData withTestId(String testId) {
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
		return new CardIdPresentationalData(
			this.cardId,
			this.testId,
			this.contentHash
		);
	}

}

/*       S.D.G.       */
