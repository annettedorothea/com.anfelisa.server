/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package de.acegen;

public interface ICommand<T extends AbstractModel> {

	String getCommandName();

	Data<T> execute(Data<T> data, PersistenceHandle readonlyHandle, PersistenceHandle timelineHandle);

	void addEventsToTimeline(Data<T> data, PersistenceHandle timelineHandle);

	void publishEvents(Data<T> data, PersistenceHandle handle, PersistenceHandle timelineHandle);

}




/******* S.D.G. *******/



