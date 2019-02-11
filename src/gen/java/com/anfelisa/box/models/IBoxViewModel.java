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

import java.util.List;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@SuppressWarnings("unused")
@JsonDeserialize(as=BoxViewModel.class)
public interface IBoxViewModel {

	Integer getTodaysCards();
	void setTodaysCards(Integer todaysCards);
	
	Integer getTotalCards();
	void setTotalCards(Integer totalCards);
	
	Integer getReinforceCards();
	void setReinforceCards(Integer reinforceCards);
	
	Integer getMyCards();
	void setMyCards(Integer myCards);
	
	Integer getDaysBehindSchedule();
	void setDaysBehindSchedule(Integer daysBehindSchedule);
	
	String getCategoryName();
	void setCategoryName(String categoryName);
	
	Integer getMaxInterval();
	void setMaxInterval(Integer maxInterval);
	
	Integer getMaxCardsPerDay();
	void setMaxCardsPerDay(Integer maxCardsPerDay);
	
	Integer getQuality0Count();
	void setQuality0Count(Integer quality0Count);
	
	Integer getQuality1Count();
	void setQuality1Count(Integer quality1Count);
	
	Integer getQuality2Count();
	void setQuality2Count(Integer quality2Count);
	
	Integer getQuality3Count();
	void setQuality3Count(Integer quality3Count);
	
	Integer getQuality4Count();
	void setQuality4Count(Integer quality4Count);
	
	Integer getQuality5Count();
	void setQuality5Count(Integer quality5Count);
	
	String getBoxId();
	void setBoxId(String boxId);
	
	
	List<String> equalsPrimitiveTypes(com.anfelisa.box.models.IBoxViewModel other);
	
}




/******* S.D.G. *******/



