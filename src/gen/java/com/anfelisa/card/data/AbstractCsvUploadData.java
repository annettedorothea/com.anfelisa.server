/********************************************************************************
 * generated by de.acegen 1.3.0
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
import com.anfelisa.card.models.ICsvUploadModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractCsvUploadData extends AbstractData implements ICsvUploadData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractCsvUploadData.class);
	
	private String userId;
	
	private String categoryId;
	
	private java.util.List<com.anfelisa.card.models.ISimpleCardModel> previewCsv;
	
	private java.util.List<com.anfelisa.card.models.ICardModel> cards;
	

	public AbstractCsvUploadData(
		@JsonProperty("userId") String userId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("previewCsv") java.util.List<com.anfelisa.card.models.ISimpleCardModel> previewCsv,
		@JsonProperty("cards") java.util.List<com.anfelisa.card.models.ICardModel> cards
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.categoryId = categoryId;
		this.previewCsv = previewCsv;
		this.cards = cards;
	}

	public AbstractCsvUploadData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public ICsvUploadData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public ICsvUploadData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ISimpleCardModel> getPreviewCsv() {
		return this.previewCsv;
	}
	public void setPreviewCsv(java.util.List<com.anfelisa.card.models.ISimpleCardModel> previewCsv) {
		this.previewCsv = previewCsv;
	}
	public ICsvUploadData withPreviewCsv(java.util.List<com.anfelisa.card.models.ISimpleCardModel> previewCsv) {
		this.previewCsv = previewCsv;
		return this;
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.card.models.ICardModel> getCards() {
		return this.cards;
	}
	public void setCards(java.util.List<com.anfelisa.card.models.ICardModel> cards) {
		this.cards = cards;
	}
	public ICsvUploadData withCards(java.util.List<com.anfelisa.card.models.ICardModel> cards) {
		this.cards = cards;
		return this;
	}
	
	
	
	public ICsvUploadData deepCopy() {
		ICsvUploadData copy = new CsvUploadData(this.getUuid());
		copy.setUserId(this.getUserId());
		copy.setCategoryId(this.getCategoryId());
		List<com.anfelisa.card.models.ISimpleCardModel> previewCsvCopy = new ArrayList<com.anfelisa.card.models.ISimpleCardModel>();
		for(com.anfelisa.card.models.ISimpleCardModel item: this.getPreviewCsv()) {
			previewCsvCopy.add(item.deepCopy());
		}
		copy.setPreviewCsv(previewCsvCopy);
		List<com.anfelisa.card.models.ICardModel> cardsCopy = new ArrayList<com.anfelisa.card.models.ICardModel>();
		for(com.anfelisa.card.models.ICardModel item: this.getCards()) {
			cardsCopy.add(item.deepCopy());
		}
		copy.setCards(cardsCopy);
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



