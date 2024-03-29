package com.anfelisa.category.models;

import java.util.List;
import java.util.Optional;

import org.jdbi.v3.core.statement.Update;

import com.anfelisa.box.models.BoxUpdateModel;

import de.acegen.PersistenceHandle;

public class CategoryDao extends AbstractCategoryDao {

	public CategoryTreeItemModel selectRoot(PersistenceHandle handle, String rootCategoryId, String userId, Boolean reverse) {
		Optional<CategoryTreeItemModel> optional = handle.getHandle().createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, "
						+ "(select count(categoryid) from public.category child where child.parentcategoryid = c.categoryid) = 0 as empty, "
						+ "true as isRoot,"
						+ "null as nonScheduledCount, "
						+ ":notreverse AND (select editable from useraccesstocategory where userid = :userid and categoryid = :categoryid) as editable "
						+ "FROM public.category c WHERE categoryid = :categoryid")
				.bind("categoryid", rootCategoryId)
				.bind("userid", userId)
				.bind("notreverse", !reverse)
				.map(new CategoryTreeItemMapper())
				.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public List<CategoryTreeItemModel> selectAllChildrenForTree(PersistenceHandle handle, String parentCategoryId, String userId, Boolean reverse) {
		return handle.getHandle().createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, "
						+ "(select count(categoryid) from public.category child where child.parentcategoryid = c.categoryid) = 0 as empty, "
						+ "false as isRoot,"
						+ "null as nonScheduledCount, "
						+ ":notreverse AND (select editable from useraccesstocategory where userid = :userid and categoryid = c.rootcategoryid) as editable "
						+ "FROM public.category c WHERE parentcategoryid = :parentcategoryid order by categoryindex, categoryname")
				.bind("parentcategoryid", parentCategoryId)
				.bind("userid", userId)
				.bind("notreverse", !reverse)
				.map(new CategoryTreeItemMapper())
				.list();
	}
	
	public List<CategoryModel> selectAllUsersRoot(PersistenceHandle handle, String userId) {
		return handle.getHandle().createQuery("SELECT * FROM "
				+ "( SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, "
				+ "(select a.editable from useraccesstocategory a where a.categoryid = c.rootcategoryid and a.userid = :userid) "
				+ "FROM public.category c) as categoryitem WHERE parentcategoryid is null and editable is not null order by categoryindex, categoryname")
				.bind("userid", userId).map(new CategoryMapper()).list();
	}

	public Integer selectMaxIndexInCategory(PersistenceHandle handle, String parentCategoryId) {
		Optional<Integer> optional = handle.getHandle()
				.createQuery(
						"SELECT max(categoryindex) FROM public.category WHERE parentcategoryid = :parentcategoryid")
				.bind("parentcategoryid", parentCategoryId).mapTo((Integer.class)).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public Integer selectMaxIndexInRootCategory(PersistenceHandle handle) {
		Optional<Integer> optional = handle.getHandle()
				.createQuery("SELECT max(categoryindex) FROM public.category WHERE parentcategoryid is null")
				.mapTo((Integer.class)).findFirst();
		return optional.isPresent() ? optional.get() : null;
	}

	public void updateCategoryName(PersistenceHandle handle, CategoryUpdateModel categoryModel) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.category SET categoryname = :categoryname WHERE categoryid = :categoryid");
		statement.bind("categoryname", categoryModel.getCategoryName());
		statement.bind("categoryid", categoryModel.getCategoryId());
		statement.execute();
	}

	public void updateIndex(PersistenceHandle handle, CategoryModel categoryModel) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.category SET categoryindex = :categoryindex WHERE categoryid = :categoryid");
		statement.bind("categoryindex", categoryModel.getCategoryIndex());
		statement.bind("categoryid", categoryModel.getCategoryId());
		statement.execute();
	}

	public void shiftCategories(PersistenceHandle handle, Integer categoryIndex, String parentCategoryId) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.category SET categoryindex = categoryindex-1 WHERE parentcategoryid = :parentcategoryid and categoryindex > :categoryindex");
		statement.bind("parentcategoryid", parentCategoryId);
		statement.bind("categoryindex", categoryIndex);
		statement.execute();
	}

	public List<CategoryModel> selectAllChildren(PersistenceHandle handle, String parentCategoryId) {
		return handle.getHandle().createQuery(
				"SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage FROM public.category c WHERE parentcategoryid = :parentcategoryid order by categoryindex, categoryname")
				.bind("parentcategoryid", parentCategoryId).map(new CategoryMapper()).list();
	}

	public void update(PersistenceHandle handle, BoxUpdateModel categoryModel) {
		Update statement = handle.getHandle().createUpdate(
				"UPDATE public.category SET categoryname = :categoryname, dictionarylookup = :dictionarylookup, givenlanguage = :givenlanguage, wantedlanguage = :wantedlanguage WHERE categoryid = :categoryid");
		statement.bind("categoryname", categoryModel.getCategoryName());
		statement.bind("categoryid", categoryModel.getCategoryId());
		statement.bind("dictionarylookup", categoryModel.getDictionaryLookup());
		statement.bind("givenlanguage", categoryModel.getGivenLanguage());
		statement.bind("wantedlanguage", categoryModel.getWantedLanguage());
		statement.execute();
	}

	public void deleteByRootCategoryId(PersistenceHandle handle, String rootCategoryId) {
		Update statement = handle.getHandle().createUpdate("DELETE FROM public.category WHERE rootcategoryid = :rootcategoryid");
		statement.bind("rootcategoryid", rootCategoryId);
		statement.execute();
	}

	public List<String> selectAllByRootCategoryId(PersistenceHandle handle, String rootCategoryId) {
		return handle.getHandle().createQuery(
				"SELECT categoryid FROM public.category WHERE rootcategoryid = :rootcategoryid")
				.bind("rootcategoryid", rootCategoryId).mapTo(String.class).list();
	}

	public List<String> search(PersistenceHandle handle, String searchString, String categoryId) {
		String search = searchString + "%";
		return handle.getHandle().createQuery("SELECT username FROM public.user u where username like :search and "
				+ "(select userid from public.useraccesstocategory uac where categoryid = :categoryid and uac.userid = u.userid ) is null order by username limit 10")
				.bind("search", search)
				.bind("categoryid", categoryId)
				.mapTo(String.class).list();
	}
	
	public com.anfelisa.category.models.CategoryModel selectByParentCategoryIdAndIndex(PersistenceHandle handle, String parentCategoryId, int index) {
		Optional<com.anfelisa.category.models.CategoryModel> optional = handle.getHandle().createQuery(""
				+ "SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage "
				+ "FROM \"category\" WHERE parentcategoryid = :parentcategoryid and categoryindex = :index")
			.bind("parentcategoryid", parentCategoryId)
			.bind("index", index)
			.map(new CategoryMapper())
			.findFirst();
		return optional.isPresent() ? optional.get() : null;
	}
	

}

/* S.D.G. */
