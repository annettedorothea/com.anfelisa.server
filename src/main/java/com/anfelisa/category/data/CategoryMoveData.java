package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

public class CategoryMoveData extends AbstractCategoryMoveData implements ICategoryMoveData {
	
	public CategoryMoveData(
		@JsonProperty("movedCategoryId") String movedCategoryId, 
		@JsonProperty("targetCategoryId") String targetCategoryId, 
		@JsonProperty("movedCategory") com.anfelisa.category.models.ICategoryModel movedCategory, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			movedCategoryId,
			targetCategoryId,
			movedCategory,
			userId,
			uuid
		);
	}

	public CategoryMoveData( String uuid ) {
		super(uuid);
	}


	public void migrateLegacyData(String json) {
	}

	public void overwriteNotReplayableData(IDataContainer dataContainer) {
		/*if (dataContainer != null) {
			try {
				ICategoryMoveData original = (ICategoryMoveData)dataContainer;
				//overwrite values
			} catch (ClassCastException x) {
				LOG.error("cannot cast data to ICategoryMoveData for overwriting not replayable attributes", x);
			}
		}*/
	}

}

/*       S.D.G.       */
