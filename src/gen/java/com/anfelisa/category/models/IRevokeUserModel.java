package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=RevokeUserModel.class)
public interface IRevokeUserModel {

	String getCategoryId();
	void setCategoryId(String categoryId);
	
	String getRootCategoryId();
	void setRootCategoryId(String rootCategoryId);
	
	String getRevokedUserId();
	void setRevokedUserId(String revokedUserId);
	
	String getUserId();
	void setUserId(String userId);
	
	
}

/*       S.D.G.       */
