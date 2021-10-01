/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package de.acegen;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Command<T extends IDataContainer> implements ICommand<T> {

	private String commandName;
	protected ObjectMapper mapper;
	protected IDaoProvider daoProvider;
	protected ViewProvider viewProvider;
	protected CustomAppConfiguration appConfiguration;

	public Command(String commandName, IDaoProvider daoProvider, ViewProvider viewProvider, CustomAppConfiguration appConfiguration) {
		super();
		this.commandName = commandName;
		mapper = new ObjectMapper();
		this.daoProvider = daoProvider;
		this.viewProvider = viewProvider;
		this.appConfiguration = appConfiguration;
	}

	protected abstract T executeCommand(T data, PersistenceHandle readonlyHandle);

	public T execute(T data, PersistenceHandle readonlyHandle, PersistenceHandle timelineHandle) {
		if (appConfiguration.getConfig().writeTimeline()) {
			daoProvider.getAceDao().addCommandToTimeline(this.getCommandName(), data, timelineHandle);
		}
		return this.executeCommand(data, readonlyHandle);
	}

	public String getCommandName() {
		return commandName;
	}

	protected void throwSecurityException() {
		throw new SecurityException();
	}

	protected void throwIllegalArgumentException(String error) {
		throw new IllegalArgumentException(error);
	}

}		



/******* S.D.G. *******/



