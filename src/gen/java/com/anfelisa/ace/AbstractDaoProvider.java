package com.anfelisa.ace;

import javax.ws.rs.WebApplicationException;

import com.anfelisa.ace.encryption.EncryptionService;
import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class AbstractDaoProvider {

	protected final AceDao aceDao = new AceDao();

	protected final JodaObjectMapper mapper = new JodaObjectMapper();

	public void addActionToTimeline(IAction action) {
		try {
			String json = mapper.writeValueAsString(action.getActionData());
			addItemToTimeline("action", action.getHttpMethod().name(), action.getActionName(), json,
					action.getActionData().getUuid(), action.getDatabaseHandle());
		} catch (JsonProcessingException e) {
			throw new WebApplicationException(e);
		}
	}

	public void addCommandToTimeline(ICommand command) {
		try {
			addItemToTimeline("command", null, command.getCommandName(),
					mapper.writeValueAsString(command.getCommandData()), command.getCommandData().getUuid(),
					command.getDatabaseHandle());
		} catch (JsonProcessingException e) {
			throw new WebApplicationException(e);
		}
	}

	public void addEventToTimeline(IEvent event) {
		try {
			addItemToTimeline("event", null, event.getEventName(), mapper.writeValueAsString(event.getEventData()),
					event.getEventParam().getUuid(), event.getDatabaseHandle());
		} catch (JsonProcessingException e) {
			throw new WebApplicationException(e);
		}
	}

	public void addPreparingEventToTimeline(IEvent event, String uuid) {
		try {
			addItemToTimeline("preparing event", null, event.getEventName(),
					mapper.writeValueAsString(event.getEventData()), uuid, event.getDatabaseHandle());
		} catch (JsonProcessingException e) {
			throw new WebApplicationException(e);
		}
	}

	public void addExceptionToTimeline(String uuid, Throwable x, DatabaseHandle databaseHandle) {
		aceDao.insertIntoErrorTimeline(databaseHandle.getErrorHandle(), "exception", null, x.getClass().getName(),
				x.getMessage(), uuid);
	}

	private void addItemToTimeline(String type, String method, String name, String json, String uuid,
			DatabaseHandle databaseHandle) {
		if (databaseHandle == null) {
			throw new WebApplicationException("no database handle");
		}
		aceDao.insertIntoTimeline(databaseHandle.getHandle(), type, method, name, EncryptionService.encrypt(json),
				uuid);
		aceDao.insertIntoErrorTimeline(databaseHandle.getErrorHandle(), type, method, name,
				EncryptionService.encrypt(json), uuid);
	}

}

