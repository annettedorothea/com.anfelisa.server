/********************************************************************************
 * generated by de.acegen 1.6.0
 ********************************************************************************/




package com.anfelisa.box.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.statement.StatementContext;

import de.acegen.AbstractMapper;

public class ReverseBoxCreationMapper extends AbstractMapper<IReverseBoxCreationModel> {
	
	public IReverseBoxCreationModel map(ResultSet r, StatementContext ctx) throws SQLException {
		return new ReverseBoxCreationModel(
			this.mapToString(r, "boxId"),
			this.mapToString(r, "username")
		);
	}
}



/******* S.D.G. *******/



