package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxInfoModel;
import com.anfelisa.box.models.ITodayModel;
import com.anfelisa.user.models.IUserIdModel;

@SuppressWarnings("all")
public class BoxInfoPresentationalData implements IBoxInfoPresentationalData {
	
	private Integer todaysCards;
	
	private Integer totalCards;
	
	private Integer reinforceCards;
	
	private Integer myCards;
	
	private Integer daysBehindSchedule;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String categoryName;
	
	@NotNull
	private Integer categoryIndex;
	
	private Integer maxInterval;
	
	@NotNull
	private org.joda.time.DateTime today;
	
	@NotNull
	private String userId;
	
	
	public BoxInfoPresentationalData(
		@JsonProperty("todaysCards") Integer todaysCards,
		@JsonProperty("totalCards") Integer totalCards,
		@JsonProperty("reinforceCards") Integer reinforceCards,
		@JsonProperty("myCards") Integer myCards,
		@JsonProperty("daysBehindSchedule") Integer daysBehindSchedule,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("categoryName") String categoryName,
		@JsonProperty("categoryIndex") Integer categoryIndex,
		@JsonProperty("maxInterval") Integer maxInterval,
		@JsonProperty("today") org.joda.time.DateTime today,
		@JsonProperty("userId") String userId
	) {
		this.todaysCards = todaysCards;
		this.totalCards = totalCards;
		this.reinforceCards = reinforceCards;
		this.myCards = myCards;
		this.daysBehindSchedule = daysBehindSchedule;
		this.boxId = boxId;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryIndex = categoryIndex;
		this.maxInterval = maxInterval;
		this.today = today;
		this.userId = userId;
		
	}

	@JsonProperty
	public Integer getTodaysCards() {
		return this.todaysCards;
	}
	public void setTodaysCards(Integer todaysCards) {
		this.todaysCards = todaysCards;
	}
	public BoxInfoPresentationalData withTodaysCards(Integer todaysCards) {
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
	public BoxInfoPresentationalData withTotalCards(Integer totalCards) {
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
	public BoxInfoPresentationalData withReinforceCards(Integer reinforceCards) {
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
	public BoxInfoPresentationalData withMyCards(Integer myCards) {
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
	public BoxInfoPresentationalData withDaysBehindSchedule(Integer daysBehindSchedule) {
		this.daysBehindSchedule = daysBehindSchedule;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public BoxInfoPresentationalData withBoxId(String boxId) {
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
	public BoxInfoPresentationalData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryName() {
		return this.categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public BoxInfoPresentationalData withCategoryName(String categoryName) {
		this.categoryName = categoryName;
		return this;
	}
	
	@JsonProperty
	public Integer getCategoryIndex() {
		return this.categoryIndex;
	}
	public void setCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
	}
	public BoxInfoPresentationalData withCategoryIndex(Integer categoryIndex) {
		this.categoryIndex = categoryIndex;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	public BoxInfoPresentationalData withMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	public BoxInfoPresentationalData withToday(org.joda.time.DateTime today) {
		this.today = today;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public BoxInfoPresentationalData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
}

/*       S.D.G.       */
