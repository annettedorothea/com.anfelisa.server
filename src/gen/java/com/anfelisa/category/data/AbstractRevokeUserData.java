package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractRevokeUserData extends AbstractData implements IRevokeUserData {
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String rootCategoryId;
	
	@NotNull
	private String revokedUserId;
	
	private String userId;
	

	public AbstractRevokeUserData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("rootCategoryId") String rootCategoryId,
		@JsonProperty("revokedUserId") String revokedUserId,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.rootCategoryId = rootCategoryId;
		this.revokedUserId = revokedUserId;
		this.userId = userId;
	}

	public AbstractRevokeUserData( String uuid ) {
		super(uuid);
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
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

/*       S.D.G.       */
