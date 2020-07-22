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

import com.anfelisa.box.models.ISortCardsOutModel;

@JsonDeserialize(as=SortCardsOutData.class)
public interface ISortCardsOutData extends ISortCardsOutModel, IDataContainer {
	
	ISortCardsOutData withSortedOutScheduledCardIds(java.util.List<String> sortedOutScheduledCardIds);
	
	ISortCardsOutData withSortedOutReinforceCardIds(java.util.List<String> sortedOutReinforceCardIds);
	
	ISortCardsOutData withCardIds(java.util.List<String> cardIds);
	
	ISortCardsOutData withUserId(String userId);
	
	ISortCardsOutData withBoxId(String boxId);
	
	
}



/******* S.D.G. *******/



