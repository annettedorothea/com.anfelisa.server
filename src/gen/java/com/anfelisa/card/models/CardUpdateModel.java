package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class CardUpdateModel implements ICardUpdateModel {

	@NotNull
	private String cardId;
	
	@NotEmpty
	private String given;
	
	@NotEmpty
	private String wanted;
	
	private String image;
	

	public CardUpdateModel(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image
	) {
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	
	@JsonProperty
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	

}

/*       S.D.G.       */
