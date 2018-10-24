package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class ScheduleCategoryMapper implements RowMapper<IScheduleCategoryModel> {
	
	public IScheduleCategoryModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScheduleCategoryModel(
			r.getString("userId"),
			r.getString("boxId"),
			r.getString("categoryId"),
			null
		);
	}
}

/*       S.D.G.       */
