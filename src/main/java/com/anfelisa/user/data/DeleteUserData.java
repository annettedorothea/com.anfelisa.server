/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package com.anfelisa.user.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeleteUserData extends AbstractDeleteUserData implements IDeleteUserData {
	
	public DeleteUserData(
		@JsonProperty("usernameToBeDeleted") String usernameToBeDeleted, 
		@JsonProperty("username") String username, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("role") String role, 
		@JsonProperty("boxIds") java.util.List<String> boxIds, 
		@JsonProperty("rootCategoryIds") java.util.List<String> rootCategoryIds, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			usernameToBeDeleted,
			username,
			userId,
			role,
			boxIds,
			rootCategoryIds,
			uuid
		);
	}

	public DeleteUserData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.user.models.IDeleteUserModel generateTestData() {
		java.util.Random random = new java.util.Random();
		int n;
		com.anfelisa.user.models.IDeleteUserModel testData = new com.anfelisa.user.models.DeleteUserModel();
		testData.setUsernameToBeDeleted(randomString(random));
		testData.setUsername(randomString(random));
		testData.setUserId(randomString(random));
		testData.setRole(randomString(random));
		java.util.List<String> boxIdsList = new java.util.ArrayList<String>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			boxIdsList.add(randomString(random));
		}
		testData.setBoxIds(boxIdsList);
		java.util.List<String> rootCategoryIdsList = new java.util.ArrayList<String>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			rootCategoryIdsList.add(randomString(random));
		}
		testData.setRootCategoryIds(rootCategoryIdsList);
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



