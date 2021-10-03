/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IBoxViewModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractBoxViewData extends AbstractData implements IBoxViewData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxViewData.class);
	
	private Integer openTodaysCards;
	
	private String categoryName;
	
	private String categoryAuthor;
	
	private String categoryId;
	
	private String boxId;
	
	private Boolean shared = false;
	
	private Boolean reverse = false;
	
	private Boolean editable = false;
	
	private Boolean archived = false;
	

	public AbstractBoxViewData(
		@JsonProperty("openTodaysCards") Integer openTodaysCards,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryAuthor") String categoryAuthor,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("shared") Boolean shared,
		@JsonProperty("reverse") Boolean reverse,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("archived") Boolean archived
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.openTodaysCards = openTodaysCards;
		this.categoryName = categoryName;
		this.categoryAuthor = categoryAuthor;
		this.categoryId = categoryId;
		this.boxId = boxId;
		this.shared = shared;
		this.reverse = reverse;
		this.editable = editable;
		this.archived = archived;
	}

	public AbstractBoxViewData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public Integer getOpenTodaysCards() {
		return this.openTodaysCards;
	}
	public void setOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
	}
	public IBoxViewData withOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
		return this;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public IBoxViewData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public String getCategoryAuthor() {
		return this.categoryAuthor;
	}
	public void setCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
	}
	public IBoxViewData withCategoryAuthor(String categoryAuthor) {
		this.categoryAuthor = categoryAuthor;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IBoxViewData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IBoxViewData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public Boolean getShared() {
		return this.shared;
	}
	public void setShared(Boolean shared) {
		this.shared = shared;
	}
	public IBoxViewData withShared(Boolean shared) {
		this.shared = shared;
		return this;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}
	public IBoxViewData withReverse(Boolean reverse) {
		this.reverse = reverse;
		return this;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public IBoxViewData withEditable(Boolean editable) {
		this.editable = editable;
		return this;
	}
	
	@JsonProperty
	public Boolean getArchived() {
		return this.archived;
	}
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
	public IBoxViewData withArchived(Boolean archived) {
		this.archived = archived;
		return this;
	}
	
	
	
	public IBoxViewData deepCopy() {
		IBoxViewData copy = new BoxViewData(this.getUuid());
		copy.setOpenTodaysCards(this.getOpenTodaysCards());
		copy.setCategoryName(this.getCategoryName());
		copy.setCategoryAuthor(this.getCategoryAuthor());
		copy.setCategoryId(this.getCategoryId());
		copy.setBoxId(this.getBoxId());
		copy.setShared(this.getShared());
		copy.setReverse(this.getReverse());
		copy.setEditable(this.getEditable());
		copy.setArchived(this.getArchived());
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



