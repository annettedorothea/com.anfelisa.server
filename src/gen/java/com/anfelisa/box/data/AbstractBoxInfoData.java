package com.anfelisa.box.data;

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
public abstract class AbstractBoxInfoData extends AbstractData implements IBoxInfoData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxInfoData.class);
	
	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	
	private Integer todaysCards;
	
	private Integer totalCards;
	
	private Integer reinforceCards;
	
	private Integer myCards;
	
	private Integer daysBehindSchedule;
	
	@NotNull
	private String categoryName;
	
	private Integer maxInterval;
	
	private Integer quality0Count;
	
	private Integer quality1Count;
	
	private Integer quality2Count;
	
	private Integer quality3Count;
	
	private Integer quality4Count;
	
	private Integer quality5Count;
	
	@NotNull
	private String boxId;
	

	public AbstractBoxInfoData(
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today,
		@JsonProperty("todaysCards") Integer todaysCards,
		@JsonProperty("totalCards") Integer totalCards,
		@JsonProperty("reinforceCards") Integer reinforceCards,
		@JsonProperty("myCards") Integer myCards,
		@JsonProperty("daysBehindSchedule") Integer daysBehindSchedule,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("maxInterval") Integer maxInterval,
		@JsonProperty("quality0Count") Integer quality0Count,
		@JsonProperty("quality1Count") Integer quality1Count,
		@JsonProperty("quality2Count") Integer quality2Count,
		@JsonProperty("quality3Count") Integer quality3Count,
		@JsonProperty("quality4Count") Integer quality4Count,
		@JsonProperty("quality5Count") Integer quality5Count,
		@JsonProperty("boxId") String boxId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.userId = userId;
		this.today = today;
		this.todaysCards = todaysCards;
		this.totalCards = totalCards;
		this.reinforceCards = reinforceCards;
		this.myCards = myCards;
		this.daysBehindSchedule = daysBehindSchedule;
		this.categoryName = categoryName;
		this.maxInterval = maxInterval;
		this.quality0Count = quality0Count;
		this.quality1Count = quality1Count;
		this.quality2Count = quality2Count;
		this.quality3Count = quality3Count;
		this.quality4Count = quality4Count;
		this.quality5Count = quality5Count;
		this.boxId = boxId;
	}

	public AbstractBoxInfoData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IBoxInfoData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	public IBoxInfoData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	
	@JsonProperty
	public Integer getTodaysCards() {
		return this.todaysCards;
	}
	public void setTodaysCards(Integer todaysCards) {
		this.todaysCards = todaysCards;
	}
	public IBoxInfoData withTodaysCards(Integer todaysCards) {
		this.todaysCards = todaysCards;
		return this;
	}
	
	@JsonProperty
	public Integer getTotalCards() {
		return this.totalCards;
	}
	public void setTotalCards(Integer totalCards) {
		this.totalCards = totalCards;
	}
	public IBoxInfoData withTotalCards(Integer totalCards) {
		this.totalCards = totalCards;
		return this;
	}
	
	@JsonProperty
	public Integer getReinforceCards() {
		return this.reinforceCards;
	}
	public void setReinforceCards(Integer reinforceCards) {
		this.reinforceCards = reinforceCards;
	}
	public IBoxInfoData withReinforceCards(Integer reinforceCards) {
		this.reinforceCards = reinforceCards;
		return this;
	}
	
	@JsonProperty
	public Integer getMyCards() {
		return this.myCards;
	}
	public void setMyCards(Integer myCards) {
		this.myCards = myCards;
	}
	public IBoxInfoData withMyCards(Integer myCards) {
		this.myCards = myCards;
		return this;
	}
	
	@JsonProperty
	public Integer getDaysBehindSchedule() {
		return this.daysBehindSchedule;
	}
	public void setDaysBehindSchedule(Integer daysBehindSchedule) {
		this.daysBehindSchedule = daysBehindSchedule;
	}
	public IBoxInfoData withDaysBehindSchedule(Integer daysBehindSchedule) {
		this.daysBehindSchedule = daysBehindSchedule;
		return this;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public IBoxInfoData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	public IBoxInfoData withMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
		return this;
	}
	
	@JsonProperty
	public Integer getQuality0Count() {
		return this.quality0Count;
	}
	public void setQuality0Count(Integer quality0Count) {
		this.quality0Count = quality0Count;
	}
	public IBoxInfoData withQuality0Count(Integer quality0Count) {
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
	public IBoxInfoData withQuality1Count(Integer quality1Count) {
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
	public IBoxInfoData withQuality2Count(Integer quality2Count) {
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
	public IBoxInfoData withQuality3Count(Integer quality3Count) {
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
	public IBoxInfoData withQuality4Count(Integer quality4Count) {
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
	public IBoxInfoData withQuality5Count(Integer quality5Count) {
		this.quality5Count = quality5Count;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IBoxInfoData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	
	public void mapFrom(com.anfelisa.box.models.IBoxViewModel model) {
		this.todaysCards = model.getTodaysCards();
		this.totalCards = model.getTotalCards();
		this.reinforceCards = model.getReinforceCards();
		this.myCards = model.getMyCards();
		this.daysBehindSchedule = model.getDaysBehindSchedule();
		this.categoryName = model.getCategoryName();
		this.maxInterval = model.getMaxInterval();
		this.quality0Count = model.getQuality0Count();
		this.quality1Count = model.getQuality1Count();
		this.quality2Count = model.getQuality2Count();
		this.quality3Count = model.getQuality3Count();
		this.quality4Count = model.getQuality4Count();
		this.quality5Count = model.getQuality5Count();
		this.boxId = model.getBoxId();
	}
}

/*       S.D.G.       */
