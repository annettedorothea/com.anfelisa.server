/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.box;

import io.dropwizard.setup.Environment;
import de.acegen.PersistenceConnection;
import de.acegen.CustomAppConfiguration;
import de.acegen.IDaoProvider;
import de.acegen.ViewProvider;

import com.anfelisa.box.resources.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, PersistenceConnection persistenceConnection, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider) {
		environment.jersey().register(new CreateBoxResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new CreateReverseBoxResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ArchiveBoxResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new UpdateBoxResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetBoxSettingsResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScheduleCardsResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new SortCardsOutResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScoreCardResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new ScoreReinforceCardResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new InitMyBoxesForDayResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetBoxesResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new GetBoxStatisticsResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new LoadNextCardResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new DeleteBoxResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
		environment.jersey().register(new LoadAllActiveCardsResource(persistenceConnection, appConfiguration, daoProvider, viewProvider));
	}
	
	public static void registerConsumers(ViewProvider viewProvider) {
		viewProvider.addConsumer("com.anfelisa.box.events.CreateBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.rootCategoryView.insert((com.anfelisa.box.data.BoxCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.CreateBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.userAccessToCategoryView.grantAccess((com.anfelisa.box.data.BoxCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.CreateBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.createBox((com.anfelisa.box.data.BoxCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.CreateReverseBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.createBox((com.anfelisa.box.data.BoxCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ArchiveBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.archiveBox((com.anfelisa.box.data.BoxArchiveData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.UpdateBoxCanEditCategoryEvent", (dataContainer, handle) -> {
			viewProvider.rootCategoryView.update((com.anfelisa.box.data.BoxUpdateData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.UpdateBoxOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.updateBox((com.anfelisa.box.data.BoxUpdateData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScheduleCardsOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.scheduleCards((com.anfelisa.box.data.ScheduledCardsData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.SortCardsOutOkEvent", (dataContainer, handle) -> {
			viewProvider.boxView.sortCardsOut((com.anfelisa.box.data.SortCardsOutData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.SortCardsOutOkEvent", (dataContainer, handle) -> {
			viewProvider.reinforceCardView.sortOut((com.anfelisa.box.data.SortCardsOutData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.score((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardScoreEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.scheduleNext((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreCardReinforceEvent", (dataContainer, handle) -> {
			viewProvider.reinforceCardView.add((com.anfelisa.box.data.ScoreCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreReinforceCardKeepEvent", (dataContainer, handle) -> {
			viewProvider.reinforceCardView.update((com.anfelisa.box.data.ScoreReinforceCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.ScoreReinforceCardRemoveEvent", (dataContainer, handle) -> {
			viewProvider.reinforceCardView.remove((com.anfelisa.box.data.ScoreReinforceCardData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.InitMyBoxesForDayOkEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.postponeCards((com.anfelisa.box.data.InitMyBoxesDataData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.InitMyBoxesForDayOkEvent", (dataContainer, handle) -> {
			viewProvider.reinforceCardView.clear((com.anfelisa.box.data.InitMyBoxesDataData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.DeleteBoxDeleteBoxEvent", (dataContainer, handle) -> {
			viewProvider.scheduledCardView.deleteAll((com.anfelisa.box.data.DeleteBoxData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.DeleteBoxDeleteBoxEvent", (dataContainer, handle) -> {
			viewProvider.reinforceCardView.deleteAll((com.anfelisa.box.data.DeleteBoxData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.DeleteBoxDeleteBoxEvent", (dataContainer, handle) -> {
			viewProvider.boxView.deleteBox((com.anfelisa.box.data.DeleteBoxData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.DeleteBoxDeleteBoxEvent", (dataContainer, handle) -> {
			viewProvider.userAccessToCategoryView.delete((com.anfelisa.box.data.DeleteBoxData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.box.events.DeleteBoxDeleteCategoryEvent", (dataContainer, handle) -> {
			viewProvider.rootCategoryView.deleteAll((com.anfelisa.box.data.DeleteBoxData) dataContainer, handle);
		});
		
	}
}



/******* S.D.G. *******/



