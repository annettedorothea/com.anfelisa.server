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
@JsonDeserialize(as=ScheduledCardModel.class)
public interface IScheduledCardModel {

	String getScheduledCardId();
	void setScheduledCardId(String scheduledCardId);
	
	String getCardId();
	void setCardId(String cardId);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	java.time.LocalDateTime getCreatedDate();
	void setCreatedDate(java.time.LocalDateTime createdDate);
	
	Float getEf();
	void setEf(Float ef);
	
	Integer getInterval();
	void setInterval(Integer interval);
	
	Integer getN();
	void setN(Integer n);
	
	Integer getCount();
	void setCount(Integer count);
	
	java.time.LocalDateTime getScheduledDate();
	void setScheduledDate(java.time.LocalDateTime scheduledDate);
	
	Integer getLastQuality();
	void setLastQuality(Integer lastQuality);
	
	Integer getQuality();
	void setQuality(Integer quality);
	
	java.time.LocalDateTime getScoredDate();
	void setScoredDate(java.time.LocalDateTime scoredDate);
	
	
}




/******* S.D.G. *******/



