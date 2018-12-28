package com.anfelisa.category.views;

import java.util.function.BiConsumer;

import org.jdbi.v3.core.Handle;

import com.anfelisa.ace.IDaoProvider;
import com.anfelisa.category.data.CategoryCreationData;
import com.anfelisa.category.data.CategoryDeleteData;
import com.anfelisa.category.data.CategoryUpdateData;

@SuppressWarnings("all")
public class CategoryView {

	private IDaoProvider daoProvider;

	public CategoryView(IDaoProvider daoProvider) {
		super();
		this.daoProvider = daoProvider;
	}

	public BiConsumer<CategoryCreationData, Handle> insert = (dataContainer, handle) -> {
		daoProvider.getCategoryDao().insert(handle, dataContainer);
	};
	public BiConsumer<CategoryDeleteData, Handle> delete = (dataContainer, handle) -> {
		daoProvider.getCardDao().deleteByCategoryId(handle, dataContainer.getCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, dataContainer.getCategoryId());
		daoProvider.getCategoryDao().shiftCategories(handle, dataContainer.getCategoryIndex(), dataContainer.getParentCategoryId());
	};
	public BiConsumer<CategoryDeleteData, Handle> deleteRoot = (dataContainer, handle) -> {
		daoProvider.getCardDao().deleteByCategoryId(handle, dataContainer.getCategoryId());
		daoProvider.getCategoryDao().deleteByCategoryId(handle, dataContainer.getCategoryId());
		daoProvider.getCategoryDao().shiftRootCategories(handle, dataContainer.getCategoryIndex());
	};
	public BiConsumer<CategoryUpdateData, Handle> update = (dataContainer, handle) -> {
		daoProvider.getCategoryDao().update(handle, dataContainer);
	};

}

/* S.D.G. */
