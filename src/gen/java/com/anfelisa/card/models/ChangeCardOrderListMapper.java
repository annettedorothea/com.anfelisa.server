/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ChangeCardOrderListMapper extends AbstractMapper<ChangeCardOrderListModel> {
	
	public ChangeCardOrderListModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ChangeCardOrderListModel(
			this.mapToString(r, "cardId"),
			this.mapToBoolean(r, "down"),
			this.mapToString(r, "userId"),
			null,
			null
		);
	}
}



/******* S.D.G. *******/



