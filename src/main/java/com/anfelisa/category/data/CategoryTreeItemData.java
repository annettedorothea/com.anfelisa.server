package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryTreeItemData extends AbstractCategoryTreeItemData implements ICategoryTreeItemData {
	
	public CategoryTreeItemData(
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("categoryIndex") Integer categoryIndex, 
		@JsonProperty("empty") Boolean empty, 
		@JsonProperty("editable") Boolean editable, 
		@JsonProperty("hasBox") Boolean hasBox, 
		@JsonProperty("parentCategoryId") String parentCategoryId, 
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup, 
		@JsonProperty("givenLanguage") String givenLanguage, 
		@JsonProperty("wantedLanguage") String wantedLanguage, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("childCategories") java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryId,
			categoryName,
			categoryIndex,
			empty,
			editable,
			hasBox,
			parentCategoryId,
			dictionaryLookup,
			givenLanguage,
			wantedLanguage,
			rootCategoryId,
			childCategories,
			uuid
		);
	}

	public CategoryTreeItemData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICategoryTreeItemData original = (ICategoryTreeItemData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICategoryTreeItemData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
