/********************************************************************************
 * generated by de.acegen
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ActiveCardListMapper extends AbstractMapper<ActiveCardListModel> {
	
	public ActiveCardListModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ActiveCardListModel(
			this.mapToString(r, "userId"),
			this.mapToString(r, "boxId"),
			null,
			this.mapToBoolean(r, "editable")
		);
	}
}



/******* S.D.G. *******/



