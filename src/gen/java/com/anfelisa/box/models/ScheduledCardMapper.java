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
			r.getObject("interval") != null ? r.getInt("interval") : null,
			r.getObject("n") != null ? r.getInt("n") : null,
			r.getObject("count") != null ? r.getInt("count") : null,
			r.getTimestamp("scheduledDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scheduledDate")) : null,
			r.getString("boxId"),
			r.getObject("lastQuality") != null ? r.getInt("lastQuality") : null,
			r.getTimestamp("timestamp") != null ? new org.joda.time.DateTime(r.getTimestamp("timestamp")) : null,
			r.getBoolean("removed")
		);
	}
}

/*       S.D.G.       */
