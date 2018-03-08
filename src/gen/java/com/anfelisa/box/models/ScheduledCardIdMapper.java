package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ScheduledCardIdMapper implements ResultSetMapper<IScheduledCardIdModel> {
	
	public IScheduledCardIdModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ScheduledCardIdModel(
			r.getInt("scheduledCardId")
		);
	}
}

/*       S.D.G.       */
