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

public class ScoreCardData extends AbstractScoreCardData implements IScoreCardData {
	
	public ScoreCardData(
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("nextScheduledCardScheduledCardId") String nextScheduledCardScheduledCardId, 
		@JsonProperty("nextScheduledCardCreatedDate") java.time.LocalDateTime nextScheduledCardCreatedDate, 
		@JsonProperty("nextScheduledCardEf") Float nextScheduledCardEf, 
		@JsonProperty("nextScheduledCardInterval") Integer nextScheduledCardInterval, 
		@JsonProperty("nextScheduledCardN") Integer nextScheduledCardN, 
		@JsonProperty("nextScheduledCardCount") Integer nextScheduledCardCount, 
		@JsonProperty("nextScheduledCardScheduledDate") java.time.LocalDateTime nextScheduledCardScheduledDate, 
		@JsonProperty("nextScheduledCardLastQuality") Integer nextScheduledCardLastQuality, 
		@JsonProperty("scoredCardScheduledCardId") String scoredCardScheduledCardId, 
		@JsonProperty("scoredCardQuality") Integer scoredCardQuality, 
		@JsonProperty("scoredCardScoredDate") java.time.LocalDateTime scoredCardScoredDate, 
		@JsonProperty("reinforceCardId") String reinforceCardId, 
		@JsonProperty("reinforceCardCreatedDate") java.time.LocalDateTime reinforceCardCreatedDate, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			cardId,
			nextScheduledCardScheduledCardId,
			nextScheduledCardCreatedDate,
			nextScheduledCardEf,
			nextScheduledCardInterval,
			nextScheduledCardN,
			nextScheduledCardCount,
			nextScheduledCardScheduledDate,
			nextScheduledCardLastQuality,
			scoredCardScheduledCardId,
			scoredCardQuality,
			scoredCardScoredDate,
			reinforceCardId,
			reinforceCardCreatedDate,
			userId,
			boxId,
			uuid
		);
	}

	public ScoreCardData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}




/******* S.D.G. *******/



