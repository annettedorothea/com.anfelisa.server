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

import org.joda.time.DateTime;
import java.util.List;

@SuppressWarnings("unused")
public class CsvUploadTestData {
	
	private String uuid;

	private String userId;
	
	private String categoryId;
	
	private java.util.List<com.anfelisa.card.data.SimpleCardTestData> previewCsv;
	
	private java.util.List<com.anfelisa.card.data.CardTestData> cards;
	

	public CsvUploadTestData(
		@JsonProperty("userId") String userId, 
		@JsonProperty("categoryId") String categoryId, 
		@JsonProperty("previewCsv") java.util.List<com.anfelisa.card.data.SimpleCardTestData> previewCsv, 
		@JsonProperty("cards") java.util.List<com.anfelisa.card.data.CardTestData> cards, 
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
		this.userId = userId;
		this.categoryId = categoryId;
		this.previewCsv = previewCsv;
		this.cards = cards;
	}

	public CsvUploadTestData(
		@JsonProperty("uuid") String uuid
	) {
		this.uuid = uuid;
	}

	public CsvUploadTestData() {
	}

	@JsonProperty
	public String getUuid() {
		return this.uuid;
	}

	public String getUserId() {
		return this.userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCategoryId() {
		return this.categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	public java.util.List<com.anfelisa.card.data.SimpleCardTestData> getPreviewCsv() {
		return this.previewCsv;
	}
	public void setPreviewCsv(java.util.List<com.anfelisa.card.data.SimpleCardTestData> previewCsv) {
		this.previewCsv = previewCsv;
	}
	
	public java.util.List<com.anfelisa.card.data.CardTestData> getCards() {
		return this.cards;
	}
	public void setCards(java.util.List<com.anfelisa.card.data.CardTestData> cards) {
		this.cards = cards;
	}
	
}




/******* S.D.G. *******/



