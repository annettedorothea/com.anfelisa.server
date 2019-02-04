package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class CardCreationModel implements ICardCreationModel {

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
	

	public CardCreationModel() {
	}

	public CardCreationModel(
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
	) {
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

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getCardAuthor() {
		return this.cardAuthor;
	}
	public void setCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
	}
	
	@JsonProperty
	public Integer getCardIndex() {
		return this.cardIndex;
	}
	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	
	
	public List<String> equalsPrimitiveTypes(ICardCreationModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getUsername() == null && other.getUsername() == null) && !this.getUsername().equals(other.getUsername())) {
			differingAttributes.add("username: " + this.getUsername() + " " + other.getUsername());
		}
		return differingAttributes;
	}
	public List<String> equalsPrimitiveTypes(ICardModel other) {
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

/*       S.D.G.       */
