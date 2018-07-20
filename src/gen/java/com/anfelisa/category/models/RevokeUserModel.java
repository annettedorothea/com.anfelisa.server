package com.anfelisa.category.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("all")
public class RevokeUserModel implements IRevokeUserModel {

	@NotNull
	private String categoryId;
	
	@NotNull
	private String rootCategoryId;
	
	@NotNull
	private String revokedUserId;
	

	public RevokeUserModel(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("revokedUserId") String revokedUserId
	) {
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.revokedUserId = revokedUserId;
	}

	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	
	@JsonProperty
	public String getRevokedUserId() {
		return this.revokedUserId;
	}
	public void setRevokedUserId(String revokedUserId) {
		this.revokedUserId = revokedUserId;
	}
	

}

/*       S.D.G.       */
