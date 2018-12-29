package com.anfelisa.category.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class UserWithAccessMapper implements RowMapper<IUserWithAccessModel> {
	
	public IUserWithAccessModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new UserWithAccessModel(
			r.getString("userId"),
			r.getString("username")
		);
	}
}

/*       S.D.G.       */
