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
public class BoxSettingsWrapperModel extends AbstractModel {

	private String userId;

	private String boxId;

	private com.anfelisa.box.models.BoxSettingsModel boxSettings;

	
	private Boolean frozen = false;

	public BoxSettingsWrapperModel() {
	}

	public BoxSettingsWrapperModel(
		@JsonProperty("userId") String userId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("boxSettings") com.anfelisa.box.models.BoxSettingsModel boxSettings
	) {
		this.userId = userId;
		this.boxId = boxId;
		this.boxSettings = boxSettings;
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
	public com.anfelisa.box.models.BoxSettingsModel getBoxSettings() {
		return this.boxSettings;
	}
	
	@JsonProperty
	public void setBoxSettings(com.anfelisa.box.models.BoxSettingsModel boxSettings) {
		if (this.frozen) {
			throw new RuntimeException("boxSettings is frozen");
		}
		this.boxSettings = boxSettings;
	}
	
	
	
	@Override
	public void freeze() {
		this.frozen = true;
		if (this.boxSettings != null) {
			this.boxSettings.freeze();
		}
	}

	public static BoxSettingsWrapperModel generateTestData() {
		java.util.Random random = new java.util.Random();
		BoxSettingsWrapperModel testData = new BoxSettingsWrapperModel();
		testData.setUserId(randomString(random));
		testData.setBoxId(randomString(random));
		testData.setBoxSettings(com.anfelisa.box.models.BoxSettingsModel.generateTestData());
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



