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




package com.anfelisa.card.events;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.IEvent;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.card.data.*;
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
			if (eventClass.equals("com.anfelisa.card.events.CreateCardOkEvent")) {
				CardCreationData data = mapper.readValue(json, CardCreationData.class);
				data.migrateLegacyData(json);
				CreateCardOkEvent event = new CreateCardOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.UpdateCardOkEvent")) {
				CardUpdateData data = mapper.readValue(json, CardUpdateData.class);
				data.migrateLegacyData(json);
				UpdateCardOkEvent event = new UpdateCardOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.DeleteCardOkEvent")) {
				CardDeleteData data = mapper.readValue(json, CardDeleteData.class);
				data.migrateLegacyData(json);
				DeleteCardOkEvent event = new DeleteCardOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.MoveCardsOkEvent")) {
				CardIdListData data = mapper.readValue(json, CardIdListData.class);
				data.migrateLegacyData(json);
				MoveCardsOkEvent event = new MoveCardsOkEvent(data, daoProvider, viewProvider);
				return event;
			}
			if (eventClass.equals("com.anfelisa.card.events.ImportCsvOkEvent")) {
				CsvUploadData data = mapper.readValue(json, CsvUploadData.class);
				data.migrateLegacyData(json);
				ImportCsvOkEvent event = new ImportCsvOkEvent(data, daoProvider, viewProvider);
				return event;
			}
		} catch (IOException e) {
			LOG.error("failed to create event {} with data {}", eventClass, json, e);
		}

		return null;
	}

	public static IEvent createEvent(String eventClass, IDataContainer data, IDaoProvider daoProvider, ViewProvider viewProvider) {
		if (eventClass.equals("com.anfelisa.card.events.CreateCardOkEvent")) {
			return new CreateCardOkEvent((CardCreationData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.card.events.UpdateCardOkEvent")) {
			return new UpdateCardOkEvent((CardUpdateData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.card.events.DeleteCardOkEvent")) {
			return new DeleteCardOkEvent((CardDeleteData)data, daoProvider, viewProvider);
		}


		if (eventClass.equals("com.anfelisa.card.events.MoveCardsOkEvent")) {
			return new MoveCardsOkEvent((CardIdListData)data, daoProvider, viewProvider);
		}

		if (eventClass.equals("com.anfelisa.card.events.ImportCsvOkEvent")) {
			return new ImportCsvOkEvent((CsvUploadData)data, daoProvider, viewProvider);
		}


		return null;
	}
}




/******* S.D.G. *******/



