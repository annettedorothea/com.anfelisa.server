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

	public static TimelineItem createPostponeCardsOkEventTimelineItem(com.anfelisa.box.data.IPostponeCardsData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.PostponeCardsOkEvent", null, json, data.getUuid());
	}
	public static TimelineItem createPostponeCardsNoDelayEventTimelineItem(com.anfelisa.box.data.IPostponeCardsData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.PostponeCardsNoDelayEvent", null, json, data.getUuid());
	}

	public static TimelineItem createDeleteBoxOkEventTimelineItem(com.anfelisa.box.data.IDeleteBoxData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.DeleteBoxOkEvent", null, json, data.getUuid());
	}



	public static TimelineItem createScheduleNextCardOkEventTimelineItem(com.anfelisa.box.data.IScheduleNextCardData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.box.events.ScheduleNextCardOkEvent", null, json, data.getUuid());
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

