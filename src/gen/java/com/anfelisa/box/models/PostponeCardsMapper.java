package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class PostponeCardsMapper implements ResultSetMapper<IPostponeCardsModel> {
	
	public IPostponeCardsModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new PostponeCardsModel(
			r.getString("boxId"),
			r.getString("userId"),
			r.getObject("days") != null ? r.getInt("days") : null
		);
	}
}

/*       S.D.G.       */
