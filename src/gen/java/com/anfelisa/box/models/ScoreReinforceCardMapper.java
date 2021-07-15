/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ScoreReinforceCardMapper extends AbstractMapper<IScoreReinforceCardModel> {
	
	public IScoreReinforceCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScoreReinforceCardModel(
			this.mapToString(r, "reinforceCardId"),
			this.mapToBoolean(r, "keep"),
			this.mapToDateTime(r, "changeDate"),
			this.mapToString(r, "userId")
		);
	}
}



/******* S.D.G. *******/



