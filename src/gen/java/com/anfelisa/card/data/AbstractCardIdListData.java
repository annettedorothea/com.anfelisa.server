package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractCardIdListData extends AbstractData implements ICardIdListData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCardIdListData.class);
	
	private java.util.List<String> cardIdList;
	
	private String categoryId;
	
	private String userId;
	
	private java.util.List<com.anfelisa.card.models.ICardModel> movedCards;
	

	public AbstractCardIdListData(
		@JsonProperty("cardIdList") java.util.List<String> cardIdList,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId,
		@JsonProperty("movedCards") java.util.List<com.anfelisa.card.models.ICardModel> movedCards
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.cardIdList = cardIdList;
		this.categoryId = categoryId;
		this.userId = userId;
		this.movedCards = movedCards;
	}

	public AbstractCardIdListData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public java.util.List<String> getCardIdList() {
		return this.cardIdList;
	}
	public void setCardIdList(java.util.List<String> cardIdList) {
		this.cardIdList = cardIdList;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardModel> getMovedCards() {
		return this.movedCards;
	}
	public void setMovedCards(java.util.List<com.anfelisa.card.models.ICardModel> movedCards) {
		this.movedCards = movedCards;
	}
	
	
}

/*       S.D.G.       */
