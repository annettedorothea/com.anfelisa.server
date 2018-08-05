package com.anfelisa.category.models;

import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.Query;
import org.skife.jdbi.v2.Update;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
@JsonIgnoreType
public class CategoryDao {
	
	public void insert(Handle handle, ICategoryModel categoryModel) {
		Update statement = handle.createStatement("INSERT INTO public.category (categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, path, publicrootcategory) VALUES (:categoryid, :categoryname, :categoryauthor, :categoryindex, :parentcategoryid, :rootcategoryid, :dictionarylookup, :givenlanguage, :wantedlanguage, :path, :publicrootcategory)");
		statement.bind("categoryid",  categoryModel.getCategoryId() );
		statement.bind("categoryname",  categoryModel.getCategoryName() );
		statement.bind("categoryauthor",  categoryModel.getCategoryAuthor() );
		statement.bind("categoryindex",  categoryModel.getCategoryIndex() );
		statement.bind("parentcategoryid",  categoryModel.getParentCategoryId() );
		statement.bind("rootcategoryid",  categoryModel.getRootCategoryId() );
		statement.bind("dictionarylookup",  categoryModel.getDictionaryLookup() );
		statement.bind("givenlanguage",  categoryModel.getGivenLanguage() );
		statement.bind("wantedlanguage",  categoryModel.getWantedLanguage() );
		statement.bind("path",  categoryModel.getPath() );
		statement.bind("publicrootcategory",  categoryModel.getPublicRootCategory() );
		statement.execute();
	}
	
	
	public void updateByCategoryId(Handle handle, ICategoryModel categoryModel) {
		Update statement = handle.createStatement("UPDATE public.category SET categoryid = :categoryid, categoryname = :categoryname, categoryauthor = :categoryauthor, categoryindex = :categoryindex, parentcategoryid = :parentcategoryid, rootcategoryid = :rootcategoryid, dictionarylookup = :dictionarylookup, givenlanguage = :givenlanguage, wantedlanguage = :wantedlanguage, path = :path, publicrootcategory = :publicrootcategory WHERE categoryid = :categoryid");
		statement.bind("categoryid",  categoryModel.getCategoryId() );
		statement.bind("categoryname",  categoryModel.getCategoryName() );
		statement.bind("categoryauthor",  categoryModel.getCategoryAuthor() );
		statement.bind("categoryindex",  categoryModel.getCategoryIndex() );
		statement.bind("parentcategoryid",  categoryModel.getParentCategoryId() );
		statement.bind("rootcategoryid",  categoryModel.getRootCategoryId() );
		statement.bind("dictionarylookup",  categoryModel.getDictionaryLookup() );
		statement.bind("givenlanguage",  categoryModel.getGivenLanguage() );
		statement.bind("wantedlanguage",  categoryModel.getWantedLanguage() );
		statement.bind("path",  categoryModel.getPath() );
		statement.bind("publicrootcategory",  categoryModel.getPublicRootCategory() );
		statement.bind("categoryid",  categoryModel.getCategoryId()  );
		statement.execute();
	}

	public void deleteByCategoryId(Handle handle, String categoryId) {
		Update statement = handle.createStatement("DELETE FROM public.category WHERE categoryid = :categoryid");
		statement.bind("categoryid", categoryId);
		statement.execute();
	}

	public ICategoryModel selectByCategoryId(Handle handle, String categoryId) {
		return handle.createQuery("SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, path, publicrootcategory FROM public.category WHERE categoryid = :categoryid")
			.bind("categoryid", categoryId)
			.map(new CategoryMapper())
			.first();
	}
	public void updateByCategoryName(Handle handle, ICategoryModel categoryModel) {
		Update statement = handle.createStatement("UPDATE public.category SET categoryid = :categoryid, categoryname = :categoryname, categoryauthor = :categoryauthor, categoryindex = :categoryindex, parentcategoryid = :parentcategoryid, rootcategoryid = :rootcategoryid, dictionarylookup = :dictionarylookup, givenlanguage = :givenlanguage, wantedlanguage = :wantedlanguage, path = :path, publicrootcategory = :publicrootcategory WHERE categoryname = :categoryname");
		statement.bind("categoryid",  categoryModel.getCategoryId() );
		statement.bind("categoryname",  categoryModel.getCategoryName() );
		statement.bind("categoryauthor",  categoryModel.getCategoryAuthor() );
		statement.bind("categoryindex",  categoryModel.getCategoryIndex() );
		statement.bind("parentcategoryid",  categoryModel.getParentCategoryId() );
		statement.bind("rootcategoryid",  categoryModel.getRootCategoryId() );
		statement.bind("dictionarylookup",  categoryModel.getDictionaryLookup() );
		statement.bind("givenlanguage",  categoryModel.getGivenLanguage() );
		statement.bind("wantedlanguage",  categoryModel.getWantedLanguage() );
		statement.bind("path",  categoryModel.getPath() );
		statement.bind("publicrootcategory",  categoryModel.getPublicRootCategory() );
		statement.bind("categoryname",  categoryModel.getCategoryName()  );
		statement.execute();
	}

	public void deleteByCategoryName(Handle handle, String categoryName) {
		Update statement = handle.createStatement("DELETE FROM public.category WHERE categoryname = :categoryname");
		statement.bind("categoryname", categoryName);
		statement.execute();
	}

	public ICategoryModel selectByCategoryName(Handle handle, String categoryName) {
		return handle.createQuery("SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, path, publicrootcategory FROM public.category WHERE categoryname = :categoryname")
			.bind("categoryname", categoryName)
			.map(new CategoryMapper())
			.first();
	}
	
	public List<ICategoryModel> selectAll(Handle handle) {
		return handle.createQuery("SELECT categoryid, categoryname, categoryauthor, categoryindex, parentcategoryid, rootcategoryid, dictionarylookup, givenlanguage, wantedlanguage, path, publicrootcategory FROM public.category")
			.map(new CategoryMapper())
			.list();
	}

	public void truncate(Handle handle) {
		Update statement = handle.createStatement("TRUNCATE public.category CASCADE");
		statement.execute();
	}

}

/*       S.D.G.       */
