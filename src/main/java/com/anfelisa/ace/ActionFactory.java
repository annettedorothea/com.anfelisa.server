package com.anfelisa.ace;

import org.jdbi.v3.core.Jdbi;

public class ActionFactory {
	public static IAction createAction(String actionClass, String json, Jdbi jdbi,
			CustomAppConfiguration appConfiguration, IDaoProvider daoProvider, ViewProvider viewProvider) {
		if (actionClass.startsWith("com.anfelisa.box.events")) {
			return com.anfelisa.box.actions.ActionFactory.createAction(actionClass, json, jdbi, appConfiguration,
					daoProvider, viewProvider);
		}
		if (actionClass.startsWith("com.anfelisa.card.events")) {
			return com.anfelisa.card.actions.ActionFactory.createAction(actionClass, json, jdbi, appConfiguration,
					daoProvider, viewProvider);
		}
		if (actionClass.startsWith("com.anfelisa.category.events")) {
			return com.anfelisa.category.actions.ActionFactory.createAction(actionClass, json, jdbi, appConfiguration,
					daoProvider, viewProvider);
		}
		if (actionClass.startsWith("com.anfelisa.user.events")) {
			return com.anfelisa.user.actions.ActionFactory.createAction(actionClass, json, jdbi, appConfiguration,
					daoProvider, viewProvider);
		}
		return null;
	}
}
