package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryUpdateData extends AbstractCategoryUpdateData implements ICategoryUpdateData {
	
	public CategoryUpdateData(
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup, 
		@JsonProperty("givenLanguage") String givenLanguage, 
		@JsonProperty("wantedLanguage") String wantedLanguage, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryId,
			categoryName,
			dictionaryLookup,
			givenLanguage,
			wantedLanguage,
			userId,
			uuid
		);
	}

	public CategoryUpdateData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICategoryUpdateData original = (ICategoryUpdateData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICategoryUpdateData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
