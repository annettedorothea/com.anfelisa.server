package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IBoxModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractBoxData extends AbstractData implements IBoxData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractBoxData.class);
	
	@NotNull
	private String boxId;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String categoryId;
	
	private Integer maxInterval;
	
	private Integer maxCardsPerDay;
	

	public AbstractBoxData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("maxInterval") Integer maxInterval,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxId = boxId;
		this.userId = userId;
		this.categoryId = categoryId;
		this.maxInterval = maxInterval;
		this.maxCardsPerDay = maxCardsPerDay;
	}

	public AbstractBoxData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IBoxData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public IBoxData withUserId(String userId) {
		this.userId = userId;
		return this;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public IBoxData withCategoryId(String categoryId) {
		this.categoryId = categoryId;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	public IBoxData withMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
		return this;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	public void setMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
	}
	public IBoxData withMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(IBoxModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getBoxId() == null && other.getBoxId() == null) && !this.getBoxId().equals(other.getBoxId())) {
			differingAttributes.add("boxId: " + this.getBoxId() + " " + other.getBoxId());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getCategoryId() == null && other.getCategoryId() == null) && !this.getCategoryId().equals(other.getCategoryId())) {
			differingAttributes.add("categoryId: " + this.getCategoryId() + " " + other.getCategoryId());
		}
		if (!(this.getMaxInterval() == null && other.getMaxInterval() == null) && !this.getMaxInterval().equals(other.getMaxInterval())) {
			differingAttributes.add("maxInterval: " + this.getMaxInterval() + " " + other.getMaxInterval());
		}
		if (!(this.getMaxCardsPerDay() == null && other.getMaxCardsPerDay() == null) && !this.getMaxCardsPerDay().equals(other.getMaxCardsPerDay())) {
			differingAttributes.add("maxCardsPerDay: " + this.getMaxCardsPerDay() + " " + other.getMaxCardsPerDay());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
