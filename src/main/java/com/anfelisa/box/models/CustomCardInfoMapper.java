package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class CustomCardInfoMapper implements ResultSetMapper<ICardInfoModel> {
	
	public ICardInfoModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new CardInfoModel(
			r.getInt("cardId"),
			r.getInt("cardOfBoxId"),
			r.getString("content"),
			r.getString("name"),
			r.getInt("count"),
			new DateTime(r.getDate("timestamp")),
			new DateTime(r.getDate("date")),
			r.getObject("quality") != null ? r.getInt("quality") : null 
		);
	}
}

/*       S.D.G.       */
