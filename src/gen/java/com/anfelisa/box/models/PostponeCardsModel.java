package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class PostponeCardsModel implements IPostponeCardsModel {

	@NotNull
	private Integer days;
	
	@NotNull
	private String boxId;
	
	private String userId;
	
	@NotNull
	private org.joda.time.DateTime today;
	

	public PostponeCardsModel() {
	}

	public PostponeCardsModel(
		@JsonProperty("days") Integer days,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("today") org.joda.time.DateTime today
	) {
		this.days = days;
		this.boxId = boxId;
		this.userId = userId;
		this.today = today;
	}

	@JsonProperty
	public Integer getDays() {
		return this.days;
	}
	public void setDays(Integer days) {
		this.days = days;
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
	public org.joda.time.DateTime getToday() {
		return this.today;
	}
	public void setToday(org.joda.time.DateTime today) {
		this.today = today;
	}
	
	
	public List<String> equalsPrimitiveTypes(IPostponeCardsModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getDays() == null && other.getDays() == null) && !this.getDays().equals(other.getDays())) {
			differingAttributes.add("days: " + this.getDays() + " " + other.getDays());
		}
		if (!(this.getBoxId() == null && other.getBoxId() == null) && !this.getBoxId().equals(other.getBoxId())) {
			differingAttributes.add("boxId: " + this.getBoxId() + " " + other.getBoxId());
		}
		if (!(this.getUserId() == null && other.getUserId() == null) && !this.getUserId().equals(other.getUserId())) {
			differingAttributes.add("userId: " + this.getUserId() + " " + other.getUserId());
		}
		if (!(this.getToday() == null && other.getToday() == null) && !this.getToday().equals(other.getToday())) {
			differingAttributes.add("today: " + this.getToday() + " " + other.getToday());
		}
		return differingAttributes;
	}
	
}

/*       S.D.G.       */
