package com.anfelisa.card.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CardTranslationModel.class)
public interface ICardTranslationModel {

	String getSourceValue();
	String getTargetValue();
	String getSourceLanguage();
	String getTargetLanguage();

}

/*       S.D.G.       */
