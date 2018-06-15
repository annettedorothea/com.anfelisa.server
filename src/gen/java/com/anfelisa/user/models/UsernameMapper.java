package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class UsernameMapper implements ResultSetMapper<IUsernameModel> {
	
	public IUsernameModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new UsernameModel(
			r.getString("username")
		);
	}
}

/*       S.D.G.       */
