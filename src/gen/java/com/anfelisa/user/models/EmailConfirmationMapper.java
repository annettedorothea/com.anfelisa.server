package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class EmailConfirmationMapper implements RowMapper<IEmailConfirmationModel> {
	
	public IEmailConfirmationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new EmailConfirmationModel(
			r.getString("token"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
