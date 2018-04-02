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
public class CardCreationPresentationalData implements ICardCreationPresentationalData {
	
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
	
	
	public CardCreationPresentationalData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("content") String content,
		@JsonProperty("testId") String testId,
		@JsonProperty("contentHash") String contentHash,
		@JsonProperty("maxPoints") Integer maxPoints
	) {
		this.cardId = cardId;
		this.content = content;
		this.testId = testId;
		this.contentHash = contentHash;
		this.maxPoints = maxPoints;
		
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardCreationPresentationalData withCardId(String cardId) {
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
	public CardCreationPresentationalData withContent(String content) {
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
	public CardCreationPresentationalData withTestId(String testId) {
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
	public CardCreationPresentationalData withContentHash(String contentHash) {
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
	public CardCreationPresentationalData withMaxPoints(Integer maxPoints) {
		this.maxPoints = maxPoints;
		return this;
	}
	
}

/*       S.D.G.       */
