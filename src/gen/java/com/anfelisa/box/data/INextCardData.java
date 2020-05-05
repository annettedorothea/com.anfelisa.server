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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.box.models.INextCardModel;

@JsonDeserialize(as=NextCardData.class)
public interface INextCardData extends INextCardModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.INextCardViewModel model);
	void mapFrom(com.anfelisa.box.models.ITodaysCardsStatusModel model);
	
	INextCardData withUserId(String userId);
	
	INextCardData withBoxId(String boxId);
	
	INextCardData withTodayAtMidnightInUTC(org.joda.time.DateTime todayAtMidnightInUTC);
	
	INextCardData withOpenTodaysCards(Integer openTodaysCards);
	
	INextCardData withAllTodaysCards(Integer allTodaysCards);
	
	INextCardData withScheduledCardId(String scheduledCardId);
	
	INextCardData withReinforceCardId(String reinforceCardId);
	
	INextCardData withCardId(String cardId);
	
	INextCardData withScheduledDate(org.joda.time.DateTime scheduledDate);
	
	INextCardData withLastQuality(Integer lastQuality);
	
	INextCardData withGiven(String given);
	
	INextCardData withWanted(String wanted);
	
	INextCardData withImage(String image);
	
	INextCardData withCategoryId(String categoryId);
	
	INextCardData withRootCategoryId(String rootCategoryId);
	
	INextCardData withCount(Integer count);
	
	INextCardData withScoredDate(org.joda.time.DateTime scoredDate);
	
	
}




/******* S.D.G. *******/



