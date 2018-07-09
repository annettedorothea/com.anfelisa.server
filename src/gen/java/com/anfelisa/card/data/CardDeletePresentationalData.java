package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.card.models.ICardDeleteModel;
import com.anfelisa.user.models.IUserIdModel;

@SuppressWarnings("all")
public class CardDeletePresentationalData implements ICardDeletePresentationalData {
	
	@NotNull
	private String cardId;
	
	@NotNull
	private Integer cardIndex;
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String userId;
	
	
	public CardDeletePresentationalData(
		@JsonProperty("cardId") String cardId,
		@JsonProperty("cardIndex") Integer cardIndex,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId
	) {
		this.cardId = cardId;
		this.cardIndex = cardIndex;
		this.categoryId = categoryId;
		this.userId = userId;
		
	}

	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public CardDeletePresentationalData withCardId(String cardId) {
		this.cardId = cardId;
		return this;
	}
	
	@JsonProperty
	public Integer getCardIndex() {
		return this.cardIndex;
	}
	public void setCardIndex(Integer cardIndex) {
		this.cardIndex = cardIndex;
	}
	public CardDeletePresentationalData withCardIndex(Integer cardIndex) {
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
	public CardDeletePresentationalData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public CardDeletePresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
}

/*       S.D.G.       */
