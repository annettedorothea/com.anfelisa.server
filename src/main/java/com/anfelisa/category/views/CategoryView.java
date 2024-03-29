package com.anfelisa.category.views;

import com.anfelisa.category.models.CategoryCreationModel;
import com.anfelisa.category.models.CategoryDeleteModel;
import com.anfelisa.category.models.CategoryMoveModel;
import com.anfelisa.category.models.CategoryUpdateModel;
import com.anfelisa.category.models.ToggleCategoryOrderModel;

import de.acegen.Data;
import de.acegen.IDaoProvider;
import de.acegen.PersistenceHandle;

public class CategoryView implements ICategoryView {

	private IDaoProvider daoProvider;

	public CategoryView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	@Override
	public void insert(Data<CategoryCreationModel> data, PersistenceHandle handle) {
		daoProvider.getCategoryDao().insert(handle, data.getModel().mapToCategoryModel());
	}

	@Override
	public void delete(Data<CategoryDeleteModel> data, PersistenceHandle handle) {
		daoProvider.getCardDao().deleteByCategoryId(handle, data.getModel().getCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, data.getModel().getCategoryId());
		daoProvider.getCategoryDao().shiftCategories(handle, data.getModel().getCategoryIndex(), data.getModel().getParentCategoryId());
	}

	@Override
	public void update(Data<CategoryUpdateModel> data, PersistenceHandle handle) {
		daoProvider.getCategoryDao().updateCategoryName(handle, data.getModel());
	}

	@Override
	public void moveCategory(Data<CategoryMoveModel> data, PersistenceHandle handle) {
		daoProvider.getCategoryDao().updateByCategoryId(handle, data.getModel().getMovedCategory());
		daoProvider.getCategoryDao().shiftCategories(handle, data.getModel().getCategoryIndexWhereRemoved(), data.getModel().getParentCategoryIdWhereRemoved());
	}

	@Override
	public void toggleOrder(Data<ToggleCategoryOrderModel> data, PersistenceHandle handle) {
		daoProvider.getCategoryDao().updateIndex(handle, data.getModel().getUpdatedCategory1());
		daoProvider.getCategoryDao().updateIndex(handle, data.getModel().getUpdatedCategory2());
	}

}

/* S.D.G. */
