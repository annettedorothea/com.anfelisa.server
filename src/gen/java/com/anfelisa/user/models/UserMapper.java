package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class UserMapper implements RowMapper<IUserModel> {
	
	public IUserModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserModel(
			r.getString("userId"),
			r.getString("username"),
			r.getString("password"),
			r.getString("email"),
			r.getString("role"),
			r.getBoolean("emailConfirmed")
		);
	}
}

/*       S.D.G.       */
