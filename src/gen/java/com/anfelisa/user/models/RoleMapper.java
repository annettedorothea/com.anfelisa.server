package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class RoleMapper implements ResultSetMapper<IRoleModel> {
	
	public IRoleModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new RoleModel(
			r.getString("role")
		);
	}
}

/*       S.D.G.       */
