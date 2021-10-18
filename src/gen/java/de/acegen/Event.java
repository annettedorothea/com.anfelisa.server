/********************************************************************************
 * generated by de.acegen 1.6.4
 ********************************************************************************/




package de.acegen;

import java.util.List;

public class Event<T extends IDataContainer> implements IEvent<T> {

	private String eventName;
	private ViewProvider viewProvider;

	public Event(String eventName, ViewProvider viewProvider) {
		super();
		this.eventName = eventName;
		this.viewProvider = viewProvider;
	}

	public void notifyListeners(T data, PersistenceHandle handle) {
		List<EventConsumer> consumerList = viewProvider.getConsumerForEvent(eventName);
		if (consumerList != null) {
			for (EventConsumer consumer : consumerList) {
				consumer.consumeEvent(data, handle);
			}
		} else if (viewProvider.getAfterCommitConsumerForEvent(eventName) == null) {
			System.out.println("No listeners for " + eventName + " found. Did you forget to register them?");
		}
	}

	public void notifyAfterCommitListeners(T data, PersistenceHandle handle) {
		List<EventConsumer> consumerList = viewProvider.getAfterCommitConsumerForEvent(eventName);
		if (consumerList != null) {
			for (EventConsumer consumer : consumerList) {
				consumer.consumeEvent(data, handle);
			}
		} else if(viewProvider.getConsumerForEvent(eventName) == null) {
			System.out.println("No listeners for " + eventName + " found. Did you forget to register them?");
		}
	}

	public String getEventName() {
		return eventName;
	}

	public void publish(T data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		this.notifyListeners(data, handle);
	}

	public void publishAfterCommit(T data, PersistenceHandle handle, PersistenceHandle timelineHandle) {
		this.notifyAfterCommitListeners(data, handle);
	}

}



/******* S.D.G. *******/



