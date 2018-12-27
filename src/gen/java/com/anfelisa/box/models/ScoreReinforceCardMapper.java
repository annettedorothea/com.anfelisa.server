package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

@SuppressWarnings("all")
public class ScoreReinforceCardMapper implements RowMapper<IScoreReinforceCardModel> {
	
	public IScoreReinforceCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoreReinforceCardModel(
			r.getString("reinforceCardId"),
			r.getObject("quality") != null ? r.getInt("quality") : null,
			r.getTimestamp("changeDate") != null ? new org.joda.time.DateTime(r.getTimestamp("changeDate")) : null,
			r.getString("userId")
		);
	}
}

/*       S.D.G.       */
