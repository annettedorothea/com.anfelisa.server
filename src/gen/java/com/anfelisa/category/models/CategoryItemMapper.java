package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class CategoryItemMapper implements RowMapper<ICategoryItemModel> {
	
	public ICategoryItemModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryItemModel(
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getString("categoryAuthor"),
			r.getObject("categoryIndex") != null ? r.getInt("categoryIndex") : null,
			r.getString("parentCategoryId"),
			r.getString("rootCategoryId"),
			r.getBoolean("dictionaryLookup"),
			r.getString("givenLanguage"),
			r.getString("wantedLanguage"),
			r.getString("path"),
			r.getBoolean("empty"),
			r.getBoolean("editable"),
			r.getBoolean("hasBox"),
			r.getBoolean("isRoot"),
			r.getBoolean("publicRootCategory")
		);
	}
}

/*       S.D.G.       */
