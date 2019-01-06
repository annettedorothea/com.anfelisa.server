package com.anfelisa.category.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.category.data.CategoryCreationData;
import com.anfelisa.category.data.CategoryDeleteData;
import com.anfelisa.category.data.CategoryMoveData;
import com.anfelisa.category.data.CategoryUpdateData;

public class CategoryView implements ICategoryView {

	private IDaoProvider daoProvider;

	public CategoryView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public void insert(CategoryCreationData data, Handle handle) {
		daoProvider.getCategoryDao().insert(handle, data);
	}

	public void delete(CategoryDeleteData data, Handle handle) {
		daoProvider.getCardDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().shiftCategories(handle, data.getCategoryIndex(), data.getParentCategoryId());
	}

	public void deleteRoot(CategoryDeleteData data, Handle handle) {
		daoProvider.getCardDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().shiftRootCategories(handle, data.getCategoryIndex());
	}

	public void update(CategoryUpdateData data, Handle handle) {
		daoProvider.getCategoryDao().update(handle, data);
	}

	@Override
	public void moveCategory(CategoryMoveData data, Handle handle) {
		daoProvider.getCategoryDao().updateByCategoryId(handle, data.getMovedCategory());
		daoProvider.getCategoryDao().shiftCategories(handle, data.getCategoryIndexWhereRemoved(), data.getParentCategoryIdWhereRemoved());
	}

}

/* S.D.G. */
