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

import com.fasterxml.jackson.annotation.JsonProperty;

public class CsvUploadData extends AbstractCsvUploadData implements ICsvUploadData {
	
	public CsvUploadData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("previewCsv") java.util.List<com.anfelisa.card.models.ISimpleCardModel> previewCsv, 
		@JsonProperty("cards") java.util.List<com.anfelisa.card.models.ICardModel> cards, 
		@JsonProperty("uuid") String uuid
	) {
		super(
			userId,
			categoryId,
			previewCsv,
			cards,
			uuid
		);
	}

	public CsvUploadData( String uuid ) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

}




/******* S.D.G. *******/



