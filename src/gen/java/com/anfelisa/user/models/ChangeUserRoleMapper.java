package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class ChangeUserRoleMapper implements RowMapper<IChangeUserRoleModel> {
	
	public IChangeUserRoleModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ChangeUserRoleModel(
			r.getString("userId"),
			r.getString("role"),
			r.getString("authUserId"),
			r.getString("authRole")
		);
	}
}

/*       S.D.G.       */
