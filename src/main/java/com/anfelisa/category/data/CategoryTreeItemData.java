/********************************************************************************
 * generated by de.acegen 1.0.0
 ********************************************************************************/




package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryTreeItemData extends AbstractCategoryTreeItemData implements ICategoryTreeItemData {
	
	public CategoryTreeItemData(
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("categoryIndex") Integer categoryIndex, 
		@JsonProperty("empty") Boolean empty, 
		@JsonProperty("parentCategoryId") String parentCategoryId, 
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup, 
		@JsonProperty("givenLanguage") String givenLanguage, 
		@JsonProperty("wantedLanguage") String wantedLanguage, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("childCategories") java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories, 
		@JsonProperty("nonScheduledCount") Integer nonScheduledCount, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryId,
			categoryName,
			categoryIndex,
			empty,
			parentCategoryId,
			dictionaryLookup,
			givenLanguage,
			wantedLanguage,
			rootCategoryId,
			childCategories,
			nonScheduledCount,
			uuid
		);
	}

	public CategoryTreeItemData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	public static com.anfelisa.category.models.ICategoryTreeItemModel generateTestData() {
		java.util.Random random = new java.util.Random();
		int n;
		com.anfelisa.category.models.ICategoryTreeItemModel testData = new com.anfelisa.category.models.CategoryTreeItemModel();
		testData.setCategoryId(randomString(random));
		testData.setCategoryName(randomString(random));
		testData.setCategoryIndex(random.nextInt(50));
		testData.setEmpty(random.nextBoolean());
		testData.setParentCategoryId(randomString(random));
		testData.setDictionaryLookup(random.nextBoolean());
		testData.setGivenLanguage(randomString(random));
		testData.setWantedLanguage(randomString(random));
		testData.setRootCategoryId(randomString(random));
		java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategoriesList = new java.util.ArrayList<com.anfelisa.category.models.ICategoryTreeItemModel>();
		n = random.nextInt(20) + 1;
		for ( int i = 0; i < n; i++ ) {
			childCategoriesList.add(com.anfelisa.category.data.CategoryTreeItemData.generateTestData());
		}
		testData.setChildCategories(childCategoriesList);
		testData.setNonScheduledCount(random.nextInt(50));
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



