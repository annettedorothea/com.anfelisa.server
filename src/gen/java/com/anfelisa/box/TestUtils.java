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




package com.anfelisa.box;

import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.ace.TimelineItem;
import com.fasterxml.jackson.core.JsonProcessingException;

public class TestUtils {

	private static final JodaObjectMapper mapper = new JodaObjectMapper();


	public static TimelineItem createCreateBoxOkEventTimelineItem(com.anfelisa.box.data.IBoxData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.CreateBoxOkEvent", null, json, data.getUuid());
	}

	public static TimelineItem createUpdateBoxOkEventTimelineItem(com.anfelisa.box.data.IBoxUpdateData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.UpdateBoxOkEvent", null, json, data.getUuid());
	}

	public static TimelineItem createInitMyBoxesForDayOkEventTimelineItem(com.anfelisa.box.data.IInitMyBoxesDataData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.InitMyBoxesForDayOkEvent", null, json, data.getUuid());
	}

	public static TimelineItem createDeleteBoxOkEventTimelineItem(com.anfelisa.box.data.IDeleteBoxData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.DeleteBoxOkEvent", null, json, data.getUuid());
	}



	public static TimelineItem createScheduleCardsOkEventTimelineItem(com.anfelisa.box.data.IScheduledCardsData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.ScheduleCardsOkEvent", null, json, data.getUuid());
	}
	public static TimelineItem createScheduleCardsNullOrEmptyEventTimelineItem(com.anfelisa.box.data.IScheduledCardsData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.ScheduleCardsNullOrEmptyEvent", null, json, data.getUuid());
	}

	public static TimelineItem createScoreCardScoreEventTimelineItem(com.anfelisa.box.data.IScoreCardData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.ScoreCardScoreEvent", null, json, data.getUuid());
	}
	public static TimelineItem createScoreCardScoreAndReinforceEventTimelineItem(com.anfelisa.box.data.IScoreCardData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", null, json, data.getUuid());
	}

	public static TimelineItem createScoreReinforceCardRemoveEventTimelineItem(com.anfelisa.box.data.IScoreReinforceCardData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.ScoreReinforceCardRemoveEvent", null, json, data.getUuid());
	}
	public static TimelineItem createScoreReinforceCardKeepEventTimelineItem(com.anfelisa.box.data.IScoreReinforceCardData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.ScoreReinforceCardKeepEvent", null, json, data.getUuid());
	}

	
}




/******* S.D.G. *******/



