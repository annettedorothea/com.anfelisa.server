/* 
 * Copyright (c) 2019, Annette Pohl, Koblenz, Germany
 *
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.

 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */




package com.anfelisa.box.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class ReinforceCardModel implements IReinforceCardModel {

	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private String scheduledCardId;
	
	@NotNull
	private String boxId;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	

	public ReinforceCardModel() {
	}

	public ReinforceCardModel(
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("scheduledCardId") String scheduledCardId,
		@JsonProperty("boxId") String boxId,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate
	) {
		this.reinforceCardId = reinforceCardId;
		this.scheduledCardId = scheduledCardId;
		this.boxId = boxId;
		this.changeDate = changeDate;
	}

	@JsonProperty
	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	public void setReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
	}
	
	@JsonProperty
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	
	@JsonProperty
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	@JsonProperty
	public org.joda.time.DateTime getChangeDate() {
		return this.changeDate;
	}
	public void setChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
	}
	
	
	public List<String> equalsPrimitiveTypes(com.anfelisa.box.models.IReinforceCardModel other) {
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




/******* S.D.G. *******/



