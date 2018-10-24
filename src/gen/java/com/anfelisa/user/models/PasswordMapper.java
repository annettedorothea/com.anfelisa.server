package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class PasswordMapper implements RowMapper<IPasswordModel> {
	
	public IPasswordModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new PasswordModel(
			r.getString("password")
		);
	}
}

/*       S.D.G.       */
