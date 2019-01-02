package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryTreeData extends AbstractCategoryTreeData implements ICategoryTreeData {
	
	public CategoryTreeData(
		@JsonProperty("categoryList") java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			categoryList,
			userId,
			uuid
		);
	}

	public CategoryTreeData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICategoryTreeData original = (ICategoryTreeData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICategoryTreeData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
