package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class ScheduledCardMapper implements ResultSetMapper<IScheduledCardModel> {
	
	public IScheduledCardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ScheduledCardModel(
			r.getInt("scheduledCardId"),
			r.getInt("cardId"),
			r.getFloat("ef"),
			r.getInt("interval"),
			r.getInt("n"),
			r.getInt("count"),
			new org.joda.time.DateTime(r.getDate("scheduledDate")),
			r.getInt("boxId"),
			r.getInt("lastQuality"),
			new org.joda.time.DateTime(r.getDate("timestamp"))
		);
	}
}

/*       S.D.G.       */
