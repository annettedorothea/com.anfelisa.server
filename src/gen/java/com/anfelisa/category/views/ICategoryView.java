package com.anfelisa.category.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDataContainer;
import com.anfelisa.category.data.CategoryCreationData;
import com.anfelisa.category.data.CategoryDeleteData;
import com.anfelisa.category.data.CategoryDeleteData;
import com.anfelisa.category.data.CategoryUpdateData;
import com.anfelisa.category.data.CategoryMoveData;

@SuppressWarnings("all")
public interface ICategoryView {

	void insert(CategoryCreationData data, Handle handle);
	void delete(CategoryDeleteData data, Handle handle);
	void deleteRoot(CategoryDeleteData data, Handle handle);
	void update(CategoryUpdateData data, Handle handle);
	void moveCategory(CategoryMoveData data, Handle handle);

}

/*                    S.D.G.                    */
