package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class ScoredCardMapper implements ResultSetMapper<IScoredCardModel> {
	
	public IScoredCardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoredCardModel(
			r.getString("scoredCardId"),
			r.getString("cardId"),
			r.getTimestamp("scheduledDateOfScored") != null ? new org.joda.time.DateTime(r.getTimestamp("scheduledDateOfScored")) : null,
			r.getString("boxId"),
			r.getObject("quality") != null ? r.getInt("quality") : null,
			r.getTimestamp("timestamp") != null ? new org.joda.time.DateTime(r.getTimestamp("timestamp")) : null,
			r.getObject("points") != null ? r.getInt("points") : null,
			r.getString("scheduledCardId")
		);
	}
}

/*       S.D.G.       */
