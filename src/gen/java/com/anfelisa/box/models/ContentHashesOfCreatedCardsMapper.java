package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class ContentHashesOfCreatedCardsMapper implements ResultSetMapper<IContentHashesOfCreatedCardsModel> {
	
	public IContentHashesOfCreatedCardsModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ContentHashesOfCreatedCardsModel(
			r.getInt("testId"),
			null,
			null
		);
	}
}

/*       S.D.G.       */
