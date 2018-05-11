package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("all")
public class BoxInfoModel implements IBoxInfoModel {

	private Integer todaysCards;
	
	private Boolean hasOpenCards = false;
	
	private com.anfelisa.box.models.IBoxModel box;
	

	public BoxInfoModel(
		@JsonProperty("todaysCards") Integer todaysCards,
		@JsonProperty("hasOpenCards") Boolean hasOpenCards,
		@JsonProperty("box") com.anfelisa.box.models.IBoxModel box
	) {
		this.todaysCards = todaysCards;
		this.hasOpenCards = hasOpenCards;
		this.box = box;
	}

	@JsonProperty
	public Integer getTodaysCards() {
		return this.todaysCards;
	}
	public void setTodaysCards(Integer todaysCards) {
		this.todaysCards = todaysCards;
	}
	
	@JsonProperty
	public Boolean getHasOpenCards() {
		return this.hasOpenCards;
	}
	public void setHasOpenCards(Boolean hasOpenCards) {
		this.hasOpenCards = hasOpenCards;
	}
	
	@JsonProperty
	public com.anfelisa.box.models.IBoxModel getBox() {
		return this.box;
	}
	public void setBox(com.anfelisa.box.models.IBoxModel box) {
		this.box = box;
	}
	

}

/*       S.D.G.       */
