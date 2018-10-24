package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class BoxIdMapper implements RowMapper<IBoxIdModel> {
	
	public IBoxIdModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxIdModel(
			r.getString("boxId")
		);
	}
}

/*       S.D.G.       */
