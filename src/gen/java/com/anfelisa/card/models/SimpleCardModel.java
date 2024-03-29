/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.DateTimeToStringConverter;
import de.acegen.StringToDateTimeConverter;
import de.acegen.AbstractModel;

@SuppressWarnings("unused")
public class SimpleCardModel extends AbstractModel {

	private String given;

	private String wanted;

	private String id;

	
	private Boolean frozen = false;

	public SimpleCardModel() {
	}

	public SimpleCardModel(
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("id") String id
	) {
		this.given = given;
		this.wanted = wanted;
		this.id = id;
	}

	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	
	@JsonProperty
	public void setGiven(String given) {
		if (this.frozen) {
			throw new RuntimeException("given is frozen");
		}
		this.given = given;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	
	@JsonProperty
	public void setWanted(String wanted) {
		if (this.frozen) {
			throw new RuntimeException("wanted is frozen");
		}
		this.wanted = wanted;
	}
	
	@JsonProperty
	public String getId() {
		return this.id;
	}
	
	@JsonProperty
	public void setId(String id) {
		if (this.frozen) {
			throw new RuntimeException("id is frozen");
		}
		this.id = id;
	}
	
	
	
	@Override
	public void freeze() {
		this.frozen = true;
	}

	public static SimpleCardModel generateTestData() {
		java.util.Random random = new java.util.Random();
		SimpleCardModel testData = new SimpleCardModel();
		testData.setGiven(randomString(random));
		testData.setWanted(randomString(random));
		testData.setId(randomString(random));
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



