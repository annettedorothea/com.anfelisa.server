package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class FillBoxModel implements IFillBoxModel {

	private String boxId;
	
	private java.util.List<com.anfelisa.box.models.IScheduledCardModel> cardsToBeAdded;
	

	public FillBoxModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("cardsToBeAdded") java.util.List<com.anfelisa.box.models.IScheduledCardModel> cardsToBeAdded
	) {
		this.boxId = boxId;
		this.cardsToBeAdded = cardsToBeAdded;
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.IScheduledCardModel> getCardsToBeAdded() {
		return this.cardsToBeAdded;
	}
	public void setCardsToBeAdded(java.util.List<com.anfelisa.box.models.IScheduledCardModel> cardsToBeAdded) {
		this.cardsToBeAdded = cardsToBeAdded;
	}
	

}

/*       S.D.G.       */
