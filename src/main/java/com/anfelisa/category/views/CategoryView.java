package com.anfelisa.category.views;

import java.util.function.BiConsumer;

import org.skife.jdbi.v2.Handle;

import com.anfelisa.category.data.CategoryCreationData;
import com.anfelisa.category.data.CategoryDeleteData;
import com.anfelisa.category.data.CategoryMoveData;
import com.anfelisa.category.data.CategoryUpdateData;
import com.anfelisa.category.model.CustomCategoryDao;
import com.anfelisa.category.models.CategoryDao;

@SuppressWarnings("all")
public class CategoryView {

	private static CategoryDao categoryDao = new CategoryDao();
	
	private static CustomCategoryDao customCategoryDao = new CustomCategoryDao();

	public static BiConsumer<CategoryCreationData, Handle> insert = (dataContainer, handle) -> {
		categoryDao.insert(handle, dataContainer);
	};
	public static BiConsumer<CategoryDeleteData, Handle> delete = (dataContainer, handle) -> {
		categoryDao.deleteByCategoryId(handle, dataContainer.getCategoryId());
	};
	public static BiConsumer<CategoryUpdateData, Handle> update = (dataContainer, handle) -> {
		customCategoryDao.update(handle, dataContainer);
	};
	public static BiConsumer<CategoryMoveData, Handle> move = (dataContainer, handle) -> {
		customCategoryDao.move(handle, dataContainer);
	};

}

/* S.D.G. */
