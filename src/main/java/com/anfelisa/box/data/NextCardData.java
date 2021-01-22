/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NextCardData extends AbstractNextCardData implements INextCardData {
	
	public NextCardData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("reverse") Boolean reverse, 
		@JsonProperty("todayAtMidnightInUTC") java.time.LocalDateTime todayAtMidnightInUTC, 
		@JsonProperty("openTodaysCards") Integer openTodaysCards, 
		@JsonProperty("allTodaysCards") Integer allTodaysCards, 
		@JsonProperty("scheduledCardId") String scheduledCardId, 
		@JsonProperty("reinforceCardId") String reinforceCardId, 
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("scheduledDate") java.time.LocalDateTime scheduledDate, 
		@JsonProperty("lastQuality") Integer lastQuality, 
		@JsonProperty("given") String given, 
		@JsonProperty("wanted") String wanted, 
		@JsonProperty("image") String image, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("count") Integer count, 
		@JsonProperty("scoredDate") java.time.LocalDateTime scoredDate, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			boxId,
			reverse,
			todayAtMidnightInUTC,
			openTodaysCards,
			allTodaysCards,
			scheduledCardId,
			reinforceCardId,
			cardId,
			scheduledDate,
			lastQuality,
			given,
			wanted,
			image,
			categoryId,
			categoryName,
			rootCategoryId,
			count,
			scoredDate,
			uuid
		);
	}

	public NextCardData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.box.models.INextCardModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.box.models.INextCardModel testData = new com.anfelisa.box.models.NextCardModel();
		testData.setUserId(randomString(random));
		testData.setBoxId(randomString(random));
		testData.setReverse(random.nextBoolean());
		testData.setTodayAtMidnightInUTC(random.nextBoolean() ? java.time.LocalDateTime.now().plusMinutes(random.nextInt(60)) : java.time.LocalDateTime.now().minusMinutes(random.nextInt(60)) );
		testData.setOpenTodaysCards(random.nextInt(50));
		testData.setAllTodaysCards(random.nextInt(50));
		testData.setScheduledCardId(randomString(random));
		testData.setReinforceCardId(randomString(random));
		testData.setCardId(randomString(random));
		testData.setScheduledDate(random.nextBoolean() ? java.time.LocalDateTime.now().plusMinutes(random.nextInt(60)) : java.time.LocalDateTime.now().minusMinutes(random.nextInt(60)) );
		testData.setLastQuality(random.nextInt(50));
		testData.setGiven(randomString(random));
		testData.setWanted(randomString(random));
		testData.setImage(randomString(random));
		testData.setCategoryId(randomString(random));
		testData.setCategoryName(randomString(random));
		testData.setRootCategoryId(randomString(random));
		testData.setCount(random.nextInt(50));
		testData.setScoredDate(random.nextBoolean() ? java.time.LocalDateTime.now().plusMinutes(random.nextInt(60)) : java.time.LocalDateTime.now().minusMinutes(random.nextInt(60)) );
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



