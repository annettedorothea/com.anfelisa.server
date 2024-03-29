/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class BoxStatisticsMapper extends AbstractMapper<BoxStatisticsModel> {
	
	public BoxStatisticsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxStatisticsModel(
			this.mapToString(r, "boxId"),
			this.mapToInteger(r, "quality0Count"),
			this.mapToInteger(r, "quality1Count"),
			this.mapToInteger(r, "quality2Count"),
			this.mapToInteger(r, "quality3Count"),
			this.mapToInteger(r, "quality4Count"),
			this.mapToInteger(r, "quality5Count"),
			this.mapToInteger(r, "cardsCount"),
			null
		);
	}
}



/******* S.D.G. *******/



