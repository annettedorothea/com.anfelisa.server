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

import com.anfelisa.box.models.IBoxSettingsWrapperModel;

@JsonDeserialize(as=BoxSettingsWrapperData.class)
public interface IBoxSettingsWrapperData extends IBoxSettingsWrapperModel, IDataContainer {
	void mapFrom(com.anfelisa.box.models.IBoxSettingsModel model);
	
	IBoxSettingsWrapperData withUserId(String userId);
	
	IBoxSettingsWrapperData withBoxId(String boxId);
	
	IBoxSettingsWrapperData withMaxInterval(Integer maxInterval);
	
	IBoxSettingsWrapperData withMaxCardsPerDay(Integer maxCardsPerDay);
	
	IBoxSettingsWrapperData withCategoryName(String categoryName);
	
	IBoxSettingsWrapperData withDictionaryLookup(Boolean dictionaryLookup);
	
	IBoxSettingsWrapperData withGivenLanguage(String givenLanguage);
	
	IBoxSettingsWrapperData withWantedLanguage(String wantedLanguage);
	
	IBoxSettingsWrapperData withCategoryId(String categoryId);
	
	
}



/******* S.D.G. *******/



