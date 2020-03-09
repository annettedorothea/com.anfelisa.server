package com.anfelisa.category.views;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.ace.PersistenceHandle;
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
	public void insert(ICategoryCreationData data, PersistenceHandle handle) {
		daoProvider.getCategoryDao().insert(handle, data);
	}

	@Override
	public void delete(ICategoryDeleteData data, PersistenceHandle handle) {
		daoProvider.getCardDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().shiftCategories(handle, data.getCategoryIndex(), data.getParentCategoryId());
	}

	@Override
	public void deleteRoot(ICategoryDeleteData data, PersistenceHandle handle) {
		daoProvider.getCardDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, data.getCategoryId());
		daoProvider.getCategoryDao().shiftRootCategories(handle, data.getCategoryIndex());
	}

	@Override
	public void update(ICategoryUpdateData data, PersistenceHandle handle) {
		daoProvider.getCategoryDao().update(handle, data);
	}

	@Override
	public void moveCategory(ICategoryMoveData data, PersistenceHandle handle) {
		daoProvider.getCategoryDao().updateByCategoryId(handle, data.getMovedCategory());
		daoProvider.getCategoryDao().shiftCategories(handle, data.getCategoryIndexWhereRemoved(), data.getParentCategoryIdWhereRemoved());
	}

	@Override
	public void changeOrder(ICategoryChangeOrderData data, PersistenceHandle handle) {
		for (ICategoryModel category : data.getUpdatedIndices()) {
			daoProvider.getCategoryDao().updateIndex(handle, category);
		}
	}

}

/* S.D.G. */
