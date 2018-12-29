package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class ResetPasswordMapper implements RowMapper<IResetPasswordModel> {
	
	public IResetPasswordModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ResetPasswordModel(
			r.getString("token"),
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
