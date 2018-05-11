package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class ReinforceCardMapper implements ResultSetMapper<IReinforceCardModel> {
	
	public IReinforceCardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ReinforceCardModel(
			r.getString("scheduledCardId"),
			r.getTimestamp("scheduledDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scheduledDate")) : null,
			r.getInt("lastQuality"),
			r.getTimestamp("timestamp") != null ? new org.joda.time.DateTime(r.getTimestamp("timestamp")) : null,
			null
		);
	}
}

/*       S.D.G.       */
