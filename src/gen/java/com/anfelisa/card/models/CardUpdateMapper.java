package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CardUpdateMapper implements ResultSetMapper<ICardUpdateModel> {
	
	public ICardUpdateModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardUpdateModel(
			r.getString("cardId"),
			r.getString("given"),
			r.getString("wanted"),
			r.getString("image"),
			r.getInt("cardIndex")
		);
	}
}

/*       S.D.G.       */
