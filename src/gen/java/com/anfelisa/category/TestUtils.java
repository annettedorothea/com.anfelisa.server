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

	public static TimelineItem createChangeOrderCategoryOkEventTimelineItem(com.anfelisa.category.data.ICategoryChangeOrderData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.ChangeOrderCategoryOkEvent", null, json, data.getUuid());
	}
	public static TimelineItem createChangeOrderCategoryNoMoveEventTimelineItem(com.anfelisa.category.data.ICategoryChangeOrderData data) throws JsonProcessingException {
		String json = mapper.writeValueAsString(data);
		return new TimelineItem("prepare", null, "com.anfelisa.category.events.ChangeOrderCategoryNoMoveEvent", null, json, data.getUuid());
	}

	
}




/******* S.D.G. *******/



