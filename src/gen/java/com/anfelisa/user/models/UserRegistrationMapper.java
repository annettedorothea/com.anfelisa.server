package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class UserRegistrationMapper implements RowMapper<IUserRegistrationModel> {
	
	public IUserRegistrationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserRegistrationModel(
			r.getString("language"),
			r.getString("userId"),
			r.getString("username"),
			r.getString("password"),
			r.getString("email"),
			r.getString("role"),
			r.getBoolean("emailConfirmed"),
			r.getString("token")
		);
	}
}

/*       S.D.G.       */
