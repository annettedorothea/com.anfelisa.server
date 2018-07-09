package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardTranslationModel;

@SuppressWarnings("all")
public class CardTranslationPresentationalData implements ICardTranslationPresentationalData {
	
	@NotEmpty
	private String sourceValue;
	
	@NotEmpty
	private String targetValue;
	
	@NotEmpty
	private String sourceLanguage;
	
	@NotEmpty
	private String targetLanguage;
	
	
	public CardTranslationPresentationalData(
		@JsonProperty("sourceValue") String sourceValue,
		@JsonProperty("targetValue") String targetValue,
		@JsonProperty("sourceLanguage") String sourceLanguage,
		@JsonProperty("targetLanguage") String targetLanguage
	) {
		this.sourceValue = sourceValue;
		this.targetValue = targetValue;
		this.sourceLanguage = sourceLanguage;
		this.targetLanguage = targetLanguage;
		
	}

	@JsonProperty
	public String getSourceValue() {
		return this.sourceValue;
	}
	public void setSourceValue(String sourceValue) {
		this.sourceValue = sourceValue;
	}
	public CardTranslationPresentationalData withSourceValue(String sourceValue) {
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
	public CardTranslationPresentationalData withTargetValue(String targetValue) {
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
	public CardTranslationPresentationalData withSourceLanguage(String sourceLanguage) {
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
	public CardTranslationPresentationalData withTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
		return this;
	}
	
}

/*       S.D.G.       */
