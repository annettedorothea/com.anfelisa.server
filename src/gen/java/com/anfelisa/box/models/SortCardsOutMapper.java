/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class SortCardsOutMapper extends AbstractMapper<ISortCardsOutModel> {
	
	public ISortCardsOutModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new SortCardsOutModel(
			null,
			null,
			null,
			this.mapToString(r, "userId"),
			this.mapToString(r, "boxId"),
			this.mapToBoolean(r, "reverse")
		);
	}
}



/******* S.D.G. *******/



