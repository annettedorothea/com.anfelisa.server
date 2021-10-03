/********************************************************************************
 * generated by de.acegen 1.5.4
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class BoxArchiveMapper extends AbstractMapper<IBoxArchiveModel> {
	
	public IBoxArchiveModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new BoxArchiveModel(
			this.mapToString(r, "userId"),
			this.mapToString(r, "boxId"),
			this.mapToBoolean(r, "archived")
		);
	}
}



/******* S.D.G. *******/



