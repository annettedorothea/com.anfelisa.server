/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.card.models.ICardWithCategoryNameModel;
import com.anfelisa.card.models.ICardModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractCardWithCategoryNameData extends AbstractData implements ICardWithCategoryNameData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCardWithCategoryNameData.class);
	
	private String categoryName;
	
	private String cardId;
	
	private String given;
	
	private String wanted;
	
	private String cardAuthor;
	
	private Integer cardIndex;
	
	private String categoryId;
	
	private String rootCategoryId;
	
	private Integer priority;
	

	public AbstractCardWithCategoryNameData(
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("cardId") String cardId,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("cardAuthor") String cardAuthor,
		@JsonProperty("cardIndex") Integer cardIndex,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("priority") Integer priority
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryName = categoryName;
		this.cardId = cardId;
		this.given = given;
		this.wanted = wanted;
		this.cardAuthor = cardAuthor;
		this.cardIndex = cardIndex;
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.priority = priority;
	}

	public AbstractCardWithCategoryNameData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public ICardWithCategoryNameData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public String getCardId() {
		return this.cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public ICardWithCategoryNameData withCardId(String cardId) {
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
	public ICardWithCategoryNameData withGiven(String given) {
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
	public ICardWithCategoryNameData withWanted(String wanted) {
		this.wanted = wanted;
		return this;
	}
	
	@JsonProperty
	public String getCardAuthor() {
		return this.cardAuthor;
	}
	public void setCardAuthor(String cardAuthor) {
		this.cardAuthor = cardAuthor;
	}
	public ICardWithCategoryNameData withCardAuthor(String cardAuthor) {
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
	public ICardWithCategoryNameData withCardIndex(Integer cardIndex) {
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
	public ICardWithCategoryNameData withCategoryId(String categoryId) {
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
	public ICardWithCategoryNameData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
	public Integer getPriority() {
		return this.priority;
	}
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	public ICardWithCategoryNameData withPriority(Integer priority) {
		this.priority = priority;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.card.models.ICardModel model) {
		this.cardId = model.getCardId();
		this.given = model.getGiven();
		this.wanted = model.getWanted();
		this.cardAuthor = model.getCardAuthor();
		this.cardIndex = model.getCardIndex();
		this.categoryId = model.getCategoryId();
		this.rootCategoryId = model.getRootCategoryId();
		this.priority = model.getPriority();
	}
	
	public ICardWithCategoryNameData deepCopy() {
		ICardWithCategoryNameData copy = new CardWithCategoryNameData(this.getUuid());
		copy.setCategoryName(this.getCategoryName());
		copy.setCardId(this.getCardId());
		copy.setGiven(this.getGiven());
		copy.setWanted(this.getWanted());
		copy.setCardAuthor(this.getCardAuthor());
		copy.setCardIndex(this.getCardIndex());
		copy.setCategoryId(this.getCategoryId());
		copy.setRootCategoryId(this.getRootCategoryId());
		copy.setPriority(this.getPriority());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



