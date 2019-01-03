package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=CategoryDeleteModel.class)
public interface ICategoryDeleteModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	Integer getCategoryIndex();
	void setCategoryIndex(Integer categoryIndex);
	
	String getParentCategoryId();
	void setParentCategoryId(String parentCategoryId);
	
	String getUserId();
	void setUserId(String userId);
	

}

/*       S.D.G.       */
