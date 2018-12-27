package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class ConfirmEmailMapper implements RowMapper<IConfirmEmailModel> {
	
	public IConfirmEmailModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ConfirmEmailModel(
			r.getString("username"),
			r.getString("token"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
