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




package com.anfelisa.card;

import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.ace.TimelineItem;
import com.fasterxml.jackson.core.JsonProcessingException;

public class TestUtils {

	private static final JodaObjectMapper mapper = new JodaObjectMapper();

	public static TimelineItem createCreateCardOkEventTimelineItem(com.anfelisa.card.data.ICardCreationData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.card.events.CreateCardOkEvent", null, json, data.getUuid());
	}

	public static TimelineItem createUpdateCardOkEventTimelineItem(com.anfelisa.card.data.ICardUpdateData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.card.events.UpdateCardOkEvent", null, json, data.getUuid());
	}

	public static TimelineItem createDeleteCardOkEventTimelineItem(com.anfelisa.card.data.ICardDeleteData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.card.events.DeleteCardOkEvent", null, json, data.getUuid());
	}




	public static TimelineItem createMoveCardsOkEventTimelineItem(com.anfelisa.card.data.ICardIdListData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.card.events.MoveCardsOkEvent", null, json, data.getUuid());
	}

	
}




/******* S.D.G. *******/



