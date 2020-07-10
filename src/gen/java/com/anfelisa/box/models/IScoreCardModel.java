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
 * generated with de.acegen 0.9.6
 *
 */




package com.anfelisa.box.models;

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=ScoreCardModel.class)
public interface IScoreCardModel {

	String getCardId();
	void setCardId(String cardId);
	
	String getNextScheduledCardScheduledCardId();
	void setNextScheduledCardScheduledCardId(String nextScheduledCardScheduledCardId);
	
	java.time.LocalDateTime getNextScheduledCardCreatedDate();
	void setNextScheduledCardCreatedDate(java.time.LocalDateTime nextScheduledCardCreatedDate);
	
	Float getNextScheduledCardEf();
	void setNextScheduledCardEf(Float nextScheduledCardEf);
	
	Integer getNextScheduledCardInterval();
	void setNextScheduledCardInterval(Integer nextScheduledCardInterval);
	
	Integer getNextScheduledCardN();
	void setNextScheduledCardN(Integer nextScheduledCardN);
	
	Integer getNextScheduledCardCount();
	void setNextScheduledCardCount(Integer nextScheduledCardCount);
	
	java.time.LocalDateTime getNextScheduledCardScheduledDate();
	void setNextScheduledCardScheduledDate(java.time.LocalDateTime nextScheduledCardScheduledDate);
	
	Integer getNextScheduledCardLastQuality();
	void setNextScheduledCardLastQuality(Integer nextScheduledCardLastQuality);
	
	String getScheduledCardId();
	void setScheduledCardId(String scheduledCardId);
	
	Integer getScoredCardQuality();
	void setScoredCardQuality(Integer scoredCardQuality);
	
	java.time.LocalDateTime getScoredCardScoredDate();
	void setScoredCardScoredDate(java.time.LocalDateTime scoredCardScoredDate);
	
	String getReinforceCardId();
	void setReinforceCardId(String reinforceCardId);
	
	java.time.LocalDateTime getReinforceCardCreatedDate();
	void setReinforceCardCreatedDate(java.time.LocalDateTime reinforceCardCreatedDate);
	
	String getUserId();
	void setUserId(String userId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	
}




/******* S.D.G. *******/



