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
public class PostponeCardsModel extends AbstractModel {

	private String boxId;

	
	private Boolean frozen = false;

	public PostponeCardsModel() {
	}

	public PostponeCardsModel(
		@JsonProperty("boxId") String boxId
	) {
		this.boxId = boxId;
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
	
	
	
	@Override
	public void freeze() {
		this.frozen = true;
	}

	public static PostponeCardsModel generateTestData() {
		java.util.Random random = new java.util.Random();
		PostponeCardsModel testData = new PostponeCardsModel();
		testData.setBoxId(randomString(random));
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



