package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CardContentMapper implements ResultSetMapper<ICardContentModel> {
	
	public ICardContentModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardContentModel(
			r.getBoolean("complex"),
			r.getString("given"),
			r.getBoolean("large"),
			r.getString("wanted"),
			r.getString("header")
		);
	}
}

/*       S.D.G.       */
