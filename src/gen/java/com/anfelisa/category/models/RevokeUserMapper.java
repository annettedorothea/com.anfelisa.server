package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class RevokeUserMapper implements RowMapper<IRevokeUserModel> {
	
	public IRevokeUserModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new RevokeUserModel(
			r.getString("categoryId"),
			r.getString("rootCategoryId"),
			r.getString("revokedUserId"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
