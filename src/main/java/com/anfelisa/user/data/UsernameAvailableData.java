/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsernameAvailableData extends AbstractUsernameAvailableData implements IUsernameAvailableData {
	
	public UsernameAvailableData(
		@JsonProperty("username") String username, 
		@JsonProperty("available") Boolean available, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			username,
			available,
			uuid
		);
	}

	public UsernameAvailableData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.user.models.IUsernameAvailableModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.user.models.IUsernameAvailableModel testData = new com.anfelisa.user.models.UsernameAvailableModel();
		testData.setUsername(randomString(random));
		testData.setAvailable(random.nextBoolean());
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



