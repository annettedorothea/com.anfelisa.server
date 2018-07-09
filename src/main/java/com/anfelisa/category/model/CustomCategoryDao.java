package com.anfelisa.category.model;

import java.util.List;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Update;

import com.anfelisa.category.data.CategoryUpdateData;
import com.anfelisa.category.models.CategoryItemMapper;
import com.anfelisa.category.models.CategoryMapper;
import com.anfelisa.category.models.ICategoryItemModel;
import com.anfelisa.category.models.ICategoryModel;

public class CustomCategoryDao {

	public List<ICategoryItemModel> selectAllChildren(Handle handle, String parentCategoryId, String userId) {
		return handle.createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, path, "
				+ "(select count(categoryid) from public.category child where child.parentcategoryid = c.categoryid) = 0 as empty, "
				+ "(select a.categoryid from useraccesstocategory a where a.categoryid = c.rootcategoryid and userid = :userid) is not null as editable, "
				+ "false as isRoot, "
				+ "(select boxid from box b where categoryid = c.rootcategoryid and userid = :userid) is not null as hasBox "
				+ "FROM public.category c WHERE parentcategoryid = :parentcategoryid order by categoryindex, categoryname")
				.bind("userid", userId).bind("parentcategoryid", parentCategoryId).map(new CategoryItemMapper()).list();
	}

	public List<ICategoryItemModel> selectAllRoot(Handle handle, String userId) {
		return handle.createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, path, "
				+ "(select count(categoryid) from public.category child where child.parentcategoryid = c.categoryid) = 0 as empty, "
				+ "(select a.categoryid from useraccesstocategory a where a.categoryid = c.rootcategoryid and userid = :userid) is not null as editable, "
				+ "true as isRoot, "
				+ "(select boxid from box b where categoryid = c.rootcategoryid and userid = :userid) is not null as hasBox "
				+ "FROM public.category c WHERE parentcategoryid is null order by categoryindex, categoryname")
				.bind("userid", userId).map(new CategoryItemMapper()).list();
	}

	public Integer selectMaxIndexInCategory(Handle handle, String parentCategoryId) {
		return handle
				.createQuery(
						"SELECT max(categoryindex) FROM public.category WHERE parentcategoryid = :parentcategoryid")
				.bind("parentcategoryid", parentCategoryId).mapTo((Integer.class)).first();
	}

	public Integer selectMaxIndexInRootCategory(Handle handle) {
		return handle.createQuery("SELECT max(categoryindex) FROM public.category WHERE parentcategoryid is null")
				.mapTo((Integer.class)).first();
	}

	public void update(Handle handle, CategoryUpdateData categoryModel) {
		Update statement = handle.createStatement(
				"UPDATE public.category SET categoryname = :categoryname, dictionarylookup = :dictionarylookup, givenlanguage = :givenlanguage, wantedlanguage = :wantedlanguage WHERE categoryid = :categoryid");
		statement.bind("categoryname", categoryModel.getCategoryName());
		statement.bind("categoryid", categoryModel.getCategoryId());
		statement.bind("dictionarylookup", categoryModel.getDictionaryLookup());
		statement.bind("givenlanguage", categoryModel.getGivenLanguage());
		statement.bind("wantedlanguage", categoryModel.getWantedLanguage());
		statement.execute();
	}

	public void shiftCategories(Handle handle, Integer categoryIndex, String parentCategoryId) {
		Update statement = handle.createStatement(
				"UPDATE public.category SET categoryindex = categoryindex-1 WHERE parentcategoryid = :parentcategoryid and categoryindex > :categoryindex");
		statement.bind("parentcategoryid", parentCategoryId);
		statement.bind("categoryindex", categoryIndex);
		statement.execute();
	}

	public void shiftRootCategories(Handle handle, Integer categoryIndex) {
		Update statement = handle.createStatement(
				"UPDATE public.category SET categoryindex = categoryindex-1 WHERE parentcategoryid is null and categoryindex > :categoryindex");
		statement.bind("categoryindex", categoryIndex);
		statement.execute();
	}

	public List<ICategoryModel> selectAllChildren(Handle handle, String parentCategoryId) {
		return handle.createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, path FROM public.category c WHERE parentcategoryid = :parentcategoryid order by categoryindex, categoryname")
				.bind("parentcategoryid", parentCategoryId).map(new CategoryMapper()).list();
	}

}
