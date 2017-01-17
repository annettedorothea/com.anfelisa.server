package com.anfelisa.box.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=FillBoxModel.class)
public interface IFillBoxModel {

	Integer getBoxId();

	java.util.List<com.anfelisa.box.models.IScheduledCardModel> getCardsToBeAdded();

}

/*       S.D.G.       */
