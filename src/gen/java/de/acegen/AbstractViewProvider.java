/********************************************************************************
 * generated by de.acegen 1.1.0
 ********************************************************************************/




package de.acegen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AbstractViewProvider {

	private final Map<String, List<EventConsumer>> consumerMap;
	private final Map<String, List<EventConsumer>> afterCommitConsumerMap;

	public AbstractViewProvider() {
		consumerMap = new HashMap<String, List<EventConsumer>>();
		afterCommitConsumerMap = new HashMap<String, List<EventConsumer>>();
	}
	
	public void addConsumer(String eventName, EventConsumer eventConsumer) {
		List<EventConsumer> consumerForEvent = consumerMap.get(eventName);
		if (consumerForEvent == null) {
			consumerForEvent = new ArrayList<EventConsumer>();
			consumerMap.put(eventName, consumerForEvent);
		}
		consumerForEvent.add(eventConsumer);
	}

	public void addAfterCommitConsumer(String eventName, EventConsumer eventConsumer) {
		List<EventConsumer> consumerForEvent = afterCommitConsumerMap.get(eventName);
		if (consumerForEvent == null) {
			consumerForEvent = new ArrayList<EventConsumer>();
			afterCommitConsumerMap.put(eventName, consumerForEvent);
		}
		consumerForEvent.add(eventConsumer);
	}

	public List<EventConsumer> getConsumerForEvent(String eventName) {
		return consumerMap.get(eventName);
	}

	public List<EventConsumer> getAfterCommitConsumerForEvent(String eventName) {
		return afterCommitConsumerMap.get(eventName);
	}

}




/******* S.D.G. *******/



