package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class ForgotPasswordMapper implements RowMapper<IForgotPasswordModel> {
	
	public IForgotPasswordModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ForgotPasswordModel(
			r.getString("language"),
			r.getString("email"),
			r.getString("username"),
			r.getString("token"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
