package com.anfelisa.category.views;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.category.data.ICategoryChangeOrderData;
import com.anfelisa.category.data.ICategoryCreationData;
import com.anfelisa.category.data.ICategoryDeleteData;
import com.anfelisa.category.data.ICategoryMoveData;
import com.anfelisa.category.data.ICategoryUpdateData;
import com.anfelisa.category.models.ICategoryModel;

public class CategoryView implements ICategoryView {

	private IDaoProvider daoProvider;

	public CategoryView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	@Override
	public void insert(ICategoryCreationData data, Handle handle) {
		daoProvider.getCategoryDao().insert(handle, data);
	}

	@Override
	public void delete(ICategoryDeleteData data, Handle handle) {
		daoProvider.getCardDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().shiftCategories(handle, data.getCategoryIndex(), data.getParentCategoryId());
	}

	@Override
	public void deleteRoot(ICategoryDeleteData data, Handle handle) {
		daoProvider.getCardDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().shiftRootCategories(handle, data.getCategoryIndex());
	}

	@Override
	public void update(ICategoryUpdateData data, Handle handle) {
		daoProvider.getCategoryDao().update(handle, data);
	}

	@Override
	public void moveCategory(ICategoryMoveData data, Handle handle) {
		daoProvider.getCategoryDao().updateByCategoryId(handle, data.getMovedCategory());
		daoProvider.getCategoryDao().shiftCategories(handle, data.getCategoryIndexWhereRemoved(), data.getParentCategoryIdWhereRemoved());
	}

	@Override
	public void changeOrder(ICategoryChangeOrderData data, Handle handle) {
		for (ICategoryModel category : data.getUpdatedIndices()) {
			daoProvider.getCategoryDao().updateIndex(handle, category);
		}
	}

}

/* S.D.G. */
