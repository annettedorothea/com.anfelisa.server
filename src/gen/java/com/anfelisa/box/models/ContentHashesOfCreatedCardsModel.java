package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class ContentHashesOfCreatedCardsModel implements IContentHashesOfCreatedCardsModel {

	@NotNull
	private Integer testId;
	
	private java.util.List<String> contentHashesOfCreatedCards;
	
	private java.util.List<String> contentHashesOfObsoleteCards;
	

	public ContentHashesOfCreatedCardsModel(
		@JsonProperty("testId") Integer testId,
		@JsonProperty("contentHashesOfCreatedCards") java.util.List<String> contentHashesOfCreatedCards,
		@JsonProperty("contentHashesOfObsoleteCards") java.util.List<String> contentHashesOfObsoleteCards
	) {
		this.testId = testId;
		this.contentHashesOfCreatedCards = contentHashesOfCreatedCards;
		this.contentHashesOfObsoleteCards = contentHashesOfObsoleteCards;
	}

	@JsonProperty
	public Integer getTestId() {
		return this.testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	
	@JsonProperty
	public java.util.List<String> getContentHashesOfCreatedCards() {
		return this.contentHashesOfCreatedCards;
	}
	public void setContentHashesOfCreatedCards(java.util.List<String> contentHashesOfCreatedCards) {
		this.contentHashesOfCreatedCards = contentHashesOfCreatedCards;
	}
	
	@JsonProperty
	public java.util.List<String> getContentHashesOfObsoleteCards() {
		return this.contentHashesOfObsoleteCards;
	}
	public void setContentHashesOfObsoleteCards(java.util.List<String> contentHashesOfObsoleteCards) {
		this.contentHashesOfObsoleteCards = contentHashesOfObsoleteCards;
	}
	

}

/*       S.D.G.       */
