package com.anfelisa.category.model;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.anfelisa.category.data.CategoryUpdateData;
import com.anfelisa.category.models.CategoryMapper;
import com.anfelisa.category.models.ICategoryModel;

public class CustomCategoryDao {

	public List<ICategoryModel> selectAllChildren(Handle handle, String parentCategoryId) {
		return handle.createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid FROM public.category WHERE parentcategoryid = :parentcategoryid order by categoryindex, categoryname")
				.bind("parentcategoryid", parentCategoryId)
				.map(new CategoryMapper()).list();
	}
	
	public List<ICategoryModel> selectAllRoot(Handle handle) {
		return handle.createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid FROM public.category WHERE parentcategoryid is null order by categoryindex, categoryname")
				.map(new CategoryMapper()).list();
	}
	
	public void update(Handle handle, CategoryUpdateData categoryModel) {
		Update statement = handle.createStatement("UPDATE public.category SET categoryname = :categoryname, categoryindex = :categoryindex WHERE categoryid = :categoryid");
		statement.bind("categoryname",  categoryModel.getCategoryName() );
		statement.bind("categoryindex",  categoryModel.getCategoryIndex() );
		statement.bind("categoryid",  categoryModel.getCategoryId()  );
		statement.execute();
	}

}
