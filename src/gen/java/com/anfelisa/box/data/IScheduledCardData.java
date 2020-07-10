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




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IScheduledCardModel;

@JsonDeserialize(as=ScheduledCardData.class)
public interface IScheduledCardData extends IScheduledCardModel, IDataContainer {
	
	IScheduledCardData withScheduledCardId(String scheduledCardId);
	
	IScheduledCardData withCardId(String cardId);
	
	IScheduledCardData withBoxId(String boxId);
	
	IScheduledCardData withCreatedDate(java.time.LocalDateTime createdDate);
	
	IScheduledCardData withEf(Float ef);
	
	IScheduledCardData withInterval(Integer interval);
	
	IScheduledCardData withN(Integer n);
	
	IScheduledCardData withCount(Integer count);
	
	IScheduledCardData withScheduledDate(java.time.LocalDateTime scheduledDate);
	
	IScheduledCardData withLastQuality(Integer lastQuality);
	
	IScheduledCardData withQuality(Integer quality);
	
	IScheduledCardData withScoredDate(java.time.LocalDateTime scoredDate);
	
	
}



/******* S.D.G. *******/



