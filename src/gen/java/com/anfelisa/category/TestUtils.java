package com.anfelisa.category;

import com.anfelisa.ace.JodaObjectMapper;
import com.anfelisa.ace.TimelineItem;
import com.fasterxml.jackson.core.JsonProcessingException;

public class TestUtils {

	private static final JodaObjectMapper mapper = new JodaObjectMapper();

	public static TimelineItem createCreateCategorySubEventTimelineItem(com.anfelisa.category.data.ICategoryCreationData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.CreateCategorySubEvent", null, json, data.getUuid());
	}
	public static TimelineItem createCreateCategoryRootEventTimelineItem(com.anfelisa.category.data.ICategoryCreationData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.CreateCategoryRootEvent", null, json, data.getUuid());
	}
	
	public static TimelineItem createUpdateCategoryOkEventTimelineItem(com.anfelisa.category.data.ICategoryUpdateData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.UpdateCategoryOkEvent", null, json, data.getUuid());
	}
	
	public static TimelineItem createDeleteCategoryNoRootEventTimelineItem(com.anfelisa.category.data.ICategoryDeleteData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.DeleteCategoryNoRootEvent", null, json, data.getUuid());
	}
	public static TimelineItem createDeleteCategoryRootEventTimelineItem(com.anfelisa.category.data.ICategoryDeleteData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.DeleteCategoryRootEvent", null, json, data.getUuid());
	}
	
	public static TimelineItem createInviteUserOkEventTimelineItem(com.anfelisa.category.data.IInviteUserData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.InviteUserOkEvent", null, json, data.getUuid());
	}
	public static TimelineItem createInviteUserHasAccessEventTimelineItem(com.anfelisa.category.data.IInviteUserData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.InviteUserHasAccessEvent", null, json, data.getUuid());
	}
	
	public static TimelineItem createRevokeUserAccessOkEventTimelineItem(com.anfelisa.category.data.IRevokeUserData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.RevokeUserAccessOkEvent", null, json, data.getUuid());
	}
	public static TimelineItem createRevokeUserAccessHasNoAccessEventTimelineItem(com.anfelisa.category.data.IRevokeUserData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.RevokeUserAccessHasNoAccessEvent", null, json, data.getUuid());
	}
	
	
	
	public static TimelineItem createMoveCategoryOkEventTimelineItem(com.anfelisa.category.data.ICategoryMoveData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.MoveCategoryOkEvent", null, json, data.getUuid());
	}
	public static TimelineItem createMoveCategoryNoMoveEventTimelineItem(com.anfelisa.category.data.ICategoryMoveData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.MoveCategoryNoMoveEvent", null, json, data.getUuid());
	}
	
	
}

