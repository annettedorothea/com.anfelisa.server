package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class CategoryMoveMapper implements RowMapper<ICategoryMoveModel> {
	
	public ICategoryMoveModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CategoryMoveModel(
			r.getString("movedCategoryId"),
			r.getString("targetCategoryId"),
			null,
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
