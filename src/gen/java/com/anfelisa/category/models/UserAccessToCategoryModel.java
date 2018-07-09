package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class UserAccessToCategoryModel implements IUserAccessToCategoryModel {

	@NotNull
	private String categoryId;
	
	@NotNull
	private String userId;
	

	public UserAccessToCategoryModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId
	) {
		this.categoryId = categoryId;
		this.userId = userId;
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	

}

/*       S.D.G.       */
