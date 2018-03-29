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
	private Integer cardId;
	
	@NotNull
	private Integer testId;
	
	@NotNull
	private String contentHash;
	
	
	public CardIdPresentationalData(
		@JsonProperty("cardId") Integer cardId,
		@JsonProperty("testId") Integer testId,
		@JsonProperty("contentHash") String contentHash
	) {
		this.cardId = cardId;
		this.testId = testId;
		this.contentHash = contentHash;
		
	}

	@JsonProperty
	public Integer getCardId() {
		return this.cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public CardIdPresentationalData withCardId(Integer cardId) {
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
	public CardIdPresentationalData withTestId(Integer testId) {
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
