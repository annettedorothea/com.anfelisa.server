package com.anfelisa.category.data;

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

}

/*       S.D.G.       */
