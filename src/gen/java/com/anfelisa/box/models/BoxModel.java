package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class BoxModel implements IBoxModel {

	@NotNull
	private String boxId;
	
	@NotNull
	private String userId;
	
	@NotNull
	private String categoryId;
	
	private Integer maxInterval;
	
	private Integer maxCardsPerDay;
	

	public BoxModel() {
	}

	public BoxModel(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("categoryId") String categoryId,
		@JsonProperty("maxInterval") Integer maxInterval,
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay
	) {
		this.boxId = boxId;
		this.userId = userId;
		this.categoryId = categoryId;
		this.maxInterval = maxInterval;
		this.maxCardsPerDay = maxCardsPerDay;
	}

	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
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
	public Integer getMaxInterval() {
		return this.maxInterval;
	}
	public void setMaxInterval(Integer maxInterval) {
		this.maxInterval = maxInterval;
	}
	
	@JsonProperty
	public Integer getMaxCardsPerDay() {
		return this.maxCardsPerDay;
	}
	public void setMaxCardsPerDay(Integer maxCardsPerDay) {
		this.maxCardsPerDay = maxCardsPerDay;
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
