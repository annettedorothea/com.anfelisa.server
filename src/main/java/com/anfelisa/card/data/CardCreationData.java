package com.anfelisa.card.data;

import javax.validation.constraints.NotNull;

import com.anfelisa.ace.AbstractData;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CardCreationData extends AbstractData implements ICardCreationData {
	
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
	
	@NotNull
	private String path;
	

	public CardCreationData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image,
		@JsonProperty("cardAuthor") String cardAuthor,
		@JsonProperty("cardIndex") Integer cardIndex,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("path") String path
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
		this.cardAuthor = cardAuthor;
		this.cardIndex = cardIndex;
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.path = path;
	}

	public CardCreationData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardCreationData withCardId(String cardId) {
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
	public CardCreationData withGiven(String given) {
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
	public CardCreationData withWanted(String wanted) {
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
	public CardCreationData withImage(String image) {
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
	public CardCreationData withCardAuthor(String cardAuthor) {
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
	public CardCreationData withCardIndex(Integer cardIndex) {
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
	public CardCreationData withCategoryId(String categoryId) {
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
	public CardCreationData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
	public String getPath() {
		return this.path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public CardCreationData withPath(String path) {
		this.path = path;
		return this;
	}
	

	@Override
	public Object toPresentationalData() {
		return new CardCreationPresentationalData(
			this.cardId,
			this.given,
			this.wanted,
			this.image,
			this.cardAuthor,
			this.cardIndex,
			this.categoryId,
			this.rootCategoryId,
			this.path
		);
	}

}

/*       S.D.G.       */
