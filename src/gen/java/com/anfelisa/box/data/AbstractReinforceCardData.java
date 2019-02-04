package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.joda.time.DateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import com.anfelisa.box.models.IReinforceCardModel;

import com.anfelisa.ace.AbstractData;
import com.anfelisa.ace.IDataContainer;

@SuppressWarnings("unused")
public abstract class AbstractReinforceCardData extends AbstractData implements IReinforceCardData {
	
	static final Logger LOG = LoggerFactory.getLogger(AbstractReinforceCardData.class);
	
	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private String scheduledCardId;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	

	public AbstractReinforceCardData(
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate
,		@JsonProperty("uuid") String uuid
	) {
		super(uuid);
		this.reinforceCardId = reinforceCardId;
		this.scheduledCardId = scheduledCardId;
		this.boxId = boxId;
		this.changeDate = changeDate;
	}

	public AbstractReinforceCardData( String uuid ) {
		super(uuid);
	}

	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	public void setReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
	}
	public IReinforceCardData withReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
		return this;
	}
	
	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	public IReinforceCardData withScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
		return this;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	public IReinforceCardData withBoxId(String boxId) {
		this.boxId = boxId;
		return this;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getChangeDate() {
		return this.changeDate;
	}
	public void setChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
	}
	public IReinforceCardData withChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
		return this;
	}
	
	
	
	public List<String> equalsPrimitiveTypes(IReinforceCardModel other) {
		List<String> differingAttributes = new ArrayList<String>();
		if (!(this.getReinforceCardId() == null && other.getReinforceCardId() == null) && !this.getReinforceCardId().equals(other.getReinforceCardId())) {
			differingAttributes.add("reinforceCardId: " + this.getReinforceCardId() + " " + other.getReinforceCardId());
		}
		if (!(this.getScheduledCardId() == null && other.getScheduledCardId() == null) && !this.getScheduledCardId().equals(other.getScheduledCardId())) {
			differingAttributes.add("scheduledCardId: " + this.getScheduledCardId() + " " + other.getScheduledCardId());
		}
		if (!(this.getBoxId() == null && other.getBoxId() == null) && !this.getBoxId().equals(other.getBoxId())) {
			differingAttributes.add("boxId: " + this.getBoxId() + " " + other.getBoxId());
		}
		if (!(this.getChangeDate() == null && other.getChangeDate() == null) && !this.getChangeDate().equals(other.getChangeDate())) {
			differingAttributes.add("changeDate: " + this.getChangeDate() + " " + other.getChangeDate());
		}
		return differingAttributes;
	}
	
	
}

/*       S.D.G.       */
