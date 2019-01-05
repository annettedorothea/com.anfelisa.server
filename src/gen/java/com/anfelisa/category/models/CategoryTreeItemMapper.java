package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CategoryTreeItemMapper implements RowMapper<ICategoryTreeItemModel> {
	
	public ICategoryTreeItemModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryTreeItemModel(
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getObject("categoryIndex") != null ? r.getInt("categoryIndex") : null,
			r.getBoolean("empty"),
			r.getBoolean("editable"),
			r.getBoolean("hasBox"),
			r.getString("parentCategoryId"),
			r.getBoolean("dictionaryLookup"),
			r.getString("givenLanguage"),
			r.getString("wantedLanguage"),
			r.getString("rootCategoryId"),
			null
		);
	}
}

/*       S.D.G.       */
