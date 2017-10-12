package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ScoredCardMapper implements ResultSetMapper<IScoredCardModel> {
	
	public IScoredCardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoredCardModel(
			r.getInt("scoredCardId"),
			r.getInt("cardId"),
			r.getTimestamp("scheduledDateOfScored") != null ? new org.joda.time.DateTime(r.getTimestamp("scheduledDateOfScored")) : null,
			r.getInt("boxId"),
			r.getInt("quality"),
			r.getTimestamp("timestamp") != null ? new org.joda.time.DateTime(r.getTimestamp("timestamp")) : null,
			r.getInt("points"),
			r.getInt("scheduledCardId")
		);
	}
}

/*       S.D.G.       */
