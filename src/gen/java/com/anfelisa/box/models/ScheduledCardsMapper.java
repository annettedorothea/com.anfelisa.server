/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ScheduledCardsMapper extends AbstractMapper<ScheduledCardsModel> {
	
	public ScheduledCardsModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ScheduledCardsModel(
			null,
			null,
			null,
			this.mapToDateTime(r, "scheduledDate"),
			this.mapToString(r, "userId"),
			this.mapToString(r, "boxId"),
			this.mapToBoolean(r, "reverse")
		);
	}
}



/******* S.D.G. *******/



