package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class CategoryUpdateMapper implements RowMapper<ICategoryUpdateModel> {
	
	public ICategoryUpdateModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryUpdateModel(
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getBoolean("dictionaryLookup"),
			r.getString("givenLanguage"),
			r.getString("wantedLanguage"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
