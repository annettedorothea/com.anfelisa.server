package com.anfelisa.box.data;

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
public abstract class AbstractNextReinforceCardData extends AbstractData implements INextReinforceCardData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractNextReinforceCardData.class);
	
	@NotNull
	private String boxId;
	
	private String userId;
	
	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	
	private Integer lastQuality;
	
	private String given;
	
	private String wanted;
	
	private String image;
	
	private String categoryId;
	

	public AbstractNextReinforceCardData(
		@JsonProperty("boxId") String boxId,
		@JsonProperty("userId") String userId,
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate,
		@JsonProperty("lastQuality") Integer lastQuality,
		@JsonProperty("given") String given,
		@JsonProperty("wanted") String wanted,
		@JsonProperty("image") String image,
		@JsonProperty("categoryId") String categoryId
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.boxId = boxId;
		this.userId = userId;
		this.reinforceCardId = reinforceCardId;
		this.changeDate = changeDate;
		this.lastQuality = lastQuality;
		this.given = given;
		this.wanted = wanted;
		this.image = image;
		this.categoryId = categoryId;
	}

	public AbstractNextReinforceCardData( String uuid ) {
		super(uuid);
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
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	public void setReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getChangeDate() {
		return this.changeDate;
	}
	public void setChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
	}
	
	@JsonProperty
	public Integer getLastQuality() {
		return this.lastQuality;
	}
	public void setLastQuality(Integer lastQuality) {
		this.lastQuality = lastQuality;
	}
	
	@JsonProperty
	public String getGiven() {
		return this.given;
	}
	public void setGiven(String given) {
		this.given = given;
	}
	
	@JsonProperty
	public String getWanted() {
		return this.wanted;
	}
	public void setWanted(String wanted) {
		this.wanted = wanted;
	}
	
	@JsonProperty
	public String getImage() {
		return this.image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	@JsonProperty
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	
	public void mapFrom(com.anfelisa.box.models.INextReinforceCardViewModel model) {
		this.reinforceCardId = model.getReinforceCardId();
		this.changeDate = model.getChangeDate();
		this.lastQuality = model.getLastQuality();
		this.given = model.getGiven();
		this.wanted = model.getWanted();
		this.image = model.getImage();
		this.categoryId = model.getCategoryId();
	}
}

/*       S.D.G.       */
