package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class CategoryListMapper implements RowMapper<ICategoryListModel> {
	
	public ICategoryListModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryListModel(
			r.getString("parentCategoryId"),
			r.getString("grandParentCategoryId"),
			r.getString("parentCategoryName"),
			r.getBoolean("parentDictionaryLookup"),
			r.getBoolean("rootDictionaryLookup"),
			r.getString("parentGivenLanguage"),
			r.getString("parentWantedLanguage"),
			null,
			null,
			r.getBoolean("hasBox"),
			r.getString("userId"),
			r.getBoolean("parentEditable"),
			null
		);
	}
}

/*       S.D.G.       */
