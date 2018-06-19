package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class PasswordMapper implements ResultSetMapper<IPasswordModel> {
	
	public IPasswordModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new PasswordModel(
			r.getString("password")
		);
	}
}

/*       S.D.G.       */
