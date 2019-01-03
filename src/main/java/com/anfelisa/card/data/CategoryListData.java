package com.anfelisa.card.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

public class CategoryListData extends AbstractCategoryListData implements ICategoryListData {
	
	public CategoryListData(
		@JsonProperty("cardList") java.util.List<com.anfelisa.card.models.ICardModel> cardList, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			cardList,
			categoryId,
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
