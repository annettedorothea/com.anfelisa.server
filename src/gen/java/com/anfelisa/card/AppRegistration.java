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

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;
import com.anfelisa.ace.E2E;
import com.anfelisa.ace.PersistenceConnection;

import com.anfelisa.card.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		environment.jersey().register(new CreateCardAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new UpdateCardAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new DeleteCardAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetCardsAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetDuplicatesAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new MoveCardsAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ChangeOrderAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ImportCsvAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetTranslationAction(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
	}

	public static void registerConsumers(ViewProvider viewProvider, String mode) {
		viewProvider.addConsumer("com.anfelisa.card.events.CreateCardOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.insert((com.anfelisa.card.data.CardCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.UpdateCardOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.update((com.anfelisa.card.data.CardUpdateData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.DeleteCardOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.delete((com.anfelisa.card.data.CardDeleteData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.MoveCardsOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.moveCards((com.anfelisa.card.data.CardIdListData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.ChangeOrderOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.changeCardOrder((com.anfelisa.card.data.ChangeCardOrderListData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.card.events.ImportCsvOkEvent", (dataContainer, handle) -> {
			viewProvider.cardView.bulkInsert((com.anfelisa.card.data.CsvUploadData) dataContainer, handle);
		});
		
    }
}




/******* S.D.G. *******/



