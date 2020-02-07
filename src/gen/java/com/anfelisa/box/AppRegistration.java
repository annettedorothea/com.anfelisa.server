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




package com.anfelisa.box;

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;
import com.anfelisa.ace.E2E;

import org.jdbi.v3.core.Jdbi;


import com.anfelisa.box.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		environment.jersey().register(new GetBoxesAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new CreateBoxAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new UpdateBoxAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new InitMyBoxesForDayAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new DeleteBoxAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new LoadNextCardAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ScheduleCardsAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ScoreCardAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
	}

	public static void registerConsumers(ViewProvider viewProvider, String mode) {
		viewProvider.addConsumer("com.anfelisa.box.events.CreateBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.createBox((com.anfelisa.box.data.BoxData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.UpdateBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.updateBox((com.anfelisa.box.data.BoxUpdateData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.InitMyBoxesForDayOkEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.postponeCards((com.anfelisa.box.data.InitMyBoxesDataData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.InitMyBoxesForDayOkEvent", (dataContainer, handle) -> {
			viewProvider.reinforceCardView.clear((com.anfelisa.box.data.InitMyBoxesDataData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.DeleteBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.deleteBox((com.anfelisa.box.data.DeleteBoxData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScheduleCardsOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.scheduleCards((com.anfelisa.box.data.ScheduledCardsData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.score((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.scheduleNext((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.score((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.scheduleNext((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreAndReinforceEvent", (dataContainer, handle) -> {
			viewProvider.reinforceCardView.add((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
    }
}




/******* S.D.G. *******/



