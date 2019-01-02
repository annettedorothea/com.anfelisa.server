package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryDeleteData extends AbstractCategoryDeleteData implements ICategoryDeleteData {
	
	public CategoryDeleteData(
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("categoryIndex") Integer categoryIndex, 
		@JsonProperty("parentCategoryId") String parentCategoryId, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryId,
			categoryIndex,
			parentCategoryId,
			userId,
			uuid
		);
	}

	public CategoryDeleteData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICategoryDeleteData original = (ICategoryDeleteData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICategoryDeleteData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
