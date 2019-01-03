package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardTranslationModel.class)
public interface ICardTranslationModel {

	String getSourceValue();
	void setSourceValue(String sourceValue);
	
	String getTargetValue();
	void setTargetValue(String targetValue);
	
	String getSourceLanguage();
	void setSourceLanguage(String sourceLanguage);
	
	String getTargetLanguage();
	void setTargetLanguage(String targetLanguage);
	

}

/*       S.D.G.       */
