/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ScheduledCardMapper extends AbstractMapper<IScheduledCardModel> {
	
	public IScheduledCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScheduledCardModel(
			this.mapToString(r, "scheduledCardId"),
			this.mapToString(r, "cardId"),
			this.mapToString(r, "boxId"),
			this.mapToDateTime(r, "createdDate"),
			this.mapToFloat(r, "ef"),
			this.mapToInteger(r, "interval"),
			this.mapToInteger(r, "n"),
			this.mapToInteger(r, "count"),
			this.mapToDateTime(r, "scheduledDate"),
			this.mapToInteger(r, "lastQuality"),
			this.mapToInteger(r, "quality"),
			this.mapToDateTime(r, "scoredDate")
		);
	}
}



/******* S.D.G. *******/



