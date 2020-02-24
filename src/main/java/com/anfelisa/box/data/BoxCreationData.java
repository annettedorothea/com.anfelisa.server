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

import com.fasterxml.jackson.annotation.JsonProperty;

public class BoxCreationData extends AbstractBoxCreationData implements IBoxCreationData {
	
	public BoxCreationData(
		@JsonProperty("username") String username, 
		@JsonProperty("maxInterval") Integer maxInterval, 
		@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("categoryName") String categoryName, 
		@JsonProperty("categoryAuthor") String categoryAuthor, 
		@JsonProperty("categoryIndex") Integer categoryIndex, 
		@JsonProperty("parentCategoryId") String parentCategoryId, 
		@JsonProperty("rootCategoryId") String rootCategoryId, 
		@JsonProperty("dictionaryLookup") Boolean dictionaryLookup, 
		@JsonProperty("givenLanguage") String givenLanguage, 
		@JsonProperty("wantedLanguage") String wantedLanguage, 
		@JsonProperty("userId") String userId, 
		@JsonProperty("editable") Boolean editable, 
		@JsonProperty("boxId") String boxId, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			username,
			maxInterval,
			maxCardsPerDay,
			categoryId,
			categoryName,
			categoryAuthor,
			categoryIndex,
			parentCategoryId,
			rootCategoryId,
			dictionaryLookup,
			givenLanguage,
			wantedLanguage,
			userId,
			editable,
			boxId,
			uuid
		);
	}

	public BoxCreationData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}




/******* S.D.G. *******/


