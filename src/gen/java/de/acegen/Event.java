/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package de.acegen;

import java.util.List;

public abstract class Event<T extends IDataContainer> implements IEvent {

	private T eventData;
	private String eventName;
	private IDaoProvider daoProvider;
	private ViewProvider viewProvider;
	private CustomAppConfiguration appConfiguration;

	public Event(String eventName, T eventData, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super();
		this.eventData = eventData;
		this.eventName = eventName;
		this.daoProvider = daoProvider;
		this.viewProvider = viewProvider;
		this.appConfiguration = appConfiguration;
	}

	public void notifyListeners(PersistenceHandle handle) {
		List<EventConsumer> consumerList = viewProvider.getConsumerForEvent(eventName);
		if (consumerList != null) {
			for (EventConsumer consumer : consumerList) {
				consumer.consumeEvent(this.eventData, handle);
			}
		}
	}

	public IDataContainer getEventData() {
		return eventData;
	}

	public String getEventName() {
		return eventName;
	}

	public void publish(PersistenceHandle handle, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			daoProvider.getAceDao().addEventToTimeline(this, timelineHandle);
		}
		this.notifyListeners(handle);
	}

}



/******* S.D.G. *******/



