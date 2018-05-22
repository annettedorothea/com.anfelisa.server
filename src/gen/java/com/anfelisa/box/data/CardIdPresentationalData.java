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
public class CardIdPresentationalData implements ICardIdPresentationalData {
	
	@NotNull
	private String cardId;
	
	@NotNull
	private String testId;
	
	@NotNull
	private String contentHash;
	
	
	public CardIdPresentationalData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("testId") String testId,
		@JsonProperty("contentHash") String contentHash
	) {
		this.cardId = cardId;
		this.testId = testId;
		this.contentHash = contentHash;
		
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardIdPresentationalData withCardId(String cardId) {
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
	public CardIdPresentationalData withTestId(String testId) {
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
	public CardIdPresentationalData withContentHash(String contentHash) {
		this.contentHash = contentHash;
		return this;
	}
	
}

/*       S.D.G.       */
