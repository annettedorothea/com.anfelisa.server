package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.ICardModel;

@SuppressWarnings("all")
public class CardCreationData implements ICardCreationData {
	
	private String uuid;
	
	private String outcome;
	
	private String[] notifiedListeners;
	
	@NotNull
	private String cardId;
	
	@NotEmpty
	private String content;
	
	@NotNull
	private String testId;
	
	@NotNull
	private String contentHash;
	
	@NotNull
	private Integer maxPoints;
	

	private org.joda.time.DateTime systemTime;
	
	public CardCreationData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("content") String content,
		@JsonProperty("testId") String testId,
		@JsonProperty("contentHash") String contentHash,
		@JsonProperty("maxPoints") Integer maxPoints
,		@JsonProperty("uuid") String uuid
	) {
		this.cardId = cardId;
		this.content = content;
		this.testId = testId;
		this.contentHash = contentHash;
		this.maxPoints = maxPoints;
		this.uuid = uuid;
		
	}

	public CardCreationData( String uuid ) {
		this.uuid = uuid;
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardCreationData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getContent() {
		return this.content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public CardCreationData withContent(String content) {
		this.content = content;
		return this;
	}
	
	@JsonProperty
	public String getTestId() {
		return this.testId;
	}
	public void setTestId(String testId) {
		this.testId = testId;
	}
	public CardCreationData withTestId(String testId) {
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
	public CardCreationData withContentHash(String contentHash) {
		this.contentHash = contentHash;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxPoints() {
		return this.maxPoints;
	}
	public void setMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
	}
	public CardCreationData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
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
		return new CardCreationPresentationalData(
			this.cardId,
			this.content,
			this.testId,
			this.contentHash,
			this.maxPoints
		);
	}

}

/*       S.D.G.       */
