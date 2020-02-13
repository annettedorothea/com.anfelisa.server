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
public class ScoreReinforceCardModel implements IScoreReinforceCardModel {

	@NotNull
	private String reinforceCardId;
	
	@NotNull
	private Integer scoredCardQuality;
	
	@NotNull
	private org.joda.time.DateTime changeDate;
	
	private String userId;
	

	public ScoreReinforceCardModel() {
	}

	public ScoreReinforceCardModel(
		@JsonProperty("reinforceCardId") String reinforceCardId,
		@JsonProperty("scoredCardQuality") Integer scoredCardQuality,
		@JsonProperty("changeDate") org.joda.time.DateTime changeDate,
		@JsonProperty("userId") String userId
	) {
		this.reinforceCardId = reinforceCardId;
		this.scoredCardQuality = scoredCardQuality;
		this.changeDate = changeDate;
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
		public Integer getScoredCardQuality() {
			return this.scoredCardQuality;
		}
	public void setScoredCardQuality(Integer scoredCardQuality) {
		this.scoredCardQuality = scoredCardQuality;
	}
	
	@JsonProperty
		public org.joda.time.DateTime getChangeDate() {
			return this.changeDate;
		}
	public void setChangeDate(org.joda.time.DateTime changeDate) {
		this.changeDate = changeDate;
	}
	
	@JsonProperty
		public String getUserId() {
			return this.userId;
		}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}




/******* S.D.G. *******/



