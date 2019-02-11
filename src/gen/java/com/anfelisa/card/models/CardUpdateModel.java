/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CardUpdateModel implements ICardUpdateModel {

	@NotNull
	private String cardId;
	
	@NotEmpty
	private String given;
	
	@NotEmpty
	private String wanted;
	
	private String image;
	
	private String userId;
	

	public CardUpdateModel() {
	}

	public CardUpdateModel(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image,
		@JsonProperty("userId") String userId
	) {
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
		this.userId = userId;
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
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.card.models.ICardUpdateModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCardId() == null && other.getCardId() == null) && !this.getCardId().equals(other.getCardId())) {
			differingAttributes.add("cardId: " + this.getCardId() + " " + other.getCardId());
		}
		if (!(this.getGiven() == null && other.getGiven() == null) && !this.getGiven().equals(other.getGiven())) {
			differingAttributes.add("given: " + this.getGiven() + " " + other.getGiven());
		}
		if (!(this.getWanted() == null && other.getWanted() == null) && !this.getWanted().equals(other.getWanted())) {
			differingAttributes.add("wanted: " + this.getWanted() + " " + other.getWanted());
		}
		if (!(this.getImage() == null && other.getImage() == null) && !this.getImage().equals(other.getImage())) {
			differingAttributes.add("image: " + this.getImage() + " " + other.getImage());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		return differingAttributes;
	}
	
}




/******* S.D.G. *******/



