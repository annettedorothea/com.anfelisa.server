/********************************************************************************
 * generated by de.acegen 0.9.13
 ********************************************************************************/




package de.acegen;

public interface IEvent {

	String getEventName();
	
	IDataContainer getEventData();
	
	void publish(PersistenceHandle handle, PersistenceHandle timelineHandle);
	
	void notifyListeners(PersistenceHandle handle);

}



/******* S.D.G. *******/



