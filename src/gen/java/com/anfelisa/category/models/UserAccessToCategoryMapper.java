package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class UserAccessToCategoryMapper implements RowMapper<IUserAccessToCategoryModel> {
	
	public IUserAccessToCategoryModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserAccessToCategoryModel(
			r.getString("categoryId"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
