package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class ChangeUserRoleMapper implements RowMapper<IChangeUserRoleModel> {
	
	public IChangeUserRoleModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ChangeUserRoleModel(
			r.getString("editedUserId"),
			r.getString("newRole"),
			r.getString("userId"),
			r.getString("role")
		);
	}
}

/*       S.D.G.       */
