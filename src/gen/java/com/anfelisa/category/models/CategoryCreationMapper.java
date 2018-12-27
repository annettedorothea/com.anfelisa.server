package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class CategoryCreationMapper implements RowMapper<ICategoryCreationModel> {
	
	public ICategoryCreationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryCreationModel(
			r.getString("username"),
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
			r.getBoolean("publicRootCategory"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
