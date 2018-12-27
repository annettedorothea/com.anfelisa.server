package com.anfelisa.card.data;

import org.hibernate.validator.constraints.NotEmpty;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardTranslationData extends AbstractData implements ICardTranslationData {
	
	@NotEmpty
	private String sourceValue;
	
	@NotEmpty
	private String targetValue;
	
	@NotEmpty
	private String sourceLanguage;
	
	@NotEmpty
	private String targetLanguage;
	

	public CardTranslationData(
		@JsonProperty("sourceValue") String sourceValue,
		@JsonProperty("targetValue") String targetValue,
		@JsonProperty("sourceLanguage") String sourceLanguage,
		@JsonProperty("targetLanguage") String targetLanguage
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.sourceValue = sourceValue;
		this.targetValue = targetValue;
		this.sourceLanguage = sourceLanguage;
		this.targetLanguage = targetLanguage;
	}

	public CardTranslationData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getSourceValue() {
		return this.sourceValue;
	}
	public void setSourceValue(String sourceValue) {
		this.sourceValue = sourceValue;
	}
	public CardTranslationData withSourceValue(String sourceValue) {
		this.sourceValue = sourceValue;
		return this;
	}
	
	@JsonProperty
	public String getTargetValue() {
		return this.targetValue;
	}
	public void setTargetValue(String targetValue) {
		this.targetValue = targetValue;
	}
	public CardTranslationData withTargetValue(String targetValue) {
		this.targetValue = targetValue;
		return this;
	}
	
	@JsonProperty
	public String getSourceLanguage() {
		return this.sourceLanguage;
	}
	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}
	public CardTranslationData withSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
		return this;
	}
	
	@JsonProperty
	public String getTargetLanguage() {
		return this.targetLanguage;
	}
	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}
	public CardTranslationData withTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
		return this;
	}
	

}

/*       S.D.G.       */
