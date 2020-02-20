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

import io.dropwizard.setup.Environment;
import com.anfelisa.ace.CustomAppConfiguration;
import com.anfelisa.ace.AceExecutionMode;
import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.ViewProvider;
import com.anfelisa.ace.ServerConfiguration;
import com.anfelisa.ace.E2E;

import org.jdbi.v3.core.Jdbi;


import com.anfelisa.category.actions.*;

@SuppressWarnings("all")
public class AppRegistration {

	public static void registerResources(Environment environment, Jdbi jdbi, CustomAppConfiguration appConfiguration, 
			IDaoProvider daoProvider, ViewProvider viewProvider, E2E e2e) {
		environment.jersey().register(new CreateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new UpdateCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new DeleteCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new GetCategoryTreeAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new MoveCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
		environment.jersey().register(new ChangeOrderCategoryAction(jdbi, appConfiguration, daoProvider, viewProvider, e2e));
	}

	public static void registerConsumers(ViewProvider viewProvider, String mode) {
		viewProvider.addConsumer("com.anfelisa.category.events.CreateCategorySubEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.insert((com.anfelisa.category.data.CategoryCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.CreateCategoryRootEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.insert((com.anfelisa.category.data.CategoryCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.CreateCategoryRootEvent", (dataContainer, handle) -> {
			viewProvider.userAccessToCategoryView.grantAccess((com.anfelisa.category.data.CategoryCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.CreateCategoryRootEvent", (dataContainer, handle) -> {
			viewProvider.boxCategoryView.createBox((com.anfelisa.category.data.CategoryCreationData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.UpdateCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.update((com.anfelisa.category.data.CategoryUpdateData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.DeleteCategoryNoRootEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.delete((com.anfelisa.category.data.CategoryDeleteData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.DeleteCategoryRootEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.deleteRoot((com.anfelisa.category.data.CategoryDeleteData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.MoveCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.moveCategory((com.anfelisa.category.data.CategoryMoveData) dataContainer, handle);
		});
		
		viewProvider.addConsumer("com.anfelisa.category.events.ChangeOrderCategoryOkEvent", (dataContainer, handle) -> {
			viewProvider.categoryView.changeOrder((com.anfelisa.category.data.CategoryChangeOrderData) dataContainer, handle);
		});
		
    }
}




/******* S.D.G. *******/



