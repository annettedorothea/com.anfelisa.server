package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class ScheduledCardsMapper implements RowMapper<IScheduledCardsModel> {
	
	public IScheduledCardsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScheduledCardsModel(
			null,
			null,
			null,
			r.getTimestamp("scheduledDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scheduledDate")) : null,
			r.getString("userId"),
			r.getString("boxId")
		);
	}
}

/*       S.D.G.       */
