package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class CategorySelectionItemMapper implements RowMapper<ICategorySelectionItemModel> {
	
	public ICategorySelectionItemModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategorySelectionItemModel(
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getObject("categoryIndex") != null ? r.getInt("categoryIndex") : null
		);
	}
}

/*       S.D.G.       */
