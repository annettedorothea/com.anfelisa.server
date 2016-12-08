package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class BoxInfoModel implements IBoxInfoModel {

	private Integer todaysCards;
	
	private Boolean hasOpenCards;
	

	private com.anfelisa.box.models.IBoxModel box;
	

	public BoxInfoModel(
		@JsonProperty("todaysCards") Integer todaysCards,
		@JsonProperty("hasOpenCards") Boolean hasOpenCards
	) {
		this.todaysCards = todaysCards;
		this.hasOpenCards = hasOpenCards;
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
