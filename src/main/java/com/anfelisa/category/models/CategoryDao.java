package com.anfelisa.category.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Update;

import com.anfelisa.category.data.ICategoryUpdateData;

public class CategoryDao extends AbstractCategoryDao {
	public List<ICategoryTreeItemModel> selectAllChildren(Handle handle, String parentCategoryId, String userId) {
		return handle.createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, "
						+ "(select count(categoryid) from public.category child where child.parentcategoryid = c.categoryid) = 0 as empty, "
						+ "(select a.editable from useraccesstocategory a where a.categoryid = c.rootcategoryid and userid = :userid), "
						+ "false as isRoot, "
						+ "(select boxid from box b where categoryid = c.rootcategoryid and userid = :userid) is not null as hasBox "
						+ "FROM public.category c WHERE parentcategoryid = :parentcategoryid order by categoryindex, categoryname")
				.bind("userid", userId).bind("parentcategoryid", parentCategoryId).map(new CategoryTreeItemMapper()).list();
	}

	public List<ICategoryTreeRootItemModel> selectAllRoot(Handle handle, String userId) {
		return handle.createQuery("SELECT * FROM "
				+ "( SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, "
				+ "(select count(categoryid) from public.category child where child.parentcategoryid = c.categoryid) = 0 as empty, "
				+ "(select a.editable from useraccesstocategory a where a.categoryid = c.rootcategoryid and a.userid = :userid), "
				+ "true as isRoot, "
				+ "(select boxid from box b where categoryid = c.rootcategoryid and userid = :userid) is not null as hasBox "
				+ "FROM public.category c) as categoryitem WHERE parentcategoryid is null and editable is not null order by categoryindex, categoryname")
				.bind("userid", userId).map(new CategoryTreeRootItemMapper()).list();
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

}

/*       S.D.G.       */
