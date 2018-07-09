package com.anfelisa.card.data;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardUpdateData extends AbstractData implements ICardUpdateData {
	
	@NotNull
	private String cardId;
	
	@NotEmpty
	private String given;
	
	@NotEmpty
	private String wanted;
	
	private String image;
	
	@NotNull
	private String userId;
	

	public CardUpdateData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
		this.userId = userId;
	}

	public CardUpdateData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardUpdateData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	public CardUpdateData withGiven(String given) {
		this.given = given;
		return this;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	public CardUpdateData withWanted(String wanted) {
		this.wanted = wanted;
		return this;
	}
	
	@JsonProperty
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public CardUpdateData withImage(String image) {
		this.image = image;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public CardUpdateData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CardUpdatePresentationalData(
			this.cardId,
			this.given,
			this.wanted,
			this.image,
			this.userId
		);
	}

}

/*       S.D.G.       */
