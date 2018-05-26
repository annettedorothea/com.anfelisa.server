package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.anfelisa.ace.encryption.EncryptionService;

@SuppressWarnings("all")
public class CardInfoMapper implements ResultSetMapper<ICardInfoModel> {
	
	public ICardInfoModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardInfoModel(
			r.getString("cardId"),
			r.getString("cardOfBoxId"),
			r.getString("content"),
			r.getString("boxName"),
			r.getObject("count") != null ? r.getInt("count") : null,
			r.getTimestamp("last") != null ? new org.joda.time.DateTime(r.getTimestamp("last")) : null,
			r.getTimestamp("next") != null ? new org.joda.time.DateTime(r.getTimestamp("next")) : null,
			r.getObject("quality") != null ? r.getInt("quality") : null
		);
	}
}

/*       S.D.G.       */
