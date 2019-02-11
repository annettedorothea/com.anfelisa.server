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




package com.anfelisa.category.events;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IEvent;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.category.data.*;
import com.anfelisa.ace.JodaObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.anfelisa.ace.IDataContainer;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventFactory {
	
	private static JodaObjectMapper mapper = new JodaObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(EventFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider, ViewProvider viewProvider) {
		try {
			if (eventClass.equals("com.anfelisa.category.events.CreateCategorySubEvent")) {
				CategoryCreationData data = mapper.readValue(json, CategoryCreationData.class);
				data.migrateLegacyData(json);
				CreateCategorySubEvent event = new CreateCategorySubEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.CreateCategoryRootEvent")) {
				CategoryCreationData data = mapper.readValue(json, CategoryCreationData.class);
				data.migrateLegacyData(json);
				CreateCategoryRootEvent event = new CreateCategoryRootEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.UpdateCategoryOkEvent")) {
				CategoryUpdateData data = mapper.readValue(json, CategoryUpdateData.class);
				data.migrateLegacyData(json);
				UpdateCategoryOkEvent event = new UpdateCategoryOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.DeleteCategoryNoRootEvent")) {
				CategoryDeleteData data = mapper.readValue(json, CategoryDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCategoryNoRootEvent event = new DeleteCategoryNoRootEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.DeleteCategoryRootEvent")) {
				CategoryDeleteData data = mapper.readValue(json, CategoryDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCategoryRootEvent event = new DeleteCategoryRootEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.InviteUserOkEvent")) {
				InviteUserData data = mapper.readValue(json, InviteUserData.class);
				data.migrateLegacyData(json);
				InviteUserOkEvent event = new InviteUserOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.RevokeUserAccessOkEvent")) {
				RevokeUserData data = mapper.readValue(json, RevokeUserData.class);
				data.migrateLegacyData(json);
				RevokeUserAccessOkEvent event = new RevokeUserAccessOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.category.events.MoveCategoryOkEvent")) {
				CategoryMoveData data = mapper.readValue(json, CategoryMoveData.class);
				data.migrateLegacyData(json);
				MoveCategoryOkEvent event = new MoveCategoryOkEvent(data, daoProvider, viewProvider);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}

	public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider) {
		if (eventClass.equals("com.anfelisa.category.events.CreateCategorySubEvent")) {
			return new CreateCategorySubEvent((CategoryCreationData)data, daoProvider, viewProvider);
		}
		if (eventClass.equals("com.anfelisa.category.events.CreateCategoryRootEvent")) {
			return new CreateCategoryRootEvent((CategoryCreationData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.category.events.UpdateCategoryOkEvent")) {
			return new UpdateCategoryOkEvent((CategoryUpdateData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.category.events.DeleteCategoryNoRootEvent")) {
			return new DeleteCategoryNoRootEvent((CategoryDeleteData)data, daoProvider, viewProvider);
		}
		if (eventClass.equals("com.anfelisa.category.events.DeleteCategoryRootEvent")) {
			return new DeleteCategoryRootEvent((CategoryDeleteData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.category.events.InviteUserOkEvent")) {
			return new InviteUserOkEvent((InviteUserData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.category.events.RevokeUserAccessOkEvent")) {
			return new RevokeUserAccessOkEvent((RevokeUserData)data, daoProvider, viewProvider);
		}



		if (eventClass.equals("com.anfelisa.category.events.MoveCategoryOkEvent")) {
			return new MoveCategoryOkEvent((CategoryMoveData)data, daoProvider, viewProvider);
		}


		return null;
	}
}




/******* S.D.G. *******/



