package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserAccessToCategoryModel.class)
public interface IUserAccessToCategoryModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getUserId();
	void setUserId(String userId);
	
	
}

/*       S.D.G.       */
