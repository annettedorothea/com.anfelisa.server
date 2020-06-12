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

import com.anfelisa.box.models.IBoxCreationModel;

@JsonDeserialize(as=BoxCreationData.class)
public interface IBoxCreationData extends IBoxCreationModel, IDataContainer {
	void mapFrom(com.anfelisa.category.models.ICategoryModel model);
	void mapFrom(com.anfelisa.category.models.IUserAccessToCategoryModel model);
	void mapFrom(com.anfelisa.box.models.IBoxModel model);
	
	IBoxCreationData withUsername(String username);
	
	IBoxCreationData withCategoryId(String categoryId);
	
	IBoxCreationData withCategoryName(String categoryName);
	
	IBoxCreationData withCategoryAuthor(String categoryAuthor);
	
	IBoxCreationData withCategoryIndex(Integer categoryIndex);
	
	IBoxCreationData withParentCategoryId(String parentCategoryId);
	
	IBoxCreationData withRootCategoryId(String rootCategoryId);
	
	IBoxCreationData withDictionaryLookup(Boolean dictionaryLookup);
	
	IBoxCreationData withGivenLanguage(String givenLanguage);
	
	IBoxCreationData withWantedLanguage(String wantedLanguage);
	
	IBoxCreationData withUserId(String userId);
	
	IBoxCreationData withEditable(Boolean editable);
	
	IBoxCreationData withBoxId(String boxId);
	
	IBoxCreationData withMaxInterval(Integer maxInterval);
	
	IBoxCreationData withMaxCardsPerDay(Integer maxCardsPerDay);
	
	
}



/******* S.D.G. *******/



