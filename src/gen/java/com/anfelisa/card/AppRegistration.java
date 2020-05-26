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
import de.acegen.PersistenceConnection;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.E2E;
import de.acegen.ViewProvider;

import com.anfelisa.card.resources.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		environment.jersey().register(new CreateCardResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new UpdateCardResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new DeleteCardResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetCardsResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetDuplicatesResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new MoveCardsResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ChangeOrderResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ImportCsvResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetTranslationResource(persistenceConnection, appConfiguration, daoProvider, viewProvider, e2e));
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
			viewProvider.cardView.moveCards((com.anfelisa.card.data.MoveCardsData) dataContainer, handle);
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



