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

