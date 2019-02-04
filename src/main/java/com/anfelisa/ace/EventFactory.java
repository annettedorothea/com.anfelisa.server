package com.anfelisa.ace;

public class EventFactory {
	public static IEvent createEvent(String eventClass, String json, IDaoProvider daoProvider,
			ViewProvider viewProvider) {
		if (eventClass.startsWith("com.anfelisa.box.events")) {
			return com.anfelisa.box.events.EventFactory.createEvent(eventClass, json, daoProvider, viewProvider);
		}
		if (eventClass.startsWith("com.anfelisa.card.events")) {
			return com.anfelisa.card.events.EventFactory.createEvent(eventClass, json, daoProvider, viewProvider);
		}
		if (eventClass.startsWith("com.anfelisa.category.events")) {
			return com.anfelisa.category.events.EventFactory.createEvent(eventClass, json, daoProvider, viewProvider);
		}
		if (eventClass.startsWith("com.anfelisa.user.events")) {
			return com.anfelisa.user.events.EventFactory.createEvent(eventClass, json, daoProvider, viewProvider);
		}
		return null;
	}
}
