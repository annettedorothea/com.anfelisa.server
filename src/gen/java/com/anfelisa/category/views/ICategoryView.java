/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.category.views;


import de.acegen.IDataContainer;
import de.acegen.PersistenceHandle;
import com.anfelisa.category.data.ICategoryCreationData;
import com.anfelisa.category.data.ICategoryDeleteData;
import com.anfelisa.category.data.ICategoryUpdateData;
import com.anfelisa.category.data.ICategoryMoveData;
import com.anfelisa.category.data.ICategoryChangeOrderData;

@SuppressWarnings("all")
public interface ICategoryView {

	void insert(ICategoryCreationData data, PersistenceHandle handle);
	void delete(ICategoryDeleteData data, PersistenceHandle handle);
	void update(ICategoryUpdateData data, PersistenceHandle handle);
	void moveCategory(ICategoryMoveData data, PersistenceHandle handle);
	void changeOrder(ICategoryChangeOrderData data, PersistenceHandle handle);

}




/******* S.D.G. *******/



