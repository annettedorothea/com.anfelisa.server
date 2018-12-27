package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=RevokeUserModel.class)
public interface IRevokeUserModel {

	String getCategoryId();
	String getRootCategoryId();
	String getRevokedUserId();
	String getUserId();

}

/*       S.D.G.       */
