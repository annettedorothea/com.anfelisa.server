/********************************************************************************
 * generated by de.acegen 1.5.6
 ********************************************************************************/




package com.anfelisa.card.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ChangeCardOrderListMapper extends AbstractMapper<IChangeCardOrderListModel> {
	
	public IChangeCardOrderListModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ChangeCardOrderListModel(
			null,
			this.mapToString(r, "cardId"),
			this.mapToString(r, "userId"),
			null
		);
	}
}



/******* S.D.G. *******/



