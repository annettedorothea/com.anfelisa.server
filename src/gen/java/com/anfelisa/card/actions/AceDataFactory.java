/* 
 * Copyright (c) 2020, Annette Pohl, Koblenz, Germany
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
 *
 * generated with de.acegen 0.9.2
 *
 */




package com.anfelisa.card.actions;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.acegen.IDataContainer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.anfelisa.card.data.*;
import com.fasterxml.jackson.databind.DeserializationFeature;		

public class AceDataFactory {
	
	private static ObjectMapper mapper = new ObjectMapper();
	private static final Logger LOG = LoggerFactory.getLogger(AceDataFactory.class);

	static {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}

	public static IDataContainer createAceData(String className, String json) {
		try {
			if (className.equals("com.anfelisa.card.actions.CreateCardAction") ||
					className.equals("com.anfelisa.card.commands.CreateCardCommand") ||
					className.equals("com.anfelisa.card.events.CreateCardOkEvent")
			) {
				CardCreationData data = mapper.readValue(json, CardCreationData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.UpdateCardAction") ||
					className.equals("com.anfelisa.card.commands.UpdateCardCommand") ||
					className.equals("com.anfelisa.card.events.UpdateCardOkEvent")
			) {
				CardUpdateData data = mapper.readValue(json, CardUpdateData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.DeleteCardAction") ||
					className.equals("com.anfelisa.card.commands.DeleteCardCommand") ||
					className.equals("com.anfelisa.card.events.DeleteCardOkEvent")
			) {
				CardDeleteData data = mapper.readValue(json, CardDeleteData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.GetCardsAction")) {
				CardListData data = mapper.readValue(json, CardListData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.GetDuplicatesAction")) {
				CardSearchData data = mapper.readValue(json, CardSearchData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.MoveCardsAction") ||
					className.equals("com.anfelisa.card.commands.MoveCardsCommand") ||
					className.equals("com.anfelisa.card.events.MoveCardsOkEvent")
			) {
				MoveCardsData data = mapper.readValue(json, MoveCardsData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.ChangeOrderAction") ||
					className.equals("com.anfelisa.card.commands.ChangeOrderCommand") ||
					className.equals("com.anfelisa.card.events.ChangeOrderOkEvent")
			) {
				ChangeCardOrderListData data = mapper.readValue(json, ChangeCardOrderListData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.ImportCsvAction") ||
					className.equals("com.anfelisa.card.commands.ImportCsvCommand") ||
					className.equals("com.anfelisa.card.events.ImportCsvOkEvent")
			) {
				CsvUploadData data = mapper.readValue(json, CsvUploadData.class);
				data.migrateLegacyData(json);
				return data;
			}
			if (className.equals("com.anfelisa.card.actions.GetTranslationAction")) {
				CardTranslationData data = mapper.readValue(json, CardTranslationData.class);
				data.migrateLegacyData(json);
				return data;
			}
		} catch (IOException e) {
			LOG.error("failed to create ace data {} with data {}", className, json, e);
		}

		return null;
	}
}



/******* S.D.G. *******/



