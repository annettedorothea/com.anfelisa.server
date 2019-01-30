package com.anfelisa.category.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.category.data.ICategoryCreationData;
import com.anfelisa.category.data.ICategoryDeleteData;
import com.anfelisa.category.data.ICategoryDeleteData;
import com.anfelisa.category.data.ICategoryUpdateData;
import com.anfelisa.category.data.ICategoryMoveData;

@SuppressWarnings("all")
public interface ICategoryView {

	void insert(ICategoryCreationData data, Handle handle);
	void delete(ICategoryDeleteData data, Handle handle);
	void deleteRoot(ICategoryDeleteData data, Handle handle);
	void update(ICategoryUpdateData data, Handle handle);
	void moveCategory(ICategoryMoveData data, Handle handle);

}

/*                    S.D.G.                    */
