package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;

import com.anfelisa.ace.AbstractData;

@SuppressWarnings("unused")
public abstract class AbstractUserAccessToCategoryData extends AbstractData implements IUserAccessToCategoryData {
	
	@NotNull
	private String categoryId;
	
	@NotNull
	private String userId;
	

	public AbstractUserAccessToCategoryData(
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("userId") String userId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.categoryId = categoryId;
		this.userId = userId;
	}

	public AbstractUserAccessToCategoryData( String uuid ) {
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
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

/*       S.D.G.       */
