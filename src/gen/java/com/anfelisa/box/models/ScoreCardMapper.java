package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class ScoreCardMapper implements RowMapper<IScoreCardModel> {
	
	public IScoreCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoreCardModel(
			r.getString("cardId"),
			r.getString("nextScheduledCardScheduledCardId"),
			r.getTimestamp("nextScheduledCardCreatedDate") != null ? new org.joda.time.DateTime(r.getTimestamp("nextScheduledCardCreatedDate")) : null,
			r.getFloat("nextScheduledCardEf"),
			r.getObject("nextScheduledCardInterval") != null ? r.getInt("nextScheduledCardInterval") : null,
			r.getObject("nextScheduledCardN") != null ? r.getInt("nextScheduledCardN") : null,
			r.getObject("nextScheduledCardCount") != null ? r.getInt("nextScheduledCardCount") : null,
			r.getTimestamp("nextScheduledCardScheduledDate") != null ? new org.joda.time.DateTime(r.getTimestamp("nextScheduledCardScheduledDate")) : null,
			r.getObject("nextScheduledCardLastQuality") != null ? r.getInt("nextScheduledCardLastQuality") : null,
			r.getString("scoredCardScheduledCardId"),
			r.getObject("scoredCardQuality") != null ? r.getInt("scoredCardQuality") : null,
			r.getTimestamp("scoredCardScoredDate") != null ? new org.joda.time.DateTime(r.getTimestamp("scoredCardScoredDate")) : null,
			r.getString("reinforceCardId"),
			r.getTimestamp("reinforceCardCreatedDate") != null ? new org.joda.time.DateTime(r.getTimestamp("reinforceCardCreatedDate")) : null,
			r.getString("userId"),
			r.getString("boxId")
		);
	}
}

/*       S.D.G.       */
