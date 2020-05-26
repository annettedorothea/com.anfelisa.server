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

public class ScheduledCardData extends AbstractScheduledCardData implements IScheduledCardData {
	
	public ScheduledCardData(
		@JsonProperty("scheduledCardId") String scheduledCardId, 
		@JsonProperty("cardId") String cardId, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("createdDate") java.time.LocalDateTime createdDate, 
		@JsonProperty("ef") Float ef, 
		@JsonProperty("interval") Integer interval, 
		@JsonProperty("n") Integer n, 
		@JsonProperty("count") Integer count, 
		@JsonProperty("scheduledDate") java.time.LocalDateTime scheduledDate, 
		@JsonProperty("lastQuality") Integer lastQuality, 
		@JsonProperty("quality") Integer quality, 
		@JsonProperty("scoredDate") java.time.LocalDateTime scoredDate, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			scheduledCardId,
			cardId,
			boxId,
			createdDate,
			ef,
			interval,
			n,
			count,
			scheduledDate,
			lastQuality,
			quality,
			scoredDate,
			uuid
		);
	}

	public ScheduledCardData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}




/******* S.D.G. *******/



