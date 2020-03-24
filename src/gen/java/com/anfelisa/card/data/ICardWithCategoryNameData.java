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




package com.anfelisa.card.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.card.models.ICardWithCategoryNameModel;

@JsonDeserialize(as=CardWithCategoryNameData.class)
public interface ICardWithCategoryNameData extends ICardWithCategoryNameModel, IDataContainer {
	void mapFrom(com.anfelisa.card.models.ICardModel model);
	
	ICardWithCategoryNameData withCategoryName(String categoryName);
	
	ICardWithCategoryNameData withCardId(String cardId);
	
	ICardWithCategoryNameData withGiven(String given);
	
	ICardWithCategoryNameData withWanted(String wanted);
	
	ICardWithCategoryNameData withImage(String image);
	
	ICardWithCategoryNameData withCardAuthor(String cardAuthor);
	
	ICardWithCategoryNameData withCardIndex(Integer cardIndex);
	
	ICardWithCategoryNameData withCategoryId(String categoryId);
	
	ICardWithCategoryNameData withRootCategoryId(String rootCategoryId);
	
	
}




/******* S.D.G. *******/



