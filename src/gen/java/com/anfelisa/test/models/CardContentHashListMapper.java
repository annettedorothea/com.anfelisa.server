package com.anfelisa.test.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CardContentHashListMapper implements ResultSetMapper<ICardContentHashListModel> {
	
	public ICardContentHashListModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardContentHashListModel(
			null
		);
	}
}

/*       S.D.G.       */
