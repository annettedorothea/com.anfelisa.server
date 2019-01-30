package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractUserAccessToCategoryData extends AbstractData implements IUserAccessToCategoryData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractUserAccessToCategoryData.class);
	
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
	public IUserAccessToCategoryData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IUserAccessToCategoryData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
}

/*       S.D.G.       */
