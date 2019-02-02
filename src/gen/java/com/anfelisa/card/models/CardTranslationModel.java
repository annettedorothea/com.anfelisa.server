package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CardTranslationModel implements ICardTranslationModel {

	@NotEmpty
	private String sourceValue;
	
	@NotEmpty
	private String targetValue;
	
	@NotEmpty
	private String sourceLanguage;
	
	@NotEmpty
	private String targetLanguage;
	

	public CardTranslationModel() {
	}

	public CardTranslationModel(
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
	
	@JsonProperty
	public String getTargetValue() {
		return this.targetValue;
	}
	public void setTargetValue(String targetValue) {
		this.targetValue = targetValue;
	}
	
	@JsonProperty
	public String getSourceLanguage() {
		return this.sourceLanguage;
	}
	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}
	
	@JsonProperty
	public String getTargetLanguage() {
		return this.targetLanguage;
	}
	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}
	
	
	public List<String> equalsPrimitiveTypes(ICardTranslationModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getSourceValue() == null && other.getSourceValue() == null) && !this.getSourceValue().equals(other.getSourceValue())) {
			differingAttributes.add("sourceValue: " + this.getSourceValue() + " " + other.getSourceValue());
		}
		if (!(this.getTargetValue() == null && other.getTargetValue() == null) && !this.getTargetValue().equals(other.getTargetValue())) {
			differingAttributes.add("targetValue: " + this.getTargetValue() + " " + other.getTargetValue());
		}
		if (!(this.getSourceLanguage() == null && other.getSourceLanguage() == null) && !this.getSourceLanguage().equals(other.getSourceLanguage())) {
			differingAttributes.add("sourceLanguage: " + this.getSourceLanguage() + " " + other.getSourceLanguage());
		}
		if (!(this.getTargetLanguage() == null && other.getTargetLanguage() == null) && !this.getTargetLanguage().equals(other.getTargetLanguage())) {
			differingAttributes.add("targetLanguage: " + this.getTargetLanguage() + " " + other.getTargetLanguage());
		}
		return differingAttributes;
	}
	
}

/*       S.D.G.       */
