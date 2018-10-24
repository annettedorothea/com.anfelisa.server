package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class CredentialsMapper implements RowMapper<ICredentialsModel> {
	
	public ICredentialsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new CredentialsModel(
			r.getString("username"),
			r.getString("role")
		);
	}
}

/*       S.D.G.       */
