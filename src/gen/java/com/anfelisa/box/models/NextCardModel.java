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
public class NextCardModel extends AbstractModel {

	private String userId;

	private String boxId;

	private String boxName;

	private java.time.LocalDateTime todayAtMidnightInUTC;

	private com.anfelisa.box.models.NextCardViewModel nextCard;

	private Boolean reverse;

	private Integer openTodaysCards;

	private Integer allTodaysCards;

	
	private Boolean frozen = false;

	public NextCardModel() {
	}

	public NextCardModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("boxName") String boxName,
		@JsonProperty("todayAtMidnightInUTC") java.time.LocalDateTime todayAtMidnightInUTC,
		@JsonProperty("nextCard") com.anfelisa.box.models.NextCardViewModel nextCard,
		@JsonProperty("reverse") Boolean reverse,
		@JsonProperty("openTodaysCards") Integer openTodaysCards,
		@JsonProperty("allTodaysCards") Integer allTodaysCards
	) {
		this.userId = userId;
		this.boxId = boxId;
		this.boxName = boxName;
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
		this.nextCard = nextCard;
		this.reverse = reverse;
		this.openTodaysCards = openTodaysCards;
		this.allTodaysCards = allTodaysCards;
	}

	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	
	@JsonProperty
	public void setUserId(String userId) {
		if (this.frozen) {
			throw new RuntimeException("userId is frozen");
		}
		this.userId = userId;
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
	public String getBoxName() {
		return this.boxName;
	}
	
	@JsonProperty
	public void setBoxName(String boxName) {
		if (this.frozen) {
			throw new RuntimeException("boxName is frozen");
		}
		this.boxName = boxName;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public java.time.LocalDateTime getTodayAtMidnightInUTC() {
		return this.todayAtMidnightInUTC;
	}
	
	@JsonProperty
	@JsonSerialize(converter = DateTimeToStringConverter.class)
	@JsonDeserialize(converter = StringToDateTimeConverter.class)
	public void setTodayAtMidnightInUTC(java.time.LocalDateTime todayAtMidnightInUTC) {
		if (this.frozen) {
			throw new RuntimeException("todayAtMidnightInUTC is frozen");
		}
		this.todayAtMidnightInUTC = todayAtMidnightInUTC;
	}
	
	@JsonProperty
	public com.anfelisa.box.models.NextCardViewModel getNextCard() {
		return this.nextCard;
	}
	
	@JsonProperty
	public void setNextCard(com.anfelisa.box.models.NextCardViewModel nextCard) {
		if (this.frozen) {
			throw new RuntimeException("nextCard is frozen");
		}
		this.nextCard = nextCard;
	}
	
	@JsonProperty
	public Boolean getReverse() {
		return this.reverse;
	}
	
	@JsonProperty
	public void setReverse(Boolean reverse) {
		if (this.frozen) {
			throw new RuntimeException("reverse is frozen");
		}
		this.reverse = reverse;
	}
	
	@JsonProperty
	public Integer getOpenTodaysCards() {
		return this.openTodaysCards;
	}
	
	@JsonProperty
	public void setOpenTodaysCards(Integer openTodaysCards) {
		if (this.frozen) {
			throw new RuntimeException("openTodaysCards is frozen");
		}
		this.openTodaysCards = openTodaysCards;
	}
	
	@JsonProperty
	public Integer getAllTodaysCards() {
		return this.allTodaysCards;
	}
	
	@JsonProperty
	public void setAllTodaysCards(Integer allTodaysCards) {
		if (this.frozen) {
			throw new RuntimeException("allTodaysCards is frozen");
		}
		this.allTodaysCards = allTodaysCards;
	}
	
	
	public com.anfelisa.box.models.TodaysCardsStatusModel mapToTodaysCardsStatusModel() {
		com.anfelisa.box.models.TodaysCardsStatusModel model = new com.anfelisa.box.models.TodaysCardsStatusModel();
		model.setOpenTodaysCards(this.getOpenTodaysCards());
		model.setAllTodaysCards(this.getAllTodaysCards());
		return model;
	}	
	
	@Override
	public void freeze() {
		this.frozen = true;
		if (this.nextCard != null) {
			this.nextCard.freeze();
		}
	}

	public static NextCardModel generateTestData() {
		java.util.Random random = new java.util.Random();
		NextCardModel testData = new NextCardModel();
		testData.setUserId(randomString(random));
		testData.setBoxId(randomString(random));
		testData.setBoxName(randomString(random));
		testData.setTodayAtMidnightInUTC(random.nextBoolean() ? java.time.LocalDateTime.now().plusMinutes(random.nextInt(60)) : java.time.LocalDateTime.now().minusMinutes(random.nextInt(60)) );
		testData.setNextCard(com.anfelisa.box.models.NextCardViewModel.generateTestData());
		testData.setReverse(random.nextBoolean());
		testData.setOpenTodaysCards(random.nextInt(50));
		testData.setAllTodaysCards(random.nextInt(50));
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



