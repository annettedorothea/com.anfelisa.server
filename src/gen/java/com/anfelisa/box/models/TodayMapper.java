package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class TodayMapper implements RowMapper<ITodayModel> {
	
	public ITodayModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new TodayModel(
			r.getTimestamp("today") != null ? new org.joda.time.DateTime(r.getTimestamp("today")) : null
		);
	}
}

/*       S.D.G.       */
