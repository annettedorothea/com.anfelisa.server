package com.anfelisa.category.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.ace.DaoProvider;
import com.anfelisa.category.data.CategoryCreationData;
import com.anfelisa.category.data.CategoryDeleteData;
import com.anfelisa.category.data.CategoryUpdateData;

@SuppressWarnings("all")
public class CategoryView {

	private DaoProvider daoProvider;

	public CategoryView(DaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<CategoryCreationData, Handle> insert = (dataContainer, handle) -> {
		daoProvider.getCategoryDao().insert(handle, dataContainer);
	};
	public BiConsumer<CategoryDeleteData, Handle> delete = (dataContainer, handle) -> {
		daoProvider.getCustomCardDao().deleteByCategoryId(handle, dataContainer.getCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, dataContainer.getCategoryId());
		daoProvider.getCustomCategoryDao().shiftCategories(handle, dataContainer.getCategoryIndex(), dataContainer.getParentCategoryId());
	};
	public BiConsumer<CategoryDeleteData, Handle> deleteRoot = (dataContainer, handle) -> {
		daoProvider.getCustomCardDao().deleteByCategoryId(handle, dataContainer.getCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, dataContainer.getCategoryId());
		daoProvider.getCustomCategoryDao().shiftRootCategories(handle, dataContainer.getCategoryIndex());
	};
	public BiConsumer<CategoryUpdateData, Handle> update = (dataContainer, handle) -> {
		daoProvider.getCustomCategoryDao().update(handle, dataContainer);
	};

}

/* S.D.G. */
