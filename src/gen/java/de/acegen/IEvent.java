/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package de.acegen;

public interface IEvent<T extends IDataContainer> {

	String getEventName();
	
	void publish(T data, PersistenceHandle handle, PersistenceHandle timelineHandle);

	void publishAfterCommit(T data, PersistenceHandle handle, PersistenceHandle timelineHandle);
	
	void notifyListeners(T data, PersistenceHandle handle);
	
	void notifyAfterCommitListeners(T data, PersistenceHandle handle);
	
	
}



/******* S.D.G. *******/



