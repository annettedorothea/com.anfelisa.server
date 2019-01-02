package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractCardTranslationData extends AbstractData implements ICardTranslationData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCardTranslationData.class);
	
	@NotEmpty
	private String sourceValue;
	
	@NotEmpty
	private String targetValue;
	
	@NotEmpty
	private String sourceLanguage;
	
	@NotEmpty
	private String targetLanguage;
	

	public AbstractCardTranslationData(
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

	public AbstractCardTranslationData( String uuid ) {
		super(uuid);
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
	
	
}

/*       S.D.G.       */
