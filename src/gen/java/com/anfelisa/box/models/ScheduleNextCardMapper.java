package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class ScheduleNextCardMapper implements RowMapper<IScheduleNextCardModel> {
	
	public IScheduleNextCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScheduleNextCardModel(
			r.getString("userId"),
			r.getString("boxId"),
			r.getString("scheduledCardId"),
			r.getString("cardId"),
			r.getTimestamp("createdDate") != null ? new org.joda.time.DateTime(r.getTimestamp("createdDate")) : null,
			r.getFloat("ef"),
			r.getObject("interval") != null ? r.getInt("interval") : null,
			r.getObject("n") != null ? r.getInt("n") : null,
			r.getObject("count") != null ? r.getInt("count") : null,
			r.getTimestamp("scheduledDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scheduledDate")) : null,
			r.getObject("lastQuality") != null ? r.getInt("lastQuality") : null,
			r.getObject("quality") != null ? r.getInt("quality") : null,
			r.getTimestamp("scoredDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scoredDate")) : null
		);
	}
}

/*       S.D.G.       */
