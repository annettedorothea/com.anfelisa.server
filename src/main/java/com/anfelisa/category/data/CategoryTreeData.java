/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryTreeData extends AbstractCategoryTreeData implements ICategoryTreeData {
	
	public CategoryTreeData(
		@JsonProperty("rootCategory") com.anfelisa.category.models.ICategoryTreeItemModel rootCategory, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("filterNonScheduled") Boolean filterNonScheduled, 
		@JsonProperty("priority") Integer priority, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			rootCategory,
			userId,
			rootCategoryId,
			filterNonScheduled,
			priority,
			uuid
		);
	}

	public CategoryTreeData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.category.models.ICategoryTreeModel generateTestData() {
		java.util.Random random = new java.util.Random();
		com.anfelisa.category.models.ICategoryTreeModel testData = new com.anfelisa.category.models.CategoryTreeModel();
		testData.setRootCategory(com.anfelisa.category.data.CategoryTreeItemData.generateTestData());
		testData.setUserId(randomString(random));
		testData.setRootCategoryId(randomString(random));
		testData.setFilterNonScheduled(random.nextBoolean());
		testData.setPriority(random.nextInt(50));
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



