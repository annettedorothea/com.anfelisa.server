package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CategoryTreeRootItemMapper implements RowMapper<ICategoryTreeRootItemModel> {
	
	public ICategoryTreeRootItemModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryTreeRootItemModel(
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getObject("categoryIndex") != null ? r.getInt("categoryIndex") : null,
			r.getBoolean("empty"),
			r.getBoolean("editable"),
			r.getBoolean("hasBox"),
			r.getBoolean("dictionaryLookup"),
			r.getString("givenLanguage"),
			r.getString("wantedLanguage"),
			null
		);
	}
}

/*       S.D.G.       */
