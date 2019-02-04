package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.category.models.IUserAccessToCategoryModel;

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
	
	
	
	public List<String> equalsPrimitiveTypes(IUserAccessToCategoryModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
