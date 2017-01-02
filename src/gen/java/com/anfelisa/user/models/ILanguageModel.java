package com.anfelisa.user.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=LanguageModel.class)
public interface ILanguageModel {

	String getLanguage();


}

/*       S.D.G.       */
