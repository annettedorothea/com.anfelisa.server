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
 * generated with de.acegen 0.9.8
 *
 */




package com.anfelisa.box.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.IScheduledCardsModel;

@JsonDeserialize(as=ScheduledCardsData.class)
public interface IScheduledCardsData extends IScheduledCardsModel, IDataContainer {
	
	IScheduledCardsData withNewScheduledCards(java.util.List<com.anfelisa.box.models.IScheduledCardModel> newScheduledCards);
	
	IScheduledCardsData withExistingScheduledCardIds(java.util.List<String> existingScheduledCardIds);
	
	IScheduledCardsData withCardIds(java.util.List<String> cardIds);
	
	IScheduledCardsData withScheduledDate(java.time.LocalDateTime scheduledDate);
	
	IScheduledCardsData withUserId(String userId);
	
	IScheduledCardsData withBoxId(String boxId);
	
	
}



/******* S.D.G. *******/



