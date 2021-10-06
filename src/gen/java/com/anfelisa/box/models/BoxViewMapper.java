/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class BoxViewMapper extends AbstractMapper<IBoxViewModel> {
	
	public IBoxViewModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxViewModel(
			this.mapToInteger(r, "openTodaysCards"),
			this.mapToString(r, "categoryName"),
			this.mapToString(r, "categoryAuthor"),
			this.mapToString(r, "categoryId"),
			this.mapToString(r, "boxId"),
			this.mapToBoolean(r, "shared"),
			this.mapToBoolean(r, "reverse"),
			this.mapToBoolean(r, "editable"),
			this.mapToBoolean(r, "archived")
		);
	}
}



/******* S.D.G. *******/



