/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.card.models.ICardTranslationModel;

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
	public ICardTranslationData withSourceValue(String sourceValue) {
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
	public ICardTranslationData withTargetValue(String targetValue) {
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
	public ICardTranslationData withSourceLanguage(String sourceLanguage) {
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
	public ICardTranslationData withTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.card.models.ICardTranslationModel other) {
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




/******* S.D.G. *******/



