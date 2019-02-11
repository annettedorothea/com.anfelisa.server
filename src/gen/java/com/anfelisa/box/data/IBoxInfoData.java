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

import com.anfelisa.ace.IDataContainer;

import com.anfelisa.box.models.IBoxInfoModel;

@JsonDeserialize(as=BoxInfoData.class)
public interface IBoxInfoData extends IBoxInfoModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.IBoxViewModel model);
	
	IBoxInfoData withUserId(String userId);
	
	IBoxInfoData withToday(org.joda.time.DateTime today);
	
	IBoxInfoData withTodaysCards(Integer todaysCards);
	
	IBoxInfoData withTotalCards(Integer totalCards);
	
	IBoxInfoData withReinforceCards(Integer reinforceCards);
	
	IBoxInfoData withMyCards(Integer myCards);
	
	IBoxInfoData withDaysBehindSchedule(Integer daysBehindSchedule);
	
	IBoxInfoData withCategoryName(String categoryName);
	
	IBoxInfoData withMaxInterval(Integer maxInterval);
	
	IBoxInfoData withMaxCardsPerDay(Integer maxCardsPerDay);
	
	IBoxInfoData withQuality0Count(Integer quality0Count);
	
	IBoxInfoData withQuality1Count(Integer quality1Count);
	
	IBoxInfoData withQuality2Count(Integer quality2Count);
	
	IBoxInfoData withQuality3Count(Integer quality3Count);
	
	IBoxInfoData withQuality4Count(Integer quality4Count);
	
	IBoxInfoData withQuality5Count(Integer quality5Count);
	
	IBoxInfoData withBoxId(String boxId);
	
	
}




/******* S.D.G. *******/



