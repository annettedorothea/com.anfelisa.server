/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;
import de.acegen.AbstractModel;

@SuppressWarnings("unused")
public class BoxStatisticsModel extends AbstractModel {

	private String boxId;

	private Integer quality0Count;

	private Integer quality1Count;

	private Integer quality2Count;

	private Integer quality3Count;

	private Integer quality4Count;

	private Integer quality5Count;

	private java.util.List<Integer> countsPerDayNextWeek;

	private Integer maxCardsPerDay;

	
	private Boolean frozen = false;

	public BoxStatisticsModel() {
	}

	public BoxStatisticsModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("quality0Count") Integer quality0Count,
		@JsonProperty("quality1Count") Integer quality1Count,
		@JsonProperty("quality2Count") Integer quality2Count,
		@JsonProperty("quality3Count") Integer quality3Count,
		@JsonProperty("quality4Count") Integer quality4Count,
		@JsonProperty("quality5Count") Integer quality5Count,
		@JsonProperty("countsPerDayNextWeek") java.util.List<Integer> countsPerDayNextWeek,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay
	) {
		this.boxId = boxId;
		this.quality0Count = quality0Count;
		this.quality1Count = quality1Count;
		this.quality2Count = quality2Count;
		this.quality3Count = quality3Count;
		this.quality4Count = quality4Count;
		this.quality5Count = quality5Count;
		this.countsPerDayNextWeek = countsPerDayNextWeek;
		this.maxCardsPerDay = maxCardsPerDay;
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	
	@JsonProperty
	public void setBoxId(String boxId) {
		if (this.frozen) {
			throw new RuntimeException("boxId is frozen");
		}
		this.boxId = boxId;
	}
	
	@JsonProperty
	public Integer getQuality0Count() {
		return this.quality0Count;
	}
	
	@JsonProperty
	public void setQuality0Count(Integer quality0Count) {
		if (this.frozen) {
			throw new RuntimeException("quality0Count is frozen");
		}
		this.quality0Count = quality0Count;
	}
	
	@JsonProperty
	public Integer getQuality1Count() {
		return this.quality1Count;
	}
	
	@JsonProperty
	public void setQuality1Count(Integer quality1Count) {
		if (this.frozen) {
			throw new RuntimeException("quality1Count is frozen");
		}
		this.quality1Count = quality1Count;
	}
	
	@JsonProperty
	public Integer getQuality2Count() {
		return this.quality2Count;
	}
	
	@JsonProperty
	public void setQuality2Count(Integer quality2Count) {
		if (this.frozen) {
			throw new RuntimeException("quality2Count is frozen");
		}
		this.quality2Count = quality2Count;
	}
	
	@JsonProperty
	public Integer getQuality3Count() {
		return this.quality3Count;
	}
	
	@JsonProperty
	public void setQuality3Count(Integer quality3Count) {
		if (this.frozen) {
			throw new RuntimeException("quality3Count is frozen");
		}
		this.quality3Count = quality3Count;
	}
	
	@JsonProperty
	public Integer getQuality4Count() {
		return this.quality4Count;
	}
	
	@JsonProperty
	public void setQuality4Count(Integer quality4Count) {
		if (this.frozen) {
			throw new RuntimeException("quality4Count is frozen");
		}
		this.quality4Count = quality4Count;
	}
	
	@JsonProperty
	public Integer getQuality5Count() {
		return this.quality5Count;
	}
	
	@JsonProperty
	public void setQuality5Count(Integer quality5Count) {
		if (this.frozen) {
			throw new RuntimeException("quality5Count is frozen");
		}
		this.quality5Count = quality5Count;
	}
	
	@JsonProperty
	public java.util.List<Integer> getCountsPerDayNextWeek() {
		return this.countsPerDayNextWeek;
	}
	
	@JsonProperty
	public void setCountsPerDayNextWeek(java.util.List<Integer> countsPerDayNextWeek) {
		if (this.frozen) {
			throw new RuntimeException("countsPerDayNextWeek is frozen");
		}
		this.countsPerDayNextWeek = countsPerDayNextWeek;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	
	@JsonProperty
	public void setMaxCardsPerDay(Integer maxCardsPerDay) {
		if (this.frozen) {
			throw new RuntimeException("maxCardsPerDay is frozen");
		}
		this.maxCardsPerDay = maxCardsPerDay;
	}
	
	
	
	@Override
	public void freeze() {
		this.frozen = true;
	}

	public static BoxStatisticsModel generateTestData() {
		java.util.Random random = new java.util.Random();
		int n;
		BoxStatisticsModel testData = new BoxStatisticsModel();
		testData.setBoxId(randomString(random));
		testData.setQuality0Count(random.nextInt(50));
		testData.setQuality1Count(random.nextInt(50));
		testData.setQuality2Count(random.nextInt(50));
		testData.setQuality3Count(random.nextInt(50));
		testData.setQuality4Count(random.nextInt(50));
		testData.setQuality5Count(random.nextInt(50));
		java.util.List<Integer> countsPerDayNextWeekList = new java.util.ArrayList<Integer>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			countsPerDayNextWeekList.add(random.nextInt(50));
		}
		testData.setCountsPerDayNextWeek(countsPerDayNextWeekList);
		testData.setMaxCardsPerDay(random.nextInt(50));
		return testData;
	}
	
	private static String randomString(java.util.Random random) {
		String chars = "aaaaaaabcdeeeeeeeffffghiiiiiiijkllllllmmmmnnnnnnnooooooooopqrstttuuuuuuuvxyz";
		int n = random.nextInt(20) + 5;
		StringBuilder sb = new StringBuilder(n);
		for (int i = 0; i < n; i++) {
			int index = random.nextInt(chars.length());
			sb.append(chars.charAt(index));
		}
		String string  = sb.toString(); 
		return string.substring(0,1).toUpperCase() + string.substring(1).toLowerCase();
	}

}



/******* S.D.G. *******/



