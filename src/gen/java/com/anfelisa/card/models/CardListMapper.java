package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CardListMapper implements ResultSetMapper<ICardListModel> {
	
	public ICardListModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardListModel(
			r.getString("categoryId"),
			r.getString("categoryName"),
			null
		);
	}
}

/*       S.D.G.       */
