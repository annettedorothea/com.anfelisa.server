package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=BoxIdListModel.class)
public interface IBoxIdListModel {

	java.util.List<Integer> getBoxIds();
	java.util.List<Integer> getNumberOfInsertedCards();
	java.util.List<String> getBoxNames();

	java.util.List<com.anfelisa.box.models.ICardOfBoxModel> getCardsToBeAdded();

}

/*       S.D.G.       */
