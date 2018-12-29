package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("all")
public class GetCategoryTreeResponse implements IGetCategoryTreeResponse {
	
	private java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> categoryList;
	
	public GetCategoryTreeResponse(com.anfelisa.category.models.ICategoryTreeModel data) {
		categoryList = data.getCategoryList();
	}
	
	@JsonProperty
	public java.util.List<com.anfelisa.category.models.ICategoryTreeRootItemModel> getCategoryList() {
		return this.categoryList;
	}
	
}

/*       S.D.G.       */
