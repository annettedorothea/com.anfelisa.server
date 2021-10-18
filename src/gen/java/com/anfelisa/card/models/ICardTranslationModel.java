/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package com.anfelisa.card.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
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
	
	
	ICardTranslationModel deepCopy();
}




/******* S.D.G. *******/



