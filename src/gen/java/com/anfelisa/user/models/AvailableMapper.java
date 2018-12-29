package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class AvailableMapper implements RowMapper<IAvailableModel> {
	
	public IAvailableModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new AvailableModel(
			r.getBoolean("available")
		);
	}
}

/*       S.D.G.       */
