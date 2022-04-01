/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxWithStatisticsData extends AbstractBoxWithStatisticsData implements IBoxWithStatisticsData {
	
	public BoxWithStatisticsData(
		@JsonProperty("openTodaysCards") Integer openTodaysCards, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("categoryAuthor") String categoryAuthor, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("reverse") Boolean reverse, 
		@JsonProperty("editable") Boolean editable, 
		@JsonProperty("archived") Boolean archived, 
		@JsonProperty("deletable") Boolean deletable, 
		@JsonProperty("quality0Count") Integer quality0Count, 
		@JsonProperty("quality1Count") Integer quality1Count, 
		@JsonProperty("quality2Count") Integer quality2Count, 
		@JsonProperty("quality3Count") Integer quality3Count, 
		@JsonProperty("quality4Count") Integer quality4Count, 
		@JsonProperty("quality5Count") Integer quality5Count, 
		@JsonProperty("countsPerDayNextWeek") java.util.List<Integer> countsPerDayNextWeek, 
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			openTodaysCards,
			categoryName,
			categoryAuthor,
			categoryId,
			boxId,
			reverse,
			editable,
			archived,
			deletable,
			quality0Count,
			quality1Count,
			quality2Count,
			quality3Count,
			quality4Count,
			quality5Count,
			countsPerDayNextWeek,
			maxCardsPerDay,
			uuid
		);
	}

	public BoxWithStatisticsData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.box.models.IBoxWithStatisticsModel generateTestData() {
		java.util.Random random = new java.util.Random();
		int n;
		com.anfelisa.box.models.IBoxWithStatisticsModel testData = new com.anfelisa.box.models.BoxWithStatisticsModel();
		testData.setOpenTodaysCards(random.nextInt(50));
		testData.setCategoryName(randomString(random));
		testData.setCategoryAuthor(randomString(random));
		testData.setCategoryId(randomString(random));
		testData.setBoxId(randomString(random));
		testData.setReverse(random.nextBoolean());
		testData.setEditable(random.nextBoolean());
		testData.setArchived(random.nextBoolean());
		testData.setDeletable(random.nextBoolean());
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



