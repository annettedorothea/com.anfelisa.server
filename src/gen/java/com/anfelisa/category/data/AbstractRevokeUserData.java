package com.anfelisa.category.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.category.models.IRevokeUserModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractRevokeUserData extends AbstractData implements IRevokeUserData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractRevokeUserData.class);
	
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
	public IRevokeUserData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public String getRootCategoryId() {
		return this.rootCategoryId;
	}
	public void setRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
	}
	public IRevokeUserData withRootCategoryId(String rootCategoryId) {
		this.rootCategoryId = rootCategoryId;
		return this;
	}
	
	@JsonProperty
	public String getRevokedUserId() {
		return this.revokedUserId;
	}
	public void setRevokedUserId(String revokedUserId) {
		this.revokedUserId = revokedUserId;
	}
	public IRevokeUserData withRevokedUserId(String revokedUserId) {
		this.revokedUserId = revokedUserId;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IRevokeUserData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(IRevokeUserModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getRootCategoryId() == null && other.getRootCategoryId() == null) && !this.getRootCategoryId().equals(other.getRootCategoryId())) {
			differingAttributes.add("rootCategoryId: " + this.getRootCategoryId() + " " + other.getRootCategoryId());
		}
		if (!(this.getRevokedUserId() == null && other.getRevokedUserId() == null) && !this.getRevokedUserId().equals(other.getRevokedUserId())) {
			differingAttributes.add("revokedUserId: " + this.getRevokedUserId() + " " + other.getRevokedUserId());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
