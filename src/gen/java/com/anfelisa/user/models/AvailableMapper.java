package com.anfelisa.user.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class AvailableMapper implements ResultSetMapper<IAvailableModel> {
	
	public IAvailableModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new AvailableModel(
			r.getBoolean("available")
		);
	}
}

/*       S.D.G.       */
