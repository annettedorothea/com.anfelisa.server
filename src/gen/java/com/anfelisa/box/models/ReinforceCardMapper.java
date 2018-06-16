package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ReinforceCardMapper implements ResultSetMapper<IReinforceCardModel> {
	
	public IReinforceCardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ReinforceCardModel(
			r.getString("reinforceCardId"),
			r.getString("scheduledCardId"),
			r.getString("boxId"),
			r.getTimestamp("changeDate") != null ? new org.joda.time.DateTime(r.getTimestamp("changeDate")) : null
		);
	}
}

/*       S.D.G.       */
