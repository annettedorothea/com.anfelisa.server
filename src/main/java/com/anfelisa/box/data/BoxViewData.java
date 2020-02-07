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

public class BoxViewData extends AbstractBoxViewData implements IBoxViewData {

	public BoxViewData(
			@JsonProperty("todaysCards") Integer todaysCards,
			@JsonProperty("reinforceCards") Integer reinforceCards,
			@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay,
			@JsonProperty("myCards") Integer myCards,
			@JsonProperty("totalCards") Integer totalCards,
			@JsonProperty("categoryName") String categoryName,
			@JsonProperty("quality0Count") Integer quality0Count,
			@JsonProperty("quality1Count") Integer quality1Count,
			@JsonProperty("quality2Count") Integer quality2Count,
			@JsonProperty("quality3Count") Integer quality3Count,
			@JsonProperty("quality4Count") Integer quality4Count,
			@JsonProperty("quality5Count") Integer quality5Count,
			@JsonProperty("boxId") String boxId,
			@JsonProperty("uuid") String uuid) {
		super(
				todaysCards,
				reinforceCards,
				maxCardsPerDay,
				myCards,
				totalCards,
				categoryName,
				quality0Count,
				quality1Count,
				quality2Count,
				quality3Count,
				quality4Count,
				quality5Count,
				boxId,
				uuid);
	}

	public BoxViewData(String uuid) {
		super(uuid);
	}

	public void migrateLegacyData(String json) {
	}

	@Deprecated
	public BoxViewData(
			@JsonProperty("userId") String userId,
			@JsonProperty("today") org.joda.time.DateTime today,
			@JsonProperty("todaysCards") Integer todaysCards,
			@JsonProperty("tomorrowsCards") Integer tomorrowsCards,
			@JsonProperty("totalCards") Integer totalCards,
			@JsonProperty("reinforceCards") Integer reinforceCards,
			@JsonProperty("myCards") Integer myCards,
			@JsonProperty("daysBehindSchedule") Integer daysBehindSchedule,
			@JsonProperty("categoryName") String categoryName,
			@JsonProperty("maxInterval") Integer maxInterval,
			@JsonProperty("maxCardsPerDay") Integer maxCardsPerDay,
			@JsonProperty("quality0Count") Integer quality0Count,
			@JsonProperty("quality1Count") Integer quality1Count,
			@JsonProperty("quality2Count") Integer quality2Count,
			@JsonProperty("quality3Count") Integer quality3Count,
			@JsonProperty("quality4Count") Integer quality4Count,
			@JsonProperty("quality5Count") Integer quality5Count,
			@JsonProperty("boxId") String boxId,
			@JsonProperty("uuid") String uuid) {
		super(
				todaysCards,
				reinforceCards,
				maxCardsPerDay,
				myCards,
				totalCards,
				categoryName,
				quality0Count,
				quality1Count,
				quality2Count,
				quality3Count,
				quality4Count,
				quality5Count,
				boxId,
				uuid);
	}

}

/******* S.D.G. *******/
