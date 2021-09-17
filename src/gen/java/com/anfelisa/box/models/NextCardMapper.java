/********************************************************************************
 * generated by de.acegen 1.3.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class NextCardMapper extends AbstractMapper<INextCardModel> {
	
	public INextCardModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new NextCardModel(
			this.mapToString(r, "userId"),
			this.mapToString(r, "boxId"),
			this.mapToDateTime(r, "todayAtMidnightInUTC"),
			null,
			this.mapToBoolean(r, "reverse"),
			this.mapToInteger(r, "openTodaysCards"),
			this.mapToInteger(r, "allTodaysCards")
		);
	}
}



/******* S.D.G. *******/



