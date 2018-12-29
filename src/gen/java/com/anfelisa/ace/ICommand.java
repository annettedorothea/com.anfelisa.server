package com.anfelisa.ace;

public interface ICommand {

	String getCommandName();

	IDataContainer getCommandData();

	DatabaseHandle getDatabaseHandle();

	void initCommandData(String json);

	void execute();

	void publishEvents();
}

