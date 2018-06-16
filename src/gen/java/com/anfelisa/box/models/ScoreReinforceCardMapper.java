package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

@SuppressWarnings("all")
public class ScoreReinforceCardMapper implements ResultSetMapper<IScoreReinforceCardModel> {
	
	public IScoreReinforceCardModel map(int index, ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoreReinforceCardModel(
			r.getString("reinforceCardId"),
			r.getObject("quality") != null ? r.getInt("quality") : null,
			r.getTimestamp("changeDate") != null ? new org.joda.time.DateTime(r.getTimestamp("changeDate")) : null
		);
	}
}

/*       S.D.G.       */
