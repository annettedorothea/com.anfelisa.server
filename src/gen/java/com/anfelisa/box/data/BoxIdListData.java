package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxIdListModel;

@SuppressWarnings("unused")
public class BoxIdListData implements IBoxIdListData {
	
	private String uuid;
	
	private String schema;
	
	private java.util.List<Integer> boxIds;
	
	private java.util.List<Integer> numberOfInsertedCards;
	
	private java.util.List<String> boxNames;
	

	private java.util.List<com.anfelisa.box.models.ICardOfBoxModel> cardsToBeAdded;
	

	public BoxIdListData(
		@JsonProperty("boxIds") java.util.List<Integer> boxIds,
		@JsonProperty("numberOfInsertedCards") java.util.List<Integer> numberOfInsertedCards,
		@JsonProperty("boxNames") java.util.List<String> boxNames
,		@JsonProperty("uuid") String uuid,
		@JsonProperty("schema") String schema
	) {
		this.boxIds = boxIds;
		this.numberOfInsertedCards = numberOfInsertedCards;
		this.boxNames = boxNames;
		this.uuid = uuid;
		this.schema = schema;
	}

	public BoxIdListData( String uuid,	String schema ) {
		this.uuid = uuid;
		this.schema = schema;
	}

	@JsonProperty
	public java.util.List<Integer> getBoxIds() {
		return this.boxIds;
	}
	public void setBoxIds(java.util.List<Integer> boxIds) {
		this.boxIds = boxIds;
	}
	public BoxIdListData withBoxIds(java.util.List<Integer> boxIds) {
		this.boxIds = boxIds;
		return this;
	}
	
	@JsonProperty
	public java.util.List<Integer> getNumberOfInsertedCards() {
		return this.numberOfInsertedCards;
	}
	public void setNumberOfInsertedCards(java.util.List<Integer> numberOfInsertedCards) {
		this.numberOfInsertedCards = numberOfInsertedCards;
	}
	public BoxIdListData withNumberOfInsertedCards(java.util.List<Integer> numberOfInsertedCards) {
		this.numberOfInsertedCards = numberOfInsertedCards;
		return this;
	}
	
	@JsonProperty
	public java.util.List<String> getBoxNames() {
		return this.boxNames;
	}
	public void setBoxNames(java.util.List<String> boxNames) {
		this.boxNames = boxNames;
	}
	public BoxIdListData withBoxNames(java.util.List<String> boxNames) {
		this.boxNames = boxNames;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.box.models.ICardOfBoxModel> getCardsToBeAdded() {
		return this.cardsToBeAdded;
	}
	public void setCardsToBeAdded(java.util.List<com.anfelisa.box.models.ICardOfBoxModel> cardsToBeAdded) {
		this.cardsToBeAdded = cardsToBeAdded;
	}
	

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	@JsonProperty
	public String getSchema() {
		return this.schema;
	}

}

/*       S.D.G.       */
