/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
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
 *
 * generated with de.acegen 0.9.5
 *
 */




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IScoreCardModel;

@JsonDeserialize(as=ScoreCardData.class)
public interface IScoreCardData extends IScoreCardModel, IDataContainer {
	
	IScoreCardData withCardId(String cardId);
	
	IScoreCardData withNextScheduledCardScheduledCardId(String nextScheduledCardScheduledCardId);
	
	IScoreCardData withNextScheduledCardCreatedDate(java.time.LocalDateTime nextScheduledCardCreatedDate);
	
	IScoreCardData withNextScheduledCardEf(Float nextScheduledCardEf);
	
	IScoreCardData withNextScheduledCardInterval(Integer nextScheduledCardInterval);
	
	IScoreCardData withNextScheduledCardN(Integer nextScheduledCardN);
	
	IScoreCardData withNextScheduledCardCount(Integer nextScheduledCardCount);
	
	IScoreCardData withNextScheduledCardScheduledDate(java.time.LocalDateTime nextScheduledCardScheduledDate);
	
	IScoreCardData withNextScheduledCardLastQuality(Integer nextScheduledCardLastQuality);
	
	IScoreCardData withScheduledCardId(String scheduledCardId);
	
	IScoreCardData withScoredCardQuality(Integer scoredCardQuality);
	
	IScoreCardData withScoredCardScoredDate(java.time.LocalDateTime scoredCardScoredDate);
	
	IScoreCardData withReinforceCardId(String reinforceCardId);
	
	IScoreCardData withReinforceCardCreatedDate(java.time.LocalDateTime reinforceCardCreatedDate);
	
	IScoreCardData withUserId(String userId);
	
	IScoreCardData withBoxId(String boxId);
	
	
}



/******* S.D.G. *******/



