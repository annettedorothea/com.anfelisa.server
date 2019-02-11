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




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.card.models.ICardCreationModel;
import com.anfelisa.card.models.ICardModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractCardCreationData extends AbstractData implements ICardCreationData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCardCreationData.class);
	
	private String userId;
	
	private String username;
	
	@NotNull
	private String cardId;
	
	private String given;
	
	private String wanted;
	
	private String image;
	
	@NotNull
	private String cardAuthor;
	
	@NotNull
	private Integer cardIndex;
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String rootCategoryId;
	

	public AbstractCardCreationData(
		@JsonProperty("userId") String userId,
		@JsonProperty("username") String username,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image,
		@JsonProperty("cardAuthor") String cardAuthor,
		@JsonProperty("cardIndex") Integer cardIndex,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.username = username;
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
		this.cardAuthor = cardAuthor;
		this.cardIndex = cardIndex;
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
	}

	public AbstractCardCreationData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ICardCreationData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public ICardCreationData withUsername(String username) {
		this.username = username;
		return this;
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public ICardCreationData withCardId(String cardId) {
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
	public ICardCreationData withGiven(String given) {
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
	public ICardCreationData withWanted(String wanted) {
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
	public ICardCreationData withImage(String image) {
		this.image = image;
		return this;
	}
	
	@JsonProperty
	public String getCardAuthor() {
		return this.cardAuthor;
	}
	public void setCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
	}
	public ICardCreationData withCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
		return this;
	}
	
	@JsonProperty
	public Integer getCardIndex() {
		return this.cardIndex;
	}
	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}
	public ICardCreationData withCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ICardCreationData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public ICardCreationData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.card.models.ICardModel model) {
		this.cardId = model.getCardId();
		this.given = model.getGiven();
		this.wanted = model.getWanted();
		this.image = model.getImage();
		this.cardAuthor = model.getCardAuthor();
		this.cardIndex = model.getCardIndex();
		this.categoryId = model.getCategoryId();
		this.rootCategoryId = model.getRootCategoryId();
	}
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.card.models.ICardCreationModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getUsername() == null && other.getUsername() == null) && !this.getUsername().equals(other.getUsername())) {
			differingAttributes.add("username: " + this.getUsername() + " " + other.getUsername());
		}
		return differingAttributes;
	}
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.card.models.ICardModel other) {
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
		if (!(this.getCardAuthor() == null && other.getCardAuthor() == null) && !this.getCardAuthor().equals(other.getCardAuthor())) {
			differingAttributes.add("cardAuthor: " + this.getCardAuthor() + " " + other.getCardAuthor());
		}
		if (!(this.getCardIndex() == null && other.getCardIndex() == null) && !this.getCardIndex().equals(other.getCardIndex())) {
			differingAttributes.add("cardIndex: " + this.getCardIndex() + " " + other.getCardIndex());
		}
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getRootCategoryId() == null && other.getRootCategoryId() == null) && !this.getRootCategoryId().equals(other.getRootCategoryId())) {
			differingAttributes.add("rootCategoryId: " + this.getRootCategoryId() + " " + other.getRootCategoryId());
		}
		return differingAttributes;
	}
	
	
}




/******* S.D.G. *******/



