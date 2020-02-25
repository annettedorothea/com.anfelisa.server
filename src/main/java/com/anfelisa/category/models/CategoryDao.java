package com.anfelisa.category.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import com.anfelisa.box.data.IBoxUpdateData;
import com.anfelisa.category.data.ICategoryUpdateData;

public class CategoryDao extends AbstractCategoryDao {

	public ICategoryTreeItemModel selectRoot(Handle handle, String rootCategoryId, String userId) {
		Optional<ICategoryTreeItemModel> optional = handle.createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, "
						+ "(select count(categoryid) from public.category child where child.parentcategoryid = c.categoryid) = 0 as empty, "
						+ "(select a.editable from useraccesstocategory a where a.categoryid = :categoryid and userid = :userid), "
						+ "true as isRoot "
						+ "FROM public.category c WHERE categoryid = :categoryid")
				.bind("userid", userId).bind("categoryid", rootCategoryId).map(new CategoryTreeItemMapper())
				.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public List<ICategoryTreeItemModel> selectAllChildren(Handle handle, String parentCategoryId, String userId) {
		return handle.createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, "
						+ "(select count(categoryid) from public.category child where child.parentcategoryid = c.categoryid) = 0 as empty, "
						+ "(select a.editable from useraccesstocategory a where a.categoryid = c.rootcategoryid and userid = :userid), "
						+ "false as isRoot "
						+ "FROM public.category c WHERE parentcategoryid = :parentcategoryid order by categoryindex, categoryname")
				.bind("userid", userId).bind("parentcategoryid", parentCategoryId).map(new CategoryTreeItemMapper())
				.list();
	}
	
	public List<ICategoryModel> selectAllUsersRoot(Handle handle, String userId) {
		return handle.createQuery("SELECT * FROM "
				+ "( SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, "
				+ "(select a.editable from useraccesstocategory a where a.categoryid = c.rootcategoryid and a.userid = :userid) "
				+ "FROM public.category c) as categoryitem WHERE parentcategoryid is null and editable is not null order by categoryindex, categoryname")
				.bind("userid", userId).map(new CategoryMapper()).list();
	}

	public Integer selectMaxIndexInCategory(Handle handle, String parentCategoryId) {
		Optional<Integer> optional = handle
				.createQuery(
						"SELECT max(categoryindex) FROM public.category WHERE parentcategoryid = :parentcategoryid")
				.bind("parentcategoryid", parentCategoryId).mapTo((Integer.class)).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public Integer selectMaxIndexInRootCategory(Handle handle) {
		Optional<Integer> optional = handle
				.createQuery("SELECT max(categoryindex) FROM public.category WHERE parentcategoryid is null")
				.mapTo((Integer.class)).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void update(Handle handle, ICategoryUpdateData categoryModel) {
		Update statement = handle.createUpdate(
				"UPDATE public.category SET categoryname = :categoryname, dictionarylookup = :dictionarylookup, givenlanguage = :givenlanguage, wantedlanguage = :wantedlanguage WHERE categoryid = :categoryid");
		statement.bind("categoryname", categoryModel.getCategoryName());
		statement.bind("categoryid", categoryModel.getCategoryId());
		statement.bind("dictionarylookup", categoryModel.getDictionaryLookup());
		statement.bind("givenlanguage", categoryModel.getGivenLanguage());
		statement.bind("wantedlanguage", categoryModel.getWantedLanguage());
		statement.execute();
	}

	public void updateIndex(Handle handle, ICategoryModel categoryModel) {
		Update statement = handle.createUpdate(
				"UPDATE public.category SET categoryindex = :categoryindex WHERE categoryid = :categoryid");
		statement.bind("categoryindex", categoryModel.getCategoryIndex());
		statement.bind("categoryid", categoryModel.getCategoryId());
		statement.execute();
	}

	public void shiftCategories(Handle handle, Integer categoryIndex, String parentCategoryId) {
		Update statement = handle.createUpdate(
				"UPDATE public.category SET categoryindex = categoryindex-1 WHERE parentcategoryid = :parentcategoryid and categoryindex > :categoryindex");
		statement.bind("parentcategoryid", parentCategoryId);
		statement.bind("categoryindex", categoryIndex);
		statement.execute();
	}

	public void shiftRootCategories(Handle handle, Integer categoryIndex) {
		Update statement = handle.createUpdate(
				"UPDATE public.category SET categoryindex = categoryindex-1 WHERE parentcategoryid is null and categoryindex > :categoryindex");
		statement.bind("categoryindex", categoryIndex);
		statement.execute();
	}

	public List<ICategoryModel> selectAllChildren(Handle handle, String parentCategoryId) {
		return handle.createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage FROM public.category c WHERE parentcategoryid = :parentcategoryid order by categoryindex, categoryname")
				.bind("parentcategoryid", parentCategoryId).map(new CategoryMapper()).list();
	}

	public void update(Handle handle, IBoxUpdateData categoryModel) {
		Update statement = handle.createUpdate(
				"UPDATE public.category SET categoryname = :categoryname, dictionarylookup = :dictionarylookup, givenlanguage = :givenlanguage, wantedlanguage = :wantedlanguage WHERE categoryid = :categoryid");
		statement.bind("categoryname", categoryModel.getCategoryName());
		statement.bind("categoryid", categoryModel.getCategoryId());
		statement.bind("dictionarylookup", categoryModel.getDictionaryLookup());
		statement.bind("givenlanguage", categoryModel.getGivenLanguage());
		statement.bind("wantedlanguage", categoryModel.getWantedLanguage());
		statement.execute();
	}

	public void deleteByRootCategoryId(Handle handle, String rootCategoryId) {
		Update statement = handle.createUpdate("DELETE FROM public.category WHERE rootcategoryid = :rootcategoryid");
		statement.bind("rootcategoryid", rootCategoryId);
		statement.execute();
	}

	public List<String> selectAllByRootCategoryId(Handle handle, String rootCategoryId) {
		return handle.createQuery(
				"SELECT categoryid FROM public.category WHERE rootcategoryid = :rootcategoryid")
				.bind("rootcategoryid", rootCategoryId).mapTo(String.class).list();
	}

}

/* S.D.G. */
