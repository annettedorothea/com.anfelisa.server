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
 * generated with de.acegen 0.9.7
 *
 */




package com.anfelisa.category.data;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import de.acegen.IDataContainer;

import com.anfelisa.category.models.ICategoryTreeItemModel;

@JsonDeserialize(as=CategoryTreeItemData.class)
public interface ICategoryTreeItemData extends ICategoryTreeItemModel, IDataContainer {
	
	ICategoryTreeItemData withCategoryId(String categoryId);
	
	ICategoryTreeItemData withCategoryName(String categoryName);
	
	ICategoryTreeItemData withCategoryIndex(Integer categoryIndex);
	
	ICategoryTreeItemData withEmpty(Boolean empty);
	
	ICategoryTreeItemData withParentCategoryId(String parentCategoryId);
	
	ICategoryTreeItemData withDictionaryLookup(Boolean dictionaryLookup);
	
	ICategoryTreeItemData withGivenLanguage(String givenLanguage);
	
	ICategoryTreeItemData withWantedLanguage(String wantedLanguage);
	
	ICategoryTreeItemData withRootCategoryId(String rootCategoryId);
	
	ICategoryTreeItemData withChildCategories(java.util.List<com.anfelisa.category.models.ICategoryTreeItemModel> childCategories);
	
	
}



/******* S.D.G. *******/



