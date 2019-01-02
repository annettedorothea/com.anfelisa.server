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
public abstract class AbstractCardSearchData extends AbstractData implements ICardSearchData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCardSearchData.class);
	
	@NotNull
	private String given;
	
	@NotNull
	private String wanted;
	
	private String categoryId;
	
	private java.util.List<com.anfelisa.card.models.ICardModel> cardList;
	
	private Boolean naturalInputOrder = false;
	

	public AbstractCardSearchData(
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardModel> cardList,
		@JsonProperty("naturalInputOrder") Boolean naturalInputOrder
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.given = given;
		this.wanted = wanted;
		this.categoryId = categoryId;
		this.cardList = cardList;
		this.naturalInputOrder = naturalInputOrder;
	}

	public AbstractCardSearchData( String uuid ) {
		super(uuid);
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
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardModel> getCardList() {
		return this.cardList;
	}
	public void setCardList(java.util.List<com.anfelisa.card.models.ICardModel> cardList) {
		this.cardList = cardList;
	}
	
	@JsonProperty
	public Boolean getNaturalInputOrder() {
		return this.naturalInputOrder;
	}
	public void setNaturalInputOrder(Boolean naturalInputOrder) {
		this.naturalInputOrder = naturalInputOrder;
	}
	
	
}

/*       S.D.G.       */
