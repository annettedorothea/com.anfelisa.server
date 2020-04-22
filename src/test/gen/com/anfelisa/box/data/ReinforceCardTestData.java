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




package com.anfelisa.box.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.joda.time.DateTime;
import java.util.List;

@SuppressWarnings("unused")
public class ReinforceCardTestData {
	
	private String uuid;

	private String reinforceCardId;
	
	private String scheduledCardId;
	
	private String boxId;
	
	private String changeDate;
	

	public ReinforceCardTestData(
		@JsonProperty("reinforceCardId") String reinforceCardId, 
		@JsonProperty("scheduledCardId") String scheduledCardId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("changeDate") String changeDate, 
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
		this.reinforceCardId = reinforceCardId;
		this.scheduledCardId = scheduledCardId;
		this.boxId = boxId;
		this.changeDate = changeDate;
	}

	public ReinforceCardTestData(
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
	}

	public ReinforceCardTestData() {
	}

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	public String getReinforceCardId() {
		return this.reinforceCardId;
	}
	public void setReinforceCardId(String reinforceCardId) {
		this.reinforceCardId = reinforceCardId;
	}
	
	public String getScheduledCardId() {
		return this.scheduledCardId;
	}
	public void setScheduledCardId(String scheduledCardId) {
		this.scheduledCardId = scheduledCardId;
	}
	
	public String getBoxId() {
		return this.boxId;
	}
	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}
	
	public String getChangeDate() {
		return this.changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	
}




/******* S.D.G. *******/



