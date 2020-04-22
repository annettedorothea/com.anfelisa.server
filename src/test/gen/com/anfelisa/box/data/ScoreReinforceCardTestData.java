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
public class ScoreReinforceCardTestData {
	
	private String uuid;

	private String reinforceCardId;
	
	private Integer scoredCardQuality;
	
	private String changeDate;
	
	private String userId;
	

	public ScoreReinforceCardTestData(
		@JsonProperty("reinforceCardId") String reinforceCardId, 
		@JsonProperty("scoredCardQuality") Integer scoredCardQuality, 
		@JsonProperty("changeDate") String changeDate, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
		this.reinforceCardId = reinforceCardId;
		this.scoredCardQuality = scoredCardQuality;
		this.changeDate = changeDate;
		this.userId = userId;
	}

	public ScoreReinforceCardTestData(
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
	}

	public ScoreReinforceCardTestData() {
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
	
	public Integer getScoredCardQuality() {
		return this.scoredCardQuality;
	}
	public void setScoredCardQuality(Integer scoredCardQuality) {
		this.scoredCardQuality = scoredCardQuality;
	}
	
	public String getChangeDate() {
		return this.changeDate;
	}
	public void setChangeDate(String changeDate) {
		this.changeDate = changeDate;
	}
	
	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}




/******* S.D.G. *******/



