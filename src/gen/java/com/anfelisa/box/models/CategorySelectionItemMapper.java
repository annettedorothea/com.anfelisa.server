package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class CategorySelectionItemMapper implements ResultSetMapper<ICategorySelectionItemModel> {
	
	public ICategorySelectionItemModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CategorySelectionItemModel(
			r.getString("categoryId"),
			r.getString("categoryName"),
			r.getObject("categoryIndex") != null ? r.getInt("categoryIndex") : null
		);
	}
}

/*       S.D.G.       */
