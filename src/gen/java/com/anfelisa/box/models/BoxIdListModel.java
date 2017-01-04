package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class BoxIdListModel implements IBoxIdListModel {

	private java.util.List<Integer> boxIds;
	
	private java.util.List<Integer> numberOfInsertedCards;
	
	private java.util.List<String> boxNames;
	

	private java.util.List<com.anfelisa.box.models.ICardOfBoxModel> cardsToBeAdded;
	

	public BoxIdListModel(
		@JsonProperty("boxIds") java.util.List<Integer> boxIds,
		@JsonProperty("numberOfInsertedCards") java.util.List<Integer> numberOfInsertedCards,
		@JsonProperty("boxNames") java.util.List<String> boxNames
	) {
		this.boxIds = boxIds;
		this.numberOfInsertedCards = numberOfInsertedCards;
		this.boxNames = boxNames;
	}

	@JsonProperty
	public java.util.List<Integer> getBoxIds() {
		return this.boxIds;
	}
	public void setBoxIds(java.util.List<Integer> boxIds) {
		this.boxIds = boxIds;
	}
	
	@JsonProperty
	public java.util.List<Integer> getNumberOfInsertedCards() {
		return this.numberOfInsertedCards;
	}
	public void setNumberOfInsertedCards(java.util.List<Integer> numberOfInsertedCards) {
		this.numberOfInsertedCards = numberOfInsertedCards;
	}
	
	@JsonProperty
	public java.util.List<String> getBoxNames() {
		return this.boxNames;
	}
	public void setBoxNames(java.util.List<String> boxNames) {
		this.boxNames = boxNames;
	}
	

	@JsonProperty
	public java.util.List<com.anfelisa.box.models.ICardOfBoxModel> getCardsToBeAdded() {
		return this.cardsToBeAdded;
	}
	public void setCardsToBeAdded(java.util.List<com.anfelisa.box.models.ICardOfBoxModel> cardsToBeAdded) {
		this.cardsToBeAdded = cardsToBeAdded;
	}
	

}

/*       S.D.G.       */
