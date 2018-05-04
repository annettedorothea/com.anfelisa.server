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
		daoProvider.categoryDao.insert(handle, dataContainer);
	};
	public BiConsumer<CategoryDeleteData, Handle> delete = (dataContainer, handle) -> {
		daoProvider.categoryDao.deleteByCategoryId(handle, dataContainer.getCategoryId());
	};
	public BiConsumer<CategoryUpdateData, Handle> update = (dataContainer, handle) -> {
		daoProvider.customCategoryDao.update(handle, dataContainer);
	};

}

/* S.D.G. */
