package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class NextReinforceCardMapper implements ResultSetMapper<INextReinforceCardModel> {
	
	public INextReinforceCardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new NextReinforceCardModel(
			r.getString("reinforceCardId"),
			r.getTimestamp("changeDate") != null ? new org.joda.time.DateTime(r.getTimestamp("changeDate")) : null,
			r.getObject("lastQuality") != null ? r.getInt("lastQuality") : null,
			r.getString("given"),
			r.getString("wanted"),
			r.getString("image")
		);
	}
}

/*       S.D.G.       */
