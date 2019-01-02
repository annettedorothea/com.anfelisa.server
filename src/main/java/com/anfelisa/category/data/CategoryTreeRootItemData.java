package com.anfelisa.category.data;

import com.anfelisa.ace.IDataContainer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoryTreeRootItemData extends AbstractCategoryTreeRootItemData implements ICategoryTreeRootItemData {
	
	public CategoryTreeRootItemData(
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("categoryIndex") Integer categoryIndex, 
		@JsonProperty("empty") Boolean empty, 
		@JsonProperty("editable") Boolean editable, 
		@JsonProperty("hasBox") Boolean hasBox, 
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
			childCategories,
			uuid
		);
	}

	public CategoryTreeRootItemData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICategoryTreeRootItemData original = (ICategoryTreeRootItemData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICategoryTreeRootItemData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
