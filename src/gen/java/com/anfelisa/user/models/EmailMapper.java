package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class EmailMapper implements RowMapper<IEmailModel> {
	
	public IEmailModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new EmailModel(
			r.getString("email")
		);
	}
}

/*       S.D.G.       */
