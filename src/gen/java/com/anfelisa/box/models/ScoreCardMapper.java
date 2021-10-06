/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ScoreCardMapper extends AbstractMapper<IScoreCardModel> {
	
	public IScoreCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoreCardModel(
			this.mapToString(r, "cardId"),
			this.mapToString(r, "nextScheduledCardScheduledCardId"),
			this.mapToDateTime(r, "nextScheduledCardCreatedDate"),
			this.mapToFloat(r, "nextScheduledCardEf"),
			this.mapToInteger(r, "nextScheduledCardInterval"),
			this.mapToInteger(r, "nextScheduledCardN"),
			this.mapToInteger(r, "nextScheduledCardCount"),
			this.mapToDateTime(r, "nextScheduledCardScheduledDate"),
			this.mapToInteger(r, "nextScheduledCardLastQuality"),
			this.mapToString(r, "scheduledCardId"),
			this.mapToInteger(r, "scoredCardQuality"),
			this.mapToDateTime(r, "scoredCardScoredDate"),
			this.mapToString(r, "reinforceCardId"),
			this.mapToDateTime(r, "reinforceCardCreatedDate"),
			this.mapToString(r, "userId"),
			this.mapToString(r, "boxId")
		);
	}
}



/******* S.D.G. *******/



