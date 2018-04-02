package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=ContentHashesOfCreatedCardsModel.class)
public interface IContentHashesOfCreatedCardsModel {

	String getTestId();
	java.util.List<String> getContentHashesOfCreatedCards();
	java.util.List<String> getContentHashesOfObsoleteCards();

}

/*       S.D.G.       */
