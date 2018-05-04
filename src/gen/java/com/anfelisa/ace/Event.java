package com.anfelisa.ace;

import java.util.List;
import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class Event<T extends IDataContainer> implements IEvent {

	static final Logger LOG = LoggerFactory.getLogger(Event.class);

	protected T eventParam;
	protected T eventData;
	private String eventName;
	@JsonIgnore
	protected DatabaseHandle databaseHandle;
	protected JodaObjectMapper mapper;
	protected DaoProvider daoProvider;
	private ViewProvider viewProvider;

	public Event(String eventName, T eventParam, DatabaseHandle databaseHandle, DaoProvider daoProvider, ViewProvider viewProvider) {
		super();
		this.eventParam = eventParam;
		this.eventName = eventName;
		this.databaseHandle = databaseHandle;
		this.daoProvider = daoProvider;
		mapper = new JodaObjectMapper();
		this.viewProvider = viewProvider;
	}

	protected void prepareDataForView() {
	}

	@SuppressWarnings("unchecked")
	public void notifyListeners() {
		List<BiConsumer<? extends IDataContainer, Handle>> consumerList = viewProvider.getConsumerForEvent(eventName);
		if (consumerList != null) {
			for (BiConsumer<? extends IDataContainer, Handle> consumer : consumerList) {
				((BiConsumer<T, Handle>)consumer).accept(this.eventData, databaseHandle.getHandle());
			}
		}
	}

	public IDataContainer getEventParam() {
		return eventParam;
	}

	public IDataContainer getEventData() {
		return eventData;
	}

	public String getEventName() {
		return eventName;
	}

	@JsonIgnore
	public DatabaseHandle getDatabaseHandle() {
		return databaseHandle;
	}

	protected abstract String[] getNotifiedListeners();

	public void publish() {
		this.prepareDataForView();
		this.eventData.setNotifiedListeners(this.getNotifiedListeners());
		daoProvider.addEventToTimeline(this);
		this.notifyListeners();
	}

}

