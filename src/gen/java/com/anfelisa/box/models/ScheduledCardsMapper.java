package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ScheduledCardsMapper implements ResultSetMapper<IScheduledCardsModel> {
	
	public IScheduledCardsModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ScheduledCardsModel(
			null,
			null,
			null,
			r.getTimestamp("scheduledDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scheduledDate")) : null
		);
	}
}

/*       S.D.G.       */
