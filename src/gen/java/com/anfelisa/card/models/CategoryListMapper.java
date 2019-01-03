package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CategoryListMapper implements RowMapper<ICategoryListModel> {
	
	public ICategoryListModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryListModel(
			null,
			r.getString("categoryId")
		);
	}
}

/*       S.D.G.       */
