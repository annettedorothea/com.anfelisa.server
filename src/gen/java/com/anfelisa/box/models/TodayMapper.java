package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class TodayMapper implements ResultSetMapper<ITodayModel> {
	
	public ITodayModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new TodayModel(
			r.getTimestamp("today") != null ? new org.joda.time.DateTime(r.getTimestamp("today")) : null
		);
	}
}

/*       S.D.G.       */
