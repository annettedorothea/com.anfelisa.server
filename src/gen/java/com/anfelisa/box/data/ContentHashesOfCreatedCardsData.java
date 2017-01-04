package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IContentHashesOfCreatedCardsModel;

@SuppressWarnings("unused")
public class ContentHashesOfCreatedCardsData implements IContentHashesOfCreatedCardsData {
	
	private String uuid;
	
	private String schema;
	
	@NotNull
	private Integer testId;
	
	private java.util.List<String> contentHashesOfCreatedCards;
	
	private java.util.List<String> contentHashesOfObsoleteCards;
	

	

	public ContentHashesOfCreatedCardsData(
		@JsonProperty("testId") Integer testId,
		@JsonProperty("contentHashesOfCreatedCards") java.util.List<String> contentHashesOfCreatedCards,
		@JsonProperty("contentHashesOfObsoleteCards") java.util.List<String> contentHashesOfObsoleteCards
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.testId = testId;
		this.contentHashesOfCreatedCards = contentHashesOfCreatedCards;
		this.contentHashesOfObsoleteCards = contentHashesOfObsoleteCards;
		this.uuid = uuid;
		this.schema = schema;
	}

	public ContentHashesOfCreatedCardsData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public ContentHashesOfCreatedCardsData withTestId(Integer testId) {
		this.testId = testId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getContentHashesOfCreatedCards() {
		return this.contentHashesOfCreatedCards;
	}
	public void setContentHashesOfCreatedCards(java.util.List<String> contentHashesOfCreatedCards) {
		this.contentHashesOfCreatedCards = contentHashesOfCreatedCards;
	}
	public ContentHashesOfCreatedCardsData withContentHashesOfCreatedCards(java.util.List<String> contentHashesOfCreatedCards) {
		this.contentHashesOfCreatedCards = contentHashesOfCreatedCards;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getContentHashesOfObsoleteCards() {
		return this.contentHashesOfObsoleteCards;
	}
	public void setContentHashesOfObsoleteCards(java.util.List<String> contentHashesOfObsoleteCards) {
		this.contentHashesOfObsoleteCards = contentHashesOfObsoleteCards;
	}
	public ContentHashesOfCreatedCardsData withContentHashesOfObsoleteCards(java.util.List<String> contentHashesOfObsoleteCards) {
		this.contentHashesOfObsoleteCards = contentHashesOfObsoleteCards;
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

}

/*       S.D.G.       */
