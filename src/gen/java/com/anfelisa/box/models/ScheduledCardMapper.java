package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ScheduledCardMapper implements ResultSetMapper<IScheduledCardModel> {
	
	public IScheduledCardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ScheduledCardModel(
			r.getString("scheduledCardId"),
			r.getString("cardId"),
			r.getFloat("ef"),
			r.getInt("interval"),
			r.getInt("n"),
			r.getInt("count"),
			r.getTimestamp("scheduledDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scheduledDate")) : null,
			r.getString("boxId"),
			r.getInt("lastQuality"),
			r.getTimestamp("timestamp") != null ? new org.joda.time.DateTime(r.getTimestamp("timestamp")) : null,
			r.getBoolean("removed")
		);
	}
}

/*       S.D.G.       */
