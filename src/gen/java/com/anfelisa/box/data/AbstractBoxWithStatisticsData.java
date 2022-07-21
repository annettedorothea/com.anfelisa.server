/********************************************************************************
 * generated by de.acegen
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
import com.anfelisa.box.models.IBoxWithStatisticsModel;
import com.anfelisa.box.models.IBoxViewModel;
import com.anfelisa.box.models.IBoxStatisticsModel;

import de.acegen.AbstractData;
import de.acegen.IDataContainer;
import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;

@SuppressWarnings("unused")
public abstract class AbstractBoxWithStatisticsData extends AbstractData implements IBoxWithStatisticsData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxWithStatisticsData.class);
	
	private Integer openTodaysCards;
	
	private String categoryName;
	
	private Boolean editable = false;
	
	private Boolean deletable = false;
	
	private String boxId;
	
	private String categoryId;
	
	private Integer maxCardsPerDay;
	
	private Boolean reverse = false;
	
	private Boolean archived = false;
	
	private Integer quality0Count;
	
	private Integer quality1Count;
	
	private Integer quality2Count;
	
	private Integer quality3Count;
	
	private Integer quality4Count;
	
	private Integer quality5Count;
	
	private java.util.List<Integer> countsPerDayNextWeek;
	

	public AbstractBoxWithStatisticsData(
		@JsonProperty("openTodaysCards") Integer openTodaysCards,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("editable") Boolean editable,
		@JsonProperty("deletable") Boolean deletable,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay,
		@JsonProperty("reverse") Boolean reverse,
		@JsonProperty("archived") Boolean archived,
		@JsonProperty("quality0Count") Integer quality0Count,
		@JsonProperty("quality1Count") Integer quality1Count,
		@JsonProperty("quality2Count") Integer quality2Count,
		@JsonProperty("quality3Count") Integer quality3Count,
		@JsonProperty("quality4Count") Integer quality4Count,
		@JsonProperty("quality5Count") Integer quality5Count,
		@JsonProperty("countsPerDayNextWeek") java.util.List<Integer> countsPerDayNextWeek
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.openTodaysCards = openTodaysCards;
		this.categoryName = categoryName;
		this.editable = editable;
		this.deletable = deletable;
		this.boxId = boxId;
		this.categoryId = categoryId;
		this.maxCardsPerDay = maxCardsPerDay;
		this.reverse = reverse;
		this.archived = archived;
		this.quality0Count = quality0Count;
		this.quality1Count = quality1Count;
		this.quality2Count = quality2Count;
		this.quality3Count = quality3Count;
		this.quality4Count = quality4Count;
		this.quality5Count = quality5Count;
		this.countsPerDayNextWeek = countsPerDayNextWeek;
	}

	public AbstractBoxWithStatisticsData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public Integer getOpenTodaysCards() {
		return this.openTodaysCards;
	}
	public void setOpenTodaysCards(Integer openTodaysCards) {
		this.openTodaysCards = openTodaysCards;
	}
	public IBoxWithStatisticsData withOpenTodaysCards(Integer openTodaysCards) {
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
	public IBoxWithStatisticsData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public Boolean getEditable() {
		return this.editable;
	}
	public void setEditable(Boolean editable) {
		this.editable = editable;
	}
	public IBoxWithStatisticsData withEditable(Boolean editable) {
		this.editable = editable;
		return this;
	}
	
	@JsonProperty
	public Boolean getDeletable() {
		return this.deletable;
	}
	public void setDeletable(Boolean deletable) {
		this.deletable = deletable;
	}
	public IBoxWithStatisticsData withDeletable(Boolean deletable) {
		this.deletable = deletable;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IBoxWithStatisticsData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IBoxWithStatisticsData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	public void setMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
	}
	public IBoxWithStatisticsData withMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
		return this;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	public void setReverse(Boolean reverse) {
		this.reverse = reverse;
	}
	public IBoxWithStatisticsData withReverse(Boolean reverse) {
		this.reverse = reverse;
		return this;
	}
	
	@JsonProperty
	public Boolean getArchived() {
		return this.archived;
	}
	public void setArchived(Boolean archived) {
		this.archived = archived;
	}
	public IBoxWithStatisticsData withArchived(Boolean archived) {
		this.archived = archived;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality0Count() {
		return this.quality0Count;
	}
	public void setQuality0Count(Integer quality0Count) {
		this.quality0Count = quality0Count;
	}
	public IBoxWithStatisticsData withQuality0Count(Integer quality0Count) {
		this.quality0Count = quality0Count;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality1Count() {
		return this.quality1Count;
	}
	public void setQuality1Count(Integer quality1Count) {
		this.quality1Count = quality1Count;
	}
	public IBoxWithStatisticsData withQuality1Count(Integer quality1Count) {
		this.quality1Count = quality1Count;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality2Count() {
		return this.quality2Count;
	}
	public void setQuality2Count(Integer quality2Count) {
		this.quality2Count = quality2Count;
	}
	public IBoxWithStatisticsData withQuality2Count(Integer quality2Count) {
		this.quality2Count = quality2Count;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality3Count() {
		return this.quality3Count;
	}
	public void setQuality3Count(Integer quality3Count) {
		this.quality3Count = quality3Count;
	}
	public IBoxWithStatisticsData withQuality3Count(Integer quality3Count) {
		this.quality3Count = quality3Count;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality4Count() {
		return this.quality4Count;
	}
	public void setQuality4Count(Integer quality4Count) {
		this.quality4Count = quality4Count;
	}
	public IBoxWithStatisticsData withQuality4Count(Integer quality4Count) {
		this.quality4Count = quality4Count;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality5Count() {
		return this.quality5Count;
	}
	public void setQuality5Count(Integer quality5Count) {
		this.quality5Count = quality5Count;
	}
	public IBoxWithStatisticsData withQuality5Count(Integer quality5Count) {
		this.quality5Count = quality5Count;
		return this;
	}
	
	@JsonProperty
	public java.util.List<Integer> getCountsPerDayNextWeek() {
		return this.countsPerDayNextWeek;
	}
	public void setCountsPerDayNextWeek(java.util.List<Integer> countsPerDayNextWeek) {
		this.countsPerDayNextWeek = countsPerDayNextWeek;
	}
	public IBoxWithStatisticsData withCountsPerDayNextWeek(java.util.List<Integer> countsPerDayNextWeek) {
		this.countsPerDayNextWeek = countsPerDayNextWeek;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.box.models.IBoxViewModel model) {
		this.openTodaysCards = model.getOpenTodaysCards();
		this.categoryName = model.getCategoryName();
		this.editable = model.getEditable();
		this.deletable = model.getDeletable();
		this.boxId = model.getBoxId();
		this.categoryId = model.getCategoryId();
		this.maxCardsPerDay = model.getMaxCardsPerDay();
		this.reverse = model.getReverse();
		this.archived = model.getArchived();
	}
	public void mapFrom(com.anfelisa.box.models.IBoxStatisticsModel model) {
		this.boxId = model.getBoxId();
		this.quality0Count = model.getQuality0Count();
		this.quality1Count = model.getQuality1Count();
		this.quality2Count = model.getQuality2Count();
		this.quality3Count = model.getQuality3Count();
		this.quality4Count = model.getQuality4Count();
		this.quality5Count = model.getQuality5Count();
		this.countsPerDayNextWeek = model.getCountsPerDayNextWeek();
		this.maxCardsPerDay = model.getMaxCardsPerDay();
	}
	
	public IBoxWithStatisticsData deepCopy() {
		IBoxWithStatisticsData copy = new BoxWithStatisticsData(this.getUuid());
		copy.setOpenTodaysCards(this.getOpenTodaysCards());
		copy.setCategoryName(this.getCategoryName());
		copy.setEditable(this.getEditable());
		copy.setDeletable(this.getDeletable());
		copy.setBoxId(this.getBoxId());
		copy.setCategoryId(this.getCategoryId());
		copy.setMaxCardsPerDay(this.getMaxCardsPerDay());
		copy.setReverse(this.getReverse());
		copy.setArchived(this.getArchived());
		copy.setQuality0Count(this.getQuality0Count());
		copy.setQuality1Count(this.getQuality1Count());
		copy.setQuality2Count(this.getQuality2Count());
		copy.setQuality3Count(this.getQuality3Count());
		copy.setQuality4Count(this.getQuality4Count());
		copy.setQuality5Count(this.getQuality5Count());
		List<Integer> countsPerDayNextWeekCopy = new ArrayList<Integer>();
		if (this.getCountsPerDayNextWeek() != null) {
			for(Integer item: this.getCountsPerDayNextWeek()) {
				countsPerDayNextWeekCopy.add(item);
			}
		}
		copy.setCountsPerDayNextWeek(countsPerDayNextWeekCopy);
		copy.setSystemTime(this.getSystemTime());
		return copy;
	}

}



/******* S.D.G. *******/



