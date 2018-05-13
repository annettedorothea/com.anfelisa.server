package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class CategoryUpdateMapper implements ResultSetMapper<ICategoryUpdateModel> {
	
	public ICategoryUpdateModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryUpdateModel(
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getInt("categoryIndex"),
			r.getBoolean("dictionaryLookup"),
			r.getString("givenLanguage"),
			r.getString("wantedLanguage")
		);
	}
}

/*       S.D.G.       */
