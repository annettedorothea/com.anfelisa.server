package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryListData extends AbstractCategoryListData implements ICategoryListData {
	
	public CategoryListData(
		@JsonProperty("parentCategoryId") String parentCategoryId, 
		@JsonProperty("grandParentCategoryId") String grandParentCategoryId, 
		@JsonProperty("parentCategoryName") String parentCategoryName, 
		@JsonProperty("parentDictionaryLookup") Boolean parentDictionaryLookup, 
		@JsonProperty("rootDictionaryLookup") Boolean rootDictionaryLookup, 
		@JsonProperty("parentGivenLanguage") String parentGivenLanguage, 
		@JsonProperty("parentWantedLanguage") String parentWantedLanguage, 
		@JsonProperty("categoryList") java.util.List<com.anfelisa.category.models.ICategoryItemModel> categoryList, 
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardModel> cardList, 
		@JsonProperty("hasBox") Boolean hasBox, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("parentEditable") Boolean parentEditable, 
		@JsonProperty("userList") java.util.List<com.anfelisa.category.models.IUserWithAccessModel> userList, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			parentCategoryId,
			grandParentCategoryId,
			parentCategoryName,
			parentDictionaryLookup,
			rootDictionaryLookup,
			parentGivenLanguage,
			parentWantedLanguage,
			categoryList,
			cardList,
			hasBox,
			userId,
			parentEditable,
			userList,
			uuid
		);
	}

	public CategoryListData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICategoryListData original = (ICategoryListData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICategoryListData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
