package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class UsernameMapper implements RowMapper<IUsernameModel> {
	
	public IUsernameModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UsernameModel(
			r.getString("username")
		);
	}
}

/*       S.D.G.       */
