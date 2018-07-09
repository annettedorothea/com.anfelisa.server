package com.anfelisa.category.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as=UserAccessToCategoryModel.class)
public interface IUserAccessToCategoryModel {

	String getCategoryId();
	String getUserId();

}

/*       S.D.G.       */
